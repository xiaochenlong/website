package vip.ace.admin.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import vip.ace.admin.security.AuthoritiesUserDetailsChecker;
import vip.ace.admin.security.URLAccessDecisionManager;
import vip.ace.admin.security.URLFilterInvocationSecurityMetadataSource;
import vip.ace.admin.security.URLFilterSecurityInterceptor;

import javax.servlet.Filter;

/**
 * Created by xcl on 2017/3/22.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    //加密工具
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //登陆之后授权
    @Autowired
    public UserDetailsChecker authoritiesUserDetailsChecker;

    public final static String LoginUrl = "/admin/login";
    public final static String LoginOutUrl = "/admin/logout";
    public final static String LoginProcessingUrl = "/admin/dologin";
    public final static String LoginSuccessUrl = "/admin";



    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterAfter(filterSecurityInterceptor(), FilterSecurityInterceptor.class);

        http.authorizeRequests().antMatchers("/css/**").permitAll()
                .anyRequest().fullyAuthenticated();
        http.formLogin()
                .loginPage(LoginUrl)
                .failureUrl(LoginUrl + "?error")
                .loginProcessingUrl(LoginProcessingUrl)
                .failureHandler(authenticationFailureHandler())
                .successHandler(authenticationSuccessHandler())
                .permitAll();

        http.logout().logoutUrl(LoginOutUrl).permitAll();


        http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    //获取用户及权限Provider
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPostAuthenticationChecks(authoritiesUserDetailsChecker);
        return daoAuthenticationProvider;
    }

    //判断是否拥有所请求资源的权限
    @Bean
    public URLAccessDecisionManager securityAccessDecisionManager() {
        return new URLAccessDecisionManager();
    }

    //获取权限集合
    @Bean
    public URLFilterInvocationSecurityMetadataSource securityFilterInvocationSecurityMetadataSource() {
        return new URLFilterInvocationSecurityMetadataSource();
    }

    //自定义的权限验证
    public Filter filterSecurityInterceptor() throws Exception {
        URLFilterSecurityInterceptor filterSecurityInterceptor = new URLFilterSecurityInterceptor();
        //权限判断
        filterSecurityInterceptor.setAccessDecisionManager(securityAccessDecisionManager());
        //获取需要的权限
        filterSecurityInterceptor.setSecurityMetadataSource(securityFilterInvocationSecurityMetadataSource());
        //定义拦截器的组件检查
        filterSecurityInterceptor.afterPropertiesSet();
        return filterSecurityInterceptor;
    }

    // 登陆成功处理
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler success = new SavedRequestAwareAuthenticationSuccessHandler();
        success.setAlwaysUseDefaultTargetUrl(true);
        success.setDefaultTargetUrl(LoginSuccessUrl);
        return success;
    }

    //登录失败处理
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler(LoginUrl + "?error");
        handler.setUseForward(false);
        return handler;
    }

}
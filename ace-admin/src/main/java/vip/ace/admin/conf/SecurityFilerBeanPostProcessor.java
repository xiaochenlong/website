package vip.ace.admin.conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.stereotype.Component;


/**
 * Created by xcl on 2017/3/24.
 */
@Component
public class SecurityFilerBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof DelegatingFilterProxyRegistrationBean){
            DelegatingFilterProxyRegistrationBean tar = (DelegatingFilterProxyRegistrationBean) bean;
            //tar.setUrlPatterns(Arrays.asList(new String[] {"/admin/*"}));
        }
        if("springSecurityFilterChain".equalsIgnoreCase(beanName)){
            System.out.println(bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

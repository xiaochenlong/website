package vip.ace.admin.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import vip.ace.admin.conf.ApplicationSecurity;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xcl on 16/9/27.
 * 获取所有的权限或者根据资获取权限
 */
public class URLFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {



    /**
     * 用户获取正在访问的资源所对应的权限
     */

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation)object).getRequest();
        String url = request.getRequestURI();
        System.out.println("获取请求url资源需要的权限******"+url);
        if(ApplicationSecurity.LoginUrl.equals(url)){
            return null;
        }
        List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();

        if(url.startsWith("/admin")){
            list.add(new SecurityConfig("ROLE_USER"));
        }

        return list;
    }

    /**
     * 获取所有权限配置属性
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        List<ConfigAttribute> _list = new ArrayList<ConfigAttribute>();
        return _list;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

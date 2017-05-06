package vip.ace.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import vip.ace.admin.conf.ApplicationSecurity;
import vip.ace.admin.domian.SysAuthorities;
import vip.ace.admin.domian.SysAuthoritiesCriteria;
import vip.ace.admin.service.SysAuthoritiesService;
import vip.ace.admin.service.SysResourcesService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by xcl on 16/9/27.
 * 获取所有的权限或者根据资获取权限
 */

public class URLFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


    @Autowired
    private SysAuthoritiesService sysAuthoritiesService;

    @Autowired
    private  SysResourcesService sysResourcesService;

    /**
     * 用户获取正在访问的资源所对应的权限
     */

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation)object).getRequest();
        String url = request.getRequestURI();
        if(ApplicationSecurity.LoginUrl.equals(url)){
            return null;
        }
        System.out.println("获取请求url资源需要的权限******"+url);
        List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
        Set<Integer> auths = sysResourcesService.listAuthoritiesIdByResource(url);
        for(Integer a:auths){
            list.add(new SecurityConfig(a.toString()));
        }
        return list;
    }

    /**
     * 获取所有权限配置属性
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        List<SysAuthorities> all = sysAuthoritiesService.list(new SysAuthoritiesCriteria());
        List<ConfigAttribute> _list = new ArrayList<ConfigAttribute>();
        for(SysAuthorities a:all){
            _list.add(new SecurityConfig(a.getAuthorityId().toString()));
        }
        return _list;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

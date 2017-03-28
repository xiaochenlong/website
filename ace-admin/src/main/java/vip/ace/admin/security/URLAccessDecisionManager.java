package vip.ace.admin.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import vip.ace.admin.service.SysAuthoritiesService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by xcl on 16/9/27.
 * 权限验证
 */

public class URLAccessDecisionManager implements AccessDecisionManager {


    private static Logger logger = LoggerFactory.getLogger(URLAccessDecisionManager.class);



    /**
     * 验证 authentication是否有访问object的权限
     * @param authentication 验证对象
     * @param object     URL
     * @param collection 访问object的权限集合
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("------"+object.toString());
        System.out.println("******"+collection);
        System.out.print(authentication.getAuthorities());
        if (collection == null) {
            return;
        }
        logger.info("正在访问的url是："+object.toString());
        //拥有的权限
        Collection<? extends GrantedAuthority> uite = authentication.getAuthorities();
        HashSet<String> has = new HashSet<String>();
        for (GrantedAuthority ga : uite) {
            has.add(ga.getAuthority());
        }

        //需要的权限
        Iterator<ConfigAttribute> ite = collection.iterator();
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needRole = ca.getAttribute();
            if(has.contains(needRole)){
                continue;
            }else{
                throw new AccessDeniedException("没有权限");
            }

        }

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

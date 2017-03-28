package vip.ace.admin.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by xcl on 16/8/3.
 *
 *
 *
 <dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-aop</artifactId>
 </dependency>

 */

@Aspect
@Component
public class ServiceMonitor {

    @AfterReturning("execution(* vip.ace.admin.service.impl.*Impl.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);

    }

}

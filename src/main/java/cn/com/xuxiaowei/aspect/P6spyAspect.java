package cn.com.xuxiaowei.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * {@link RestController}、{@link Service}、{@link Mapper} 接口切面
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Aspect
@Component
public class P6spyAspect {

    public static final String P6SPY_UUID = "P6spy_UUID";

    public static final String P6SPY_CONTROLLER = "P6spy_Controller";

    public static final String P6SPY_SERVICE = "P6spy_Service";

    public static final String P6SPY_MAPPER = "P6spy_Mapper";

    /**
     * Controller 切点
     */
    @Pointcut("execution(* cn.com.xuxiaowei.controller.*.*(..))")
    public void pointcutController() {

    }

    /**
     * Service 切点
     */
    @Pointcut("execution(* cn.com.xuxiaowei.service.impl.*.*(..))")
    public void pointcutService() {

    }

    /**
     * Mapper 切点
     */
    @Pointcut("execution(* cn.com.xuxiaowei.mapper.*.*(..))")
    public void pointcutMapper() {

    }

    /**
     * Controller 前置通知
     *
     * @param joinPoint 方法信息
     */
    @Before("pointcutController()")
    public void beforeController(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String method = signature.getMethod().toString();

        String uuid = UUID.randomUUID().toString();

        MDC.put(P6SPY_UUID, uuid);

        log.info("{}：{}：{}", MDC.get(P6SPY_UUID), P6spyAspect.P6SPY_CONTROLLER, method);
    }

    /**
     * Service 前置通知
     *
     * @param joinPoint 方法信息
     */
    @Before("pointcutService()")
    public void beforeService(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String method = signature.getMethod().toString();

        log.info("{}：{}：{}", MDC.get(P6SPY_UUID), P6spyAspect.P6SPY_SERVICE, method);
    }

    /**
     * Mapper 前置通知
     *
     * @param joinPoint 方法信息
     */
    @Before("pointcutMapper()")
    public void beforeMapper(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String method = signature.getMethod().toString();

        log.info("{}：{}：{}", MDC.get(P6SPY_UUID), P6spyAspect.P6SPY_MAPPER, method);
    }

}

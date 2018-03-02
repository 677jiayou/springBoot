package com.example.demo.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {
    //    Log4J的三个组件：
//    Logger：日志记录器，负责收集处理日志记录     （如何处理日志）
//    Appender：日志输出目的地，负责日志的输出  （输出到什么 地方）
//    Layout：日志格式化，负责对输出的日志格式化（以什么形式展现）
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    //设置切面,这里不需要有具体属性和方法
    @Pointcut("execution(public * com.example.demo.Repository..*(..))")
    public void cut() {
    }

    //controller中所有的方法在执行前都会调用以下日志记录
    @Before("cut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("controller-begining------------------------");
        //日志输出发出请求的ip地址
        logger.info("ip={}", request.getRemoteAddr());
        //日志输出请求的路径
        logger.info("url={}", request.getRequestURI());
        //日志输出全限定类名方法名
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + '.' +
                joinPoint.getSignature().getName());
        //日志输出请求的参数
        logger.info("args={}", joinPoint.getArgs());
        //日志输出请求的方法（“post","get"）
        logger.info("method={}", request.getMethod());
    }

    //controller中所有的方法在执行后都会调用以下日志记录
    @After("cut()")
    public void doAfter() {
        logger.info("controller-end------------------------");
    }

    //日志记录controller中所对应的方法在执行完的返回值
    @AfterReturning(returning = "obj", pointcut = "cut()")
    public void doAfterReturning(Object obj) {
        logger.info("此controller方法返回值:-------------------");

        if (obj != null) {
            logger.info("response={}", obj.toString());
        } else {
            logger.info("response={}", "null");
        }
        logger.info("--------------------------------------");
    }


    @Pointcut("execution(public * com.example.demo.service..*(..))")
    public void servicecut() {
    }

    @Before("servicecut()")
    public void serviceBerfore(JoinPoint joinPoint) {
        logger.info("service-begining------------------------");
        //日志输出全限定类名方法名
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + '.' + joinPoint.getSignature().getName());
        //日志输出请求的参数
        logger.info("args={}", joinPoint.getArgs());
    }

    //service中所有的方法在执行后都会调用以下日志记录
    @After("servicecut()")
    public void serviceAfter() {
        logger.info("controller-end------------------------");
    }

    //日志记录service中所对应的方法在执行完的返回值
    @AfterReturning(returning = "object", pointcut = "servicecut()")
    public void doServiceAfterReturning(Object object) {
        logger.info("此service方法返回值:-------------------");
        if (object != null) {
            logger.info("response={}", object.toString());
        } else {
            logger.info("response={}", "null");
        }
        logger.info("--------------------------------------");
    }


}

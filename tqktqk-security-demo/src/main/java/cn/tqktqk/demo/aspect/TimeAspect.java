package cn.tqktqk.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ___________ ________     ____  __.
 * \__    ___/ \_____  \   |    |/ _|
 * |    |     /  / \  \  |      <
 * |    |    /   \_/.  \ |    |  \
 * |____|    \_____\ \_/ |____|__ \
 *
 * @Author: tuqikang
 * @Date: 2019-04-12 22:57
 */
@Aspect
@Component
public class TimeAspect {

    @Pointcut("@annotation(cn.tqktqk.demo.aspect.config.TimeLog)")
    public void pointcut(){}


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object result=null;
        long start = System.currentTimeMillis();
        try {
            /**
             * 执行被拦截的方法
             */
            result = point.proceed();
            long end = System.currentTimeMillis();
            displayLog(point,1l);
            System.out.println("aspect 耗时："+(end-start)+"ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    private void displayLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature)point.getSignature();

        String className = point.getTarget().getClass().getName();
        System.out.println("Aspect 拦截的类名："+className);
        Method method = signature.getMethod();
        System.out.println("Aspect 拦截的方法："+method.getName());
        String args = Arrays.toString(point.getArgs());
        System.out.println("参数："+args);
    }
}

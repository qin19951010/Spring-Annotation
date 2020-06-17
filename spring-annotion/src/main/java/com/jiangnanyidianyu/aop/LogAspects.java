package com.jiangnanyidianyu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

//切面类
//日志切面类
//@Aspect告诉Spring当前类是一个切面类

@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用  ==> @Before("pointCut()")
    //2.其他的切面引用
    @Pointcut("execution(public int com.jiangnanyidianyu.aop.MathCalculator.*(..))")
    public void pointCut()
    {

    }

    //@Before在目标方法之前切入;切入点表达式(指定在哪个方法切入)
    //@Before("public int com.jiangnanyidianyu.aop.MathCalculator.div(int,int)")
    //MathCalculator类下的所有方法,参数类型任意
    //@Before("public int com.jiangnanyidianyu.aop.MathCalculator.*(..)")

    //joinPoint必须出现在参数的第一位
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"运行...@Before:参数列表是:{"+ Arrays.asList(args) +"}");
    }
    @After("com.jiangnanyidianyu.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"结束...@After");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"正常返回...运行结果是:{"+result+"}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"异常...异常信息:{"+exception+"}");
    }
}

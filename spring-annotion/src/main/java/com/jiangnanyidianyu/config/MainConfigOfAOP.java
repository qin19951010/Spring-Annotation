package com.jiangnanyidianyu.config;

import com.jiangnanyidianyu.aop.LogAspects;
import com.jiangnanyidianyu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
    AOP:[动态代理]
        指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式;

    1.导入AOP模块:Spring AOP:(spring-aspects)
    2.定义一个业务逻辑类(MathCaculator);在业务逻辑运行的时候将日志进行打印(方法之前,方法运行结束,方法出现异常,xxx)
    3.定义一个日志切面类(LogAspects):切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行;
        通知方法:
            前置通知(@Before):logStart:目标方法(div)运行之前
            后置通知(@After):logEnd:目标方法(div)运行之后(无论是否正常结束都执行)
            返回通知(@AfterReturning):logReturn:目标方法(div)正常返回之后运行
            异常通知(@AfterThrowing):logException:目标方法(div)出现异常以后运行
          **环绕通知(@Around):动态代理,手动推进目标方法运行(joinPoint.procced())
    4.给切面类的目标方法标注何时何地运行(通知注解)
  **5.将切面类和业务逻辑类(目标方法所在类)都加入到容器中
  **6.必须告诉Spring哪个类是切面类(给切面类上加一个注解@Aspect)
   [7].给配置类中加@EnableAspectJAutoProxy(开启基于注解的aop模式)
        在Spring中很多的@EnableXXX

   三步:
   1).将业务逻辑组件和切面类都要加载到IOC容器中;告诉Spring哪个是切面类(@Aspect)
   2).在切面类上的每一个通知方法标注通知注解,告诉Spring何时何地运行(切入点表达式)
   3).开启基于注解的AOP模式:@EnableAspectJAutoProxy
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    //业务逻辑类加入到容器中
    @Bean
    public MathCalculator calculator()
    {
        return new MathCalculator();
    }

    @Bean
    //切面类加入到容器中
    public LogAspects logAspects()
    {
        return new LogAspects();
    }
}

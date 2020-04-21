package interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * 通过@Intercepts标识拦截器
 * type拦截指定核心对象(StatementHandler,Executor,ParameterHandler,ResultSetHandler)
 * method拦截指定对象的指定方法方法
 * arg拦截方法的参数(指明有可能存在重载)
 * 最后需要配置拦截器
 **/
//StatementHandler对statement的操作如设置参数
@Intercepts({@Signature(type = StatementHandler.class,
        method = "query", args = {Statement.class, ResultHandler.class})})
public class MyInterceptor2 implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截方法二");
        Object proceed = invocation.proceed();//放行
        System.out.println("+++++++>"+proceed);
        return proceed;
    }

    public Object plugin(Object target) {//将拦截器中的定义的增强功能和原来的核心对象合并起来,称为最总的核心对象
        //将拦截器与核心功能绑定返回
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        //通过配置文件将自定的属性传给mybatis
        System.out.println("设置属性+++++++"+properties);
    }
}

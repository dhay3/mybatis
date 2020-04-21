package interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

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
//parameterize是拦截参数的方法
@Intercepts({@Signature(type = StatementHandler.class,
        method = "parameterize", args = {Statement.class})})
public class MyInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
//        System.out.println("拦截方法一");
        Object target = invocation.getTarget();//获取目标RoutingStatementHandler
        System.out.println("target"+target);
        MetaObject metaObject = SystemMetaObject.forObject(target);//metaObject可以从target中取
        System.out.println("metaObject"+metaObject);
        //可以取出parameterHandler(参数)和boundSql(sql)
        Object value = metaObject.getValue("parameterHandler.parameterObject");//从目标RoutingStatementHandler取出参数
        System.out.println(value+"------------");
        metaObject.setValue("parameterHandler.parameterObject",43);
        value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println(value);
        Object proceed = invocation.proceed();//放行
        System.out.println("------>"+proceed);
        return proceed;
    }
    //target就是核心对象
    public Object plugin(Object target) {//将拦截器中的定义的增强功能和原来的核心对象合并起来,称为最总的核心对象
        //将拦截器与核心功能绑定返回
        Object wrap = Plugin.wrap(target, this);
        System.out.println(wrap);
        return wrap;
    }

    public void setProperties(Properties properties) {
        //通过配置文件将自定的属性传给mybatis
        System.out.println("设置属性-------"+properties);
    }
}

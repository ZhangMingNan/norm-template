package com.neusoft.norm.log.aop;

import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.log.annotations.Log;
import com.neusoft.norm.shiro.ShiroUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * 作者: 张明楠 创建于 16/12/16.
 */
public class LogAspect {

    private Logger loger;

    @Around(value = "@annotation(com.neusoft.norm.log.annotations.Log)")
    public Object saveLog(ProceedingJoinPoint point) throws Throwable {

        String cname = point.getSignature().getClass().getSimpleName();

        String mname = point.getSignature().getName();
        Object[] args = point.getArgs();

        Class[] pTypes = new Class[args.length];
        for (int i=0;i<args.length;i++){
            pTypes[i] = args[i].getClass();
        }

        Method method = ReflectionUtils.findMethod(point.getTarget().getClass(), mname, pTypes);

        Log log = method.getAnnotation(Log.class);
        String oname = null;
        if (log!=null){
             oname = log.value();
        }
        //HttpServletRequest request = getHttpServletRequest();
        //这里是和shiro整合.
        Subject subject = ShiroUtils.getSubject();
        Admin admin = (Admin) subject.getPrincipal();
        loger.writeLog(admin,oname,cname,mname,args);
        return point.proceed();
    }

    private Method currentMethod(ProceedingJoinPoint joinPoint, String mname) {
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        Method resultMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(mname)) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }



    public Logger getLoger() {
        return loger;
    }

    public void setLoger(Logger loger) {
        this.loger = loger;
    }
}

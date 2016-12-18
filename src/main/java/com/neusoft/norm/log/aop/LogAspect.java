package com.neusoft.norm.log.aop;

import com.google.common.collect.Lists;
import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.log.annotations.Log;
import com.neusoft.norm.shiro.ShiroUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;

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
        int a = 1/0;
        return point.proceed();
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = Lists.newArrayList(1,4);
        ArrayList<Integer> b = Lists.newArrayList(1,2);

        System.out.println(
                ListUtils.isEqualList(a,b));
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

    //public static HttpServletRequest getHttpServletRequest() {
    //    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    //}

    public Logger getLoger() {
        return loger;
    }

    public void setLoger(Logger loger) {
        this.loger = loger;
    }
}

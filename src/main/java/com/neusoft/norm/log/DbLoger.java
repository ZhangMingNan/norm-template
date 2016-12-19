package com.neusoft.norm.log;

import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.domain.OperationLog;
import com.neusoft.norm.log.aop.Logger;
import com.neusoft.norm.mapper.OperationLogMapper;
import com.neusoft.norm.utils.HttpRequestUtils;
import com.neusoft.norm.utils.IpUtils;
import eu.bitwalker.useragentutils.UserAgent;
import jodd.util.ArraysUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 作者: 张明楠 创建于 16/12/18.
 */
public class DbLoger implements Logger{

    @Autowired
    OperationLogMapper operationLogMapper;

    @Override
    public void writeLog(Admin admin, String oname,String cname, String mname, Object[] args) {
        OperationLog log = new OperationLog();
        log.setMethod(cname+"."+mname);
        log.setOperation(oname);
        log.setParams(ArraysUtil.toString(args));
        log.setUserid(admin.getUserid());
        log.setCreateTime(new Date());
        HttpServletRequest request = HttpRequestUtils.getHttpServletRequest();
        log.setIp(IpUtils.getIpByRequest(request));
        //UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        log.setUserAgent(request.getHeader("User-Agent"));
        operationLogMapper.insert(log);
    }

}

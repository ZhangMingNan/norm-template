package com.neusoft.norm.log.aop;

import com.neusoft.norm.domain.Admin;

/**
 * 作者: 张明楠 创建于 16/12/16.
 */
public interface Logger {
    void writeLog(Admin admin,String oname, String cname, String mname, Object[] args);
}

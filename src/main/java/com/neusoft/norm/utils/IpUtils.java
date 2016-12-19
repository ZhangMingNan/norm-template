package com.neusoft.norm.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * IP工具类
 * 
 * @author
 * 
 */
public class IpUtils {
	/**
	 * @param request
	 *            IP
	 * @return IP Address
	 */
	public static String getIpByRequest(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return "0:0:0:0:0:0:0:1".equals(ip)?"127.0.0.1":ip;
	}


}

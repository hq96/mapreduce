/**   
 * Copyright © 2017 SOF . Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: 
 * com.sof.sales.core.url 
 * @author: 
 * aaron   
 * @date: 
 * 2017年4月17日 下午2:41:44 
 */
package com.sof.sales.core.url;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class UrlString {

	String url = null;

	/**
	 * UrlString.java 该函数的功能描述
	 *
	 * @param url
	 * @version v1.0.0
	 * @author Aaron
	 */
	public UrlString(String url) {
		this.url = url;
	}

	/**
	 * UrlString.java url中的host信息
	 * 
	 * @return String host
	 * @version v1.0.0
	 * @author Aaron
	 */
	public static String getHost(String url) {
		if (!(StringUtils.startsWithIgnoreCase(url, "http://") || StringUtils.startsWithIgnoreCase(url, "https://"))) {
			url = "http://" + url;
		}
		String returnVal = StringUtils.EMPTY;
		try {
			URI uri = new URI(url);
			returnVal = uri.getHost();
		} catch (Exception e) {
		}
		if ((StringUtils.endsWithIgnoreCase(returnVal, ".html") || StringUtils.endsWithIgnoreCase(returnVal, ".htm"))) {
			returnVal = StringUtils.EMPTY;
		}
		return returnVal;
	}

	public static String getRootDomain(String url) throws URISyntaxException {
		if (!(StringUtils.startsWithIgnoreCase(url, "http://") || StringUtils.startsWithIgnoreCase(url, "https://"))) {
			url = "http://" + url;
		}
		URI uri = new URI(url);
		String domain = uri.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	public static String getHostDomain(String url) {
		if (!(StringUtils.startsWithIgnoreCase(url, "http://") || StringUtils.startsWithIgnoreCase(url, "https://"))) {
			url = "http://" + url;
		}
		String domain = "";
		Pattern pattern = Pattern
				.compile("[\\w-]+\\.(com.cn|net.cn|gov.cn|org.cn|com|net|org|gov|cc|biz|info|cn|co)\\b()*");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			domain = matcher.group();
		}
		if (domain == null || domain.trim().equals(""))
			return null;
		else {
			return domain;
		}
	}
}
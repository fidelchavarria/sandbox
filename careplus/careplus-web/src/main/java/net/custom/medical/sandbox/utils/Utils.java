package net.custom.medical.sandbox.utils;

import org.apache.commons.lang.StringUtils;

public class Utils {

	public static final String buildPath(Class<?> clazz){
	 if (clazz != null)
		return "/" + clazz.getName().replaceAll("\\.", "/").toLowerCase();
	 throw new IllegalArgumentException("Clazz value can't be null");
	}
	
	public static final String buildPath(Class<?> clazz, final String page){
		 if (clazz != null && !StringUtils.isEmpty(page))
			 return buildPath(clazz) + "/"+ page;
		throw new IllegalArgumentException("Clazz or page value can't be null");
	}
}

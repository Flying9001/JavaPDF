package com.ljq.utils;

import java.io.File;

public class PathUtil {

	/**
	 * 返回项目的绝对路径
	 * */
	public static String getPath() {
		File file=new File("");
		String path=file.getAbsolutePath(); 
		return path;
	}
	
}

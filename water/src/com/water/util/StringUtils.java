package com.water.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 字符串工具类
 * 
 * @author Administrator
 * 
 */
public class StringUtils {

	/**
	 * 生成新的文件名<br>
	 * 
	 * @param fileName
	 * @return
	 */
	public static String generateRandomFileName(String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date())
				+ System.nanoTime()
				+ new Random().nextInt(1000) + ext;
		return newFileName;
	}

}

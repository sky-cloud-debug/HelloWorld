package com.water.common.util;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * 
 * 类名: LogUtils<BR>
 * 描述: 日志工具类<BR>
 * 创建人:翟旭光 <BR>
 * 时间：2016年4月17日-下午4:56:13 <BR>
 * @version 1.0
 */
public class LogUtils {

	private static final Logger logger=Logger.getLogger(LogUtils.class);

	public static void debug(String msg){
		logger.debug(msg);
	}

	public static void info(String msg){
		logger.info(msg);
	}
	
	public static void warn(String msg){
		logger.warn(msg);
	}

	public static void error(String msg){
		logger.error(msg);
	}
}

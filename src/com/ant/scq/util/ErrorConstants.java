package com.ant.scq.util;

/**
 * 常量定义类
 * 
 * @author super
 *
 */
public class ErrorConstants {
	/** 成功 */
	public final static String SUCCESS = "00000";
	/** 失败 */
	public final static String FAILURE = "10000";
	/** 无此服务名 */
	public final static String NO_FIND_SERVICE_NAME = "10001";
	/** json参数转换为java对象出错 */
	public final static String JSON_TRANSFORM_JAVA_ERR = "10002";
	/** 用户密码错误/异常 */
	public final static String AUTHENTICATION_ERR = "10003";
	/** 权限异常 */
	public final static String POWER_ERR = "10004";
	/** 请求数据包体的有效性验证错误！ */
	public final static String REQUEST_DATA_SAFE_ERR = "10005";
	/** 数据处理异常！ */
	public final static String DATA_ERR = "10006";
	/** 业务逻辑处理错误 */
	public final static String BUSINESS_HANDLE_ERR = "99999";

	/** 启用 */
	public final static int START_STATUS = 0;
	/** 停用 */
	public final static int STOP_STATUS = 1;
}

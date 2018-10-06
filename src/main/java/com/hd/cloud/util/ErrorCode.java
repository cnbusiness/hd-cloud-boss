package com.hd.cloud.util;

/**
 * 
 * @ClassName: ErrorCode
 * @Description: 错误码
 * @author ShengHao shenghaohao@hadoop-tech.com
 * @Company hadoop-tech
 * @date 2017年11月20日 下午5:27:10
 *
 */
public class ErrorCode {

	// 用户名和密码不能为空
	public final static String USERNAME_PASSWORD_EMPTY = "hd0030001";

	// 用户名或密码错误
	public final static String USERNAME_OR_PASSWORD_ERROR = "hd0030002";

	// 该电话未注册
	public final static String PHONE_NOT_REGISTERED = "hd0030003";

	// 请输入电话号码
	public final static String PHONE_EMPTY = "hd0030004";

	// userId不能为空
	public final static String USERID_IS_EMPTY = "hd0030005";

	// token不能为空
	public final static String TOKEN_IS_EMPTY = "hd0030006";

	// token验证失败
	public final static String TOKEN_FAIL = "hd0030007";
	
	/**
	 * 手机号码格式错误
	 */
	public final static String PHONE_FORMAT_ERROR = "hd0010008";

	/**
	 * 验证码为空
	 */
	public final static String CAPTCHA_EMPTY_ERROR = "hd0010009";

	/**
	 * 账号密码为空
	 */
	public final static String ACCOUNT_PWD_EMPTY_ERROR = "hd0010010";

	/**
	 * 密码不能为中文
	 */
	public final static String PASSWORD_IS_CHINESE_ERROR = "hd0010011";

	/**
	 * 密码不一致
	 */
	public final static String PWD_NOT_SAME_ERROR = "hd0010012";

	/**
	 * 验证码不匹配
	 */
	public final static String CAPTCHA_NOT_MATCH_ERROR = "hd0010013";

	/**
	 * 验证码已过期
	 */
	public final static String SEND_VALID_TIME_ERROR = "hd0010014";

	/**
	 * 账号不存在，未注册
	 */
	public final static String ACCOUNT_IS_NOT_EXIST = "hd0010015";

	/**
	 * 该账号已经注册啦~
	 */
	public final static String REGISTER_ERROR = "hd0010016";

	/**
	 * 账号注册失败
	 */
	public final static String ACCOUN_REGISTED_ERROR = "hd0010017";

	/**
	 * 发送验证码错误
	 */
	public final static String SEND_REG_CAPTHCA_ERROR = "hd0010018";

	/**
	 * 每天发送限制
	 */
	public final static String SEND_DAY_LIMIT_ERROR = "hd0010019";

	/**
	 * 一分钟内已经发送过了
	 */
	public final static String SEND_ONE_MINUTE_LIMIT_ERROR = "hd0010020";
	
	/**
	 * 该手机号码已经绑定
	 */
	public final static String PHONE_IS_BINDING = "hd0010021";
	
	
	/**
	 * 修改密码失败
	 */
	public final static String UPDATE_PASSWORDA_FAIL ="hd0010022";
}

package com.hmkj.taozhifu.pay;

import android.text.TextUtils;

/**
 * 支付宝支付结果
 * @user： zhangyonghong
 * @Date2016年9月13日：2016年9月13日  下午4:01:48
 * Copyright-2016 @宏铭科技
 */
public class PayResult {
	private String resultStatus;
	private String result;
	private String memo;

	public PayResult(String rawResult) {

		if (TextUtils.isEmpty(rawResult))
			return;

		String[] resultParams = rawResult.split(";");
		for (String resultParam : resultParams) {
			if (resultParam.startsWith("resultStatus")) {
				resultStatus = gatValue(resultParam, "resultStatus");
			}
			if (resultParam.startsWith("result")) {
				result = gatValue(resultParam, "result");
			}
			if (resultParam.startsWith("memo")) {
				memo = gatValue(resultParam, "memo");
			}
		}
	}

	@Override
	public String toString() {
		return "resultStatus={" + resultStatus + "};memo={" + memo
				+ "};result={" + result + "}";
	}

	private String gatValue(String content, String key) {
		String prefix = key + "={";
		return content.substring(content.indexOf(prefix) + prefix.length(),
				content.lastIndexOf("}"));
	}

	/**
	 * @return the resultStatus
	 */
	public String getResultStatus() {
		return resultStatus;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
}
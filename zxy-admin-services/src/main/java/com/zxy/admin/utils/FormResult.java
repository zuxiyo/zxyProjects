/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月13日下午5:31:22
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月13日下午5:31:22
 */
package com.zxy.admin.utils;

/**
 * 表单提交后返回的结果
 * @author Zhu XiYong 
 * @Date 2016年9月13日下午5:31:22
 */
public class FormResult {
	private boolean success = false;
	private String message;
	/**
	 * 是否成功
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * 设置是否成功
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * 提示消息
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 设置提示消息
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}

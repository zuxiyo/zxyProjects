/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年12月7日 下午4:00:31
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年12月7日 下午4:00:31
 */
package com.zxy.admin.api.utils;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

/**
 * WebApi 的返回值
 * @author ZhuXY 
 * @date 2016年12月7日 下午4:00:31 
 */
public class FromResult {
	private HttpStatus _status;
	private String _message;
	private String _description;
	private Object _data;
	/**
	 * 状态
	 * @return the _status
	 */
	public int getStatus() {
		return _status.value();
	}
	
	/**
	 * 状态
	 * @param _status the _status to set
	 */
	public void setStatus(HttpStatus _status) {
		this._status = _status;
	}
	/**
	 * 信息
	 * @return the _message
	 */
	public String getMessage() {
		return _message;
	}
	/**
	 * 信息
	 * @param _message the _message to set
	 */
	public void setMessage(String _message) {
		this._message = _message;
	}
	/**
	 * 数据
	 * @return the _data
	 */
	public Object getData() {
		return _data;
	}
	/**
	 * 数据
	 * @param _data the _data to set
	 */
	public void setData(Object _data) {
		this._data = _data;
	}
	
	/**
	 * 描述
	 * @return the _description
	 */
	public String getDescription() {
		return _description;
	}
	
	/**
	 * 描述
	 * @param _description the _description to set
	 */
	public void setDescription(String _description) {
		this._description = _description;
	}

	/**
	 * HTTP状态码
	 * @return the _statusCode
	 */
	public HttpStatus getHttpStatus() {
		return this._status;
	}

	/**
	 * 时间戳
	 * @return the _timestamp
	 */
	public Timestamp getTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}

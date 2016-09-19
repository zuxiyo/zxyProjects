/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月6日下午11:00:06
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月6日下午11:00:06
 */
package com.zxy.admin.controllers.utils;

/**
 * jquery.dataTables.js的分页参数
 * 
 * @author Zhu XiYong 
 * @Date 2016年9月6日下午11:00:06
 */
public class DataTablesPageable{

	private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private Iterable<?> data;
	/**
	 * @return the draw
	 */
	public int getDraw() {
		return draw;
	}
	/**
	 * @param draw the draw to set
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}
	/**
	 * @return the recordsTotal
	 */
	public long getRecordsTotal() {
		return recordsTotal;
	}
	/**
	 * @param recordsTotal the recordsTotal to set
	 */
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	/**
	 * @return the recordsFiltered
	 */
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	/**
	 * @param recordsFiltered the recordsFiltered to set
	 */
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	/**
	 * @return the data
	 */
	public Iterable<?> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Iterable<?> data) {
		this.data = data;
	}
	
}

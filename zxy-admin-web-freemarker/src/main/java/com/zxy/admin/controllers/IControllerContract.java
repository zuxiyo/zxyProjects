package com.zxy.admin.controllers;

import org.springframework.web.servlet.ModelAndView;

/**
 * 接口契约，所有Controller需遵守
 * @author Zhu XiYong
 *
 */
public interface IControllerContract {

	/**
	 * 主页面
	 * @return 主页地址
	 */
	public String index();
	/**
	 * 新增页面
	 * @return 新增页面地址
	 */
	public ModelAndView addView();
	/**
	 * 编辑页面
	 * @return 编辑页面地址
	 */
	public ModelAndView editView();
	/**
	 * 删除页面
	 * @return 删除页面地址
	 */
	public String delete();
}

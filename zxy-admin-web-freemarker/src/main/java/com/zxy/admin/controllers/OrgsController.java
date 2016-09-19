package com.zxy.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 机构管理
 * @author Zhu XiYong
 *
 */
@Controller
@RequestMapping("/orgs")
public class OrgsController implements IControllerContract{

	/**
	 * 机构管理主页
	 * @return 
	 */
	@RequestMapping("/index")
	public String index(){
		return "orgs/orgIndex";
	}
	
	/**
	 * 新增页面Url
	 * @return 新增页面Url
	 */
	@Override
	@RequestMapping("/add")
	public String add() {
		return "orgs/orgEdit";
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
}

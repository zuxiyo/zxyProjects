package com.zxy.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 * @author Zhu XiYong
 *
 */
@Controller
@RequestMapping("/users")
public class UsersController {

	/**
	 * 用户管理主页
	 * @return 
	 */
	@RequestMapping("/index")
	public String index(){
		return "users/userIndex";
	}
}

package com.zxy.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zxy.admin.AdminWebProperties;
import com.zxy.admin.entities.CountryInfo;
import com.zxy.admin.services.CountriesService;

/**
 * 机构管理
 * @author Zhu XiYong
 *
 */
@Controller
@RequestMapping("/orgs")
public class OrgsController implements IControllerContract{

	@Autowired
	private CountriesService countriesService;
	@Autowired
	private AdminWebProperties myProperties;
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
	@RequestMapping("/addView")
	public ModelAndView addView() {
		Iterable<CountryInfo> countries = countriesService.getAllCountries();
		ModelAndView view = new ModelAndView("orgs/orgEdit");
		view.addObject("countries", countries);
		view.addObject("defaultCountryCode", myProperties.getDefaultCountryCode());
		return view;
	}

	@Override
	public ModelAndView editView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}
}

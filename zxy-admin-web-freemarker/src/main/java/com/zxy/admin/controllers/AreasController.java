/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月12日上午10:40:15
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月12日上午10:40:15
 */
package com.zxy.admin.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zxy.admin.controllers.utils.DataTablesPageable;
import com.zxy.admin.controllers.utils.DataTablesUtil;
import com.zxy.admin.entities.AreaInfo;
import com.zxy.admin.services.AreasService;
import com.zxy.admin.utils.FormResult;

/**
 * 行政区划设置控制器
 * @author Zhu XiYong 
 * @Date 2016年9月12日上午10:40:15
 */
@Controller
@RequestMapping("/areas")
public class AreasController {

	@Autowired
	private AreasService areasService;
	
	/**
	 * 行政区划设置主页
	 * @return 
	 */
	@RequestMapping("/index")
	public String index(){
		return "areas/areaIndex";
	}
	
	/**
	 * 行政区划设置新增页面
	 * @return 
	 */
	@RequestMapping("/addView")
	public ModelAndView addView(){
		ModelAndView view = new ModelAndView("areas/areaEdit");	
		return view;
	}
	
	/**
	 * 行政区划设置修改页面
	 * @return 
	 */
	@RequestMapping("/editView")
	public ModelAndView editView(HttpServletRequest request, HttpServletResponse response,@RequestParam String areaCode){
		
		AreaInfo info = areasService.getEntity(areaCode);
		
		ModelAndView view = new ModelAndView("areas/areaEdit");				
		view.addObject("model", info);  
		return view;
	}
	
	
	/**
	 * 获得数据列表
	 * @param request
	 * @param response
	 * @return 数据列表
	 */
	@RequestMapping("/getPageList")
	@ResponseBody
	public DataTablesPageable getPageList(HttpServletRequest request, HttpServletResponse response){
		Pageable pageable = DataTablesUtil.getPageable(request);
		Page<AreaInfo> page = areasService.getPageList(pageable);
		DataTablesPageable dataTables = DataTablesUtil.ConvertToDataTablesPageable(request,page);
		return dataTables;
	}
	
	/**
	 *  保存新增的数据
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public FormResult save(HttpServletRequest request, HttpServletResponse response,AreaInfo model){		
		FormResult result = new FormResult();
		try {
			areasService.add(model);
			result.setSuccess(true);
			result.setMessage("保存成功！");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	/**
	 * 更新信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public FormResult update(HttpServletRequest request, HttpServletResponse response,AreaInfo model){	
		FormResult result = new FormResult();
		try{
			areasService.update(model);
			result.setSuccess(true);
			result.setMessage("更新成功！");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("更新失败！" + e.getMessage());
		}
		return result;
	}
	
	/**
	 * 删除行政区划
	 * @param request
	 * @param response
	 * @param areaCode
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public FormResult delete(HttpServletRequest request, HttpServletResponse response,String... areaCode){	
		FormResult result = new FormResult();
		try{
			if(areaCode.length > 1)
			  areasService.delete(areaCode);
			else
			  areasService.delete(areaCode[0]);
			
			result.setSuccess(true);
			result.setMessage("删除成功！");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("删除失败！" + e.getMessage());
		}
		return result;
	}
}

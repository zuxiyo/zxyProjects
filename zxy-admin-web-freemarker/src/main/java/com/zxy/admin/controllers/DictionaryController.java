/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月4日下午6:41:31
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月4日下午6:41:31
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

import com.zxy.admin.controllers.utils.DataTablesPageable;
import com.zxy.admin.controllers.utils.DataTablesUtil;
import com.zxy.admin.entities.DictionaryCategoryInfo;
import com.zxy.admin.entities.DictionaryItemInfo;
import com.zxy.admin.services.DictionaryService;
import com.zxy.admin.utils.TreeNode;

/**
 * 数据字典控制器
 * @author Zhu XiYong 
 * @Date 2016年9月4日下午6:41:31
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	
	//@Resource注解会按名字（idbDataDictionary）寻找类型 
	//@Resource  
	//private IDbDataDictionary iDbDataDictionary;
	
	//@@Autowired注解会按类型名（DataDictionaryService）寻找类型 
	@Autowired
	private DictionaryService dictionaryService;
		
	/**
	 * 数据字典设置主页
	 * (non-Javadoc)
	 * @see com.zxy.admin.controllers.IControllerContract#index()
	 */
	@RequestMapping("/index")
	public String index() {
		return "dictionary/dictionaryIndex";
	}

	/* (non-Javadoc)
	 * @see com.zxy.admin.web.controllers.IControllerContract#add()
	 */
	@RequestMapping("/addCategoryView")
	public String addCategoryView() {
		return "dictionary/dictionaryCategoryEdit";
	}
	
	@RequestMapping("/addItemView")
	public String addItemView() {
		return "dictionary/dictionaryItemEdit";
	}

	/* (non-Javadoc)
	 * @see com.zxy.admin.web.controllers.IControllerContract#edit()
	 */
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.zxy.admin.web.controllers.IControllerContract#delete()
	 */
	public String deleteCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 获得类别数据列表
	 * @param request
	 * @param response
	 * @return 类别数据列表
	 */
	@RequestMapping("/getCategoryPage")
	@ResponseBody
	public DataTablesPageable getCategoryPage(HttpServletRequest request, HttpServletResponse response){
		Pageable pageable = DataTablesUtil.getPageable(request);
		Page<DictionaryCategoryInfo> page = dictionaryService.getCategoryPage(pageable);
		DataTablesPageable dataTables = DataTablesUtil.ConvertToDataTablesPageable(request,page);
		return dataTables;
	}
	
	/**
	 * 获得字典具体项目数据列表
	 * @param request
	 * @param response
	 * @return 数据列表
	 */
	@RequestMapping("/getItemPage")
	@ResponseBody
	public DataTablesPageable getItemPage(HttpServletRequest request, HttpServletResponse response,@RequestParam String categoryCode){
		Pageable pageable = DataTablesUtil.getPageable(request);
		Page<DictionaryItemInfo> page = dictionaryService.getItemPageByCategoryCode(pageable,categoryCode);
		DataTablesPageable dataTables = DataTablesUtil.ConvertToDataTablesPageable(request,page);
		return dataTables;
	}
	
	/**
	 * 获得字典具体项目数据列表
	 * @param request
	 * @param response
	 * @return 数据列表
	 */
	@RequestMapping("/getItemData")
	@ResponseBody
	public Iterable<DictionaryItemInfo> getItemData(HttpServletRequest request, HttpServletResponse response,@RequestParam String categoryCode){
		Iterable<DictionaryItemInfo>  list = dictionaryService.getItemDataByCategoryCode(categoryCode);
		return list;
	}
	
	/**
	 * 获得zTree格式的字典具体项目数据列表
	 * @param request
	 * @param response
	 * @return 数据列表
	 */
	@RequestMapping("/getZTreeItemData")
	@ResponseBody
	public Iterable<TreeNode> getZTreeItemData(HttpServletRequest request, HttpServletResponse response,@RequestParam String categoryCode){
		Iterable<TreeNode>  list = dictionaryService.getZTreeItemList(categoryCode);
		return list;
	}
	
		
	/**
	 *  保存新增的类别数据
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/saveCategory")
	@ResponseBody
	public String saveCategory(HttpServletRequest request, HttpServletResponse response,DictionaryCategoryInfo model){		
		boolean result = dictionaryService.addCategory(model);
		if(result)
			return "保存成功！";
		return "保存失败！";
	}
	
	/**
	 *  保存新增的字典项
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/saveItem")
	@ResponseBody
	public String saveItem(HttpServletRequest request, HttpServletResponse response,DictionaryItemInfo model){		
		boolean result = dictionaryService.addItem(model);
		if(result)
			return "保存成功！";
		return "保存失败！";
	}

}

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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zxy.admin.controllers.utils.DataTablesPageable;
import com.zxy.admin.controllers.utils.DataTablesUtil;
import com.zxy.admin.entities.DictionaryCategoryInfo;
import com.zxy.admin.entities.DictionaryItemInfo;
import com.zxy.admin.services.DictionaryService;
import com.zxy.admin.utils.FormResult;
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

	/**
	 * 新增数据字典种类
	 * @return view 名称
	 */
	@RequestMapping("/addCategoryView")
	public String addCategoryView() {
		return "dictionary/dictionaryCategoryEdit";
	}
	
	/**
	 * 修改数据字典种类
	 * @param request
	 * @param response
	 * @param uid
	 * @return
	 */
	@RequestMapping("/editCategoryView")
	public ModelAndView editCategoryView(HttpServletRequest request, HttpServletResponse response,@RequestParam String uid){
		
		DictionaryCategoryInfo info = dictionaryService.getCategoryEntity(uid);		
		ModelAndView view = new ModelAndView("dictionary/dictionaryCategoryEdit");				
		view.addObject("model", info);  
		return view;
	}	
	
	/**
	 * 删除数据字典种类
	 * @return
	 */
	@RequestMapping("/deleteCategory")
	@ResponseBody
	public FormResult deleteCategory(HttpServletRequest request, HttpServletResponse response,String... uid){
		FormResult result = new FormResult();
		try{
			if(uid.length > 1)
				dictionaryService.deleteCategory(uid);
			else
				dictionaryService.deleteCategory(uid[0]);
			
			result.setSuccess(true);
			result.setMessage("删除种类成功！");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("删除种类失败！" + e.getMessage());
		}
		return result;
	}
	
	/**
	 * 新增数据字典项
	 * @return
	 */
	@RequestMapping("/addItemView")
	public String addItemView() {
		return "dictionary/dictionaryItemEdit";
	}
	
	/**
	 * 修改数据字典项
	 * @param request
	 * @param response
	 * @param uid
	 * @return
	 */
	@RequestMapping("/editItemView")
	public ModelAndView editItemView(HttpServletRequest request, HttpServletResponse response,@RequestParam String uid){
		
		DictionaryItemInfo info = dictionaryService.getItemEntity(uid);		
		ModelAndView view = new ModelAndView("dictionary/dictionaryItemEdit");				
		view.addObject("model", info);  
		return view;
	}	
	
	/**
	 * 删除数据字典项
	 * @return
	 */
	@RequestMapping("/deleteItem")
	@ResponseBody
	public FormResult deleteItem(HttpServletRequest request, HttpServletResponse response,String... uid){
		FormResult result = new FormResult();
		try{
			if(uid.length > 1)
				dictionaryService.deleteItem(uid);
			else
				dictionaryService.deleteItem(uid[0]);
			
			result.setSuccess(true);
			result.setMessage("删除种类成功！");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("删除种类失败！" + e.getMessage());
		}
		return result;
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
		DictionaryCategoryInfo resultModel = dictionaryService.addCategory(model);
		if(!StringUtils.isEmpty(resultModel.getUid()))
			return "保存成功！";
		return "保存失败！";
	}
	
	/**
	 * 更新数据字典类别
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateCategory")
	@ResponseBody
	public FormResult updateCategory(HttpServletRequest request, HttpServletResponse response,DictionaryCategoryInfo model){	
		FormResult result = new FormResult();
		try{
			dictionaryService.updateCategory(model);
			result.setSuccess(true);
			result.setMessage("更新成功！");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("更新失败！" + e.getMessage());
		}
		return result;
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
	/**
	 * 更新信息
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateItem")
	@ResponseBody
	public FormResult updateItem(HttpServletRequest request, HttpServletResponse response,DictionaryItemInfo model){	
		FormResult result = new FormResult();
		try{
			dictionaryService.updateItem(model);
			result.setSuccess(true);
			result.setMessage("更新成功！");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("更新失败！" + e.getMessage());
		}
		return result;
	}
}

/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年12月6日 下午3:41:30
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年12月6日 下午3:41:30
 */
package com.zxy.admin.api;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;
import com.zxy.admin.api.utils.FromResult;
import com.zxy.admin.entities.DictionaryCategoryInfo;
import com.zxy.admin.entities.DictionaryItemInfo;
import com.zxy.admin.services.DictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 字典类别API
 * 
 * @author ZhuXY
 * @date 2016年12月6日 下午3:41:30
 */
@RestController
@RequestMapping("/dict/category")
@Api("数据字典类别操作API")
public class DictionaryCategoryRestController {

	@Autowired
	private DictionaryService dictService;

	/**
	 * 新增一个数据字典的类别
	 * @param model   创建的实体类
	 * @return
	 */
	@ApiOperation("新增一个数据字典的类别")
	@PostMapping(value="/create")
	public ResponseEntity<FromResult> create(DictionaryCategoryInfo model) {
		
		FromResult result = new FromResult();
		if (Strings.isNullOrEmpty(model.getCategoryCode()) || Strings.isNullOrEmpty(model.getCategoryName())) {
			result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			result.setMessage("错误：CategoryCode或CategoryName为空！ ");
			result.setDescription("该类别的CategoryCode或CategoryName为空，无法新增！");
		} else {

			if (dictService.existsCategory(model.getCategoryCode())) {
				result.setStatus(HttpStatus.CONFLICT);
				result.setMessage("错误：CategoryCode 已存在 ");
				result.setDescription(String.format("CategoryCode[%s]已存在，请更换该CategoryCode！", model.getCategoryCode()));
			} else {
				dictService.addCategory(model);
				result.setStatus(HttpStatus.CREATED);
				result.setMessage("保存成功 ");
				result.setDescription("该字典类别保存成功");
			}
		}
		
		return new ResponseEntity<FromResult>(result,result.getHttpStatus());
	}

	/**
	 * 更新一个数据字典类别信息
	 * @param model
	 * @return
	 */
	@ApiOperation("更新一个数据字典类别信息")
	@PutMapping("/update")
	public ResponseEntity<FromResult> update(DictionaryCategoryInfo model) {
	
		if (Strings.isNullOrEmpty(model.getUid()) || Strings.isNullOrEmpty(model.getCategoryCode()) || Strings.isNullOrEmpty(model.getCategoryName())) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			result.setMessage("错误：UID或CategoryCode或CategoryName为空！ ");
			result.setDescription("该类别的UID或CategoryCode或CategoryName为空，无法更新！");
			return new ResponseEntity<FromResult>(result, result.getHttpStatus());
		}

		//不是自身及 找到多个
		List<DictionaryCategoryInfo> oldModelList = dictService.getCategoryEntityByCategoryCode(model.getCategoryCode());
		if (oldModelList.size()== 1 && !oldModelList.get(0).getUid().equals(model.getUid()) || oldModelList.size() > 1) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.CONFLICT);
			result.setMessage("错误：该 CategoryCode 已使用 ");
			result.setDescription(String.format("该CategoryCode[%s]已使用，请更换CategoryCode！", model.getCategoryCode()));
			return new ResponseEntity<FromResult>(result, result.getHttpStatus());
		}

		FromResult result = new FromResult();
		DictionaryCategoryInfo updatedModel = dictService.updateCategory(model);
		if (updatedModel == null) {
			result.setStatus(HttpStatus.NOT_FOUND);
			result.setMessage("错误：找不到更新的对象！ ");
			result.setDescription("找不到更新的对象，无法更新！");
			return new ResponseEntity<FromResult>(result, result.getHttpStatus());
		}else{		
			result.setStatus(HttpStatus.OK);
			result.setMessage("更新成功 ");
			result.setDescription("该字典类别更新成功");
		}
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}

	/**
	 * 删除一个数据字典类别
	 * @param id
	 * @return
	 */
	@ApiOperation("删除一个数据字典类别")
	@ApiImplicitParam(paramType = "path", name = "uid", dataType = "String", required = true, value = "要删除类别的ID号")
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<FromResult> delete(@PathVariable String uid) {	
				
		DictionaryCategoryInfo oldModel = dictService.getCategoryEntity(uid);
		if(oldModel != null){
			Iterable<DictionaryItemInfo> list = dictService.getItemDataByCategoryCode(oldModel.getCategoryCode());
			Iterator<DictionaryItemInfo> i = list.iterator();
			if (i.hasNext()) {
				
				FromResult result = new FromResult();
				result.setStatus(HttpStatus.BAD_REQUEST);
				result.setMessage("错误：该类别下已有字典项！ ");
				result.setDescription("该类别下已有字典项！请先删除字典项，再来删除本类别！");
				return new ResponseEntity<FromResult>(result, result.getHttpStatus());
			}
		}
			
		dictService.deleteCategory(uid);		
		
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.OK);
		result.setMessage("删除成功 ");
		result.setDescription("该字典类别删除成功");
	
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}

	/**
	 * 获取一个数据字典类别信息
	 * @param uid
	 * @return
	 */
	@ApiOperation("获取一个数据字典类别信息")
	@ApiImplicitParam(paramType = "path", name = "uid", dataType = "String", required = true, value = "要获得的类别的ID号")
	@GetMapping("/get/{uid}")
	public ResponseEntity<FromResult> get(@PathVariable String uid) {
		DictionaryCategoryInfo model = dictService.getCategoryEntity(uid);
		if(model == null){
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.NOT_FOUND);
			result.setMessage("错误：请求的数据没有找到！");
			result.setDescription("请求的数据没有找到，请检查输入的UID是否正确！");
			return new ResponseEntity<FromResult>(result, result.getHttpStatus());
		}
		
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.OK);
		result.setMessage("请求成功！");
		result.setDescription("该字典类别请求成功！");
		result.setData(model);
		
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}

	/**
	 * 获得数据字典类别列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@ApiOperation("获得数据字典类别列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "pageIndex", dataType = "int", required = true, value = "当前页码"),
			@ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "一页的记录数") })
	@GetMapping("/list")
	public ResponseEntity<FromResult> getPage(int pageIndex, int pageSize) {
		Page<DictionaryCategoryInfo> list = dictService.getCategoryPage(pageIndex,pageSize);
		
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.OK);
		result.setMessage("请求成功！");
		result.setDescription("该字典类别请求成功！");
		result.setData(list);
		
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}
}

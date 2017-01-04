/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年12月8日 下午3:25:59
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年12月8日 下午3:25:59
 */
package com.zxy.admin.api;

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
import com.zxy.admin.entities.DictionaryItemInfo;
import com.zxy.admin.services.DictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 字典项API
 * @author ZhuXY 
 * @date 2016年12月8日 下午3:25:59 
 */
@RestController
@RequestMapping("/dict/item")
@Api("数据字典项操作API")
public class DictionaryItemRestController {

	@Autowired
	private DictionaryService dictService;

	/**
	 * 新增一个数据字典项
	 * @param model   创建的实体类
	 * @return
	 */
	@ApiOperation("新增一个数据字典项")
	@PostMapping("/create")
	public ResponseEntity<FromResult> create(DictionaryItemInfo model) {
		
		if (Strings.isNullOrEmpty(model.getCategoryCode()) || Strings.isNullOrEmpty(model.getDictionaryCode())) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			result.setMessage("错误：类别没有选择或没有输入字典项代码！ ");
			result.setDescription("该字典项的所属类别没有选择或没有输入字典项代码，无法新增！");
			return new ResponseEntity<FromResult>(result,result.getHttpStatus());
		}

		if (dictService.existsItem(model.getCategoryCode(),model.getDictionaryCode())) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.CONFLICT);
			result.setMessage("错误：DictionaryCode 已存在 ");
			result.setDescription(String.format("DictionaryCode[%s]已存在，请更换该DictionaryCode！", model.getDictionaryCode()));
			return new ResponseEntity<FromResult>(result,result.getHttpStatus());
		} 
		
		dictService.addItem(model);
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.CREATED);
		result.setMessage("保存成功 ");
		result.setDescription("该字典项保存成功");	
		return new ResponseEntity<FromResult>(result,result.getHttpStatus());
	}

	/**
	 * 更新一个数据字典项信息
	 * @param model
	 * @return
	 */
	@ApiOperation("更新一个数据字典项信息")
	@PutMapping("/update")
	public ResponseEntity<FromResult> update(DictionaryItemInfo model) {

		if (Strings.isNullOrEmpty(model.getUid()) || Strings.isNullOrEmpty(model.getCategoryCode())|| Strings.isNullOrEmpty(model.getDictionaryCode())) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			result.setMessage("错误：UID或CategoryCode或DictionaryCode为空！ ");
			result.setDescription("该字典项的UID或CategoryCode或DictionaryCode为空，无法更新！");
			return new ResponseEntity<FromResult>(result, result.getHttpStatus());
		}
		
		List<DictionaryItemInfo> oldModelList = dictService.getItemEntityByCategoryCodeAndDictionaryCode(model.getCategoryCode(), model.getDictionaryCode());
		//不是自身及 找到多个
		if (oldModelList.size()== 1 && !oldModelList.get(0).getUid().equals(model.getUid()) || oldModelList.size() > 1) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.CONFLICT);
			result.setMessage("错误：该 DictionaryCode 已在该字典类别所属的字典项中使用 ");
			result.setDescription(String.format("该DictionaryCode[%s]已在本类[%s]中使用，请更换CategoryCode！",model.getDictionaryCode(), model.getCategoryCode()));
			return new ResponseEntity<FromResult>(result, result.getHttpStatus());
		}
		
		FromResult result = new FromResult();
		DictionaryItemInfo updatedModel = dictService.updateItem(model);
		if (updatedModel == null) {
			result.setStatus(HttpStatus.NOT_FOUND);
			result.setMessage("错误：找不到更新的对象！ ");
			result.setDescription("找不到更新的对象，无法更新！");
		} else {
			result.setStatus(HttpStatus.OK);
			result.setMessage("更新成功 ");
			result.setDescription("该字典项更新成功");
		}
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}

	/**
	 * 删除一个数据字典项
	 * @param id
	 * @return
	 */
	@ApiOperation("删除一个数据字典项")
	@ApiImplicitParam(paramType = "path", name = "uid", dataType = "String", required = true, value = "要删除项的ID号")
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<FromResult> delete(@PathVariable String uid) {	
		
		dictService.deleteItem(uid);		
		
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.OK);
		result.setMessage("删除成功 ");
		result.setDescription("该字典项删除成功");
	
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}

	/**
	 * 获取一个数据字典项信息
	 * @param uid
	 * @return
	 */
	@ApiOperation("获取一个数据字典项信息")
	@ApiImplicitParam(paramType = "path", name = "uid", dataType = "String", required = true, value = "要获得项的ID号")
	@GetMapping("/get/{uid}")
	public ResponseEntity<FromResult> get(@PathVariable String uid) {
		DictionaryItemInfo model = dictService.getItemEntity(uid);
		
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
		result.setDescription("该字典数据项请求成功！");
		result.setData(model);
		
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}

	/**
	 * 获得数据字典项列表
	 * @param pageIndex
	 * @param pageSize
	 * @param categoryCode
	 * @return
	 */
	@ApiOperation("获得数据字典项列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "pageIndex", dataType = "int", required = true, value = "当前页码"),
			@ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "一页的记录数"),
			@ApiImplicitParam(paramType = "query", name = "categoryCode", dataType = "String", required = true, value = "类别代码")})
	@GetMapping("/get")
	public ResponseEntity<FromResult> getPage(int pageIndex, int pageSize,String categoryCode) {		
		Page<DictionaryItemInfo> list = dictService.getItemPage(pageIndex,pageSize,categoryCode);
		
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.OK);
		result.setMessage("请求成功！");
		result.setDescription("该字典数据项请求成功！");
		result.setData(list);
		
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}
}

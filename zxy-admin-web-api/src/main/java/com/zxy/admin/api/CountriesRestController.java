/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年12月19日 下午1:41:30
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年12月19日 下午1:41:30
 */
package com.zxy.admin.api;

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
import com.zxy.admin.entities.CountryInfo;
import com.zxy.admin.services.CountriesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 国家/地区Api接口
 * @author ZhuXY 
 * @date 2016年12月19日 下午1:41:30 
 */
@RestController
@RequestMapping("/countries")
@Api("国家/地区操作API")
public class CountriesRestController {

	@Autowired
	private CountriesService countryService;
	
	/**
	 * 新增一个国家/地区
	 * @param model   创建的实体类
	 * @return
	 */
	@ApiOperation("新增一个国家/地区")
	@PostMapping("/create")
	public ResponseEntity<FromResult> create(CountryInfo model) {
		
		if (Strings.isNullOrEmpty(model.getCountryCode()) || Strings.isNullOrEmpty(model.getCountryName())) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			result.setMessage("错误：没有输入国家/地区 代码 或 名称！ ");
			result.setDescription("该国家/地区 代码 或 名称为空，无法新增！");
			return new ResponseEntity<FromResult>(result,result.getHttpStatus());
		}

		if (countryService.exists(model.getCountryCode())) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.CONFLICT);
			result.setMessage("错误：国家/地区 代码 已存在 ");
			result.setDescription(String.format("国家/地区 代码 [%s]已存在，请更换该国家/地区 代码！", model.getCountryCode()));
			return new ResponseEntity<FromResult>(result,result.getHttpStatus());
		} 
		
		countryService.add(model);
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.CREATED);
		result.setMessage("保存成功 ");
		result.setDescription("该国家/地区保存成功");	
		return new ResponseEntity<FromResult>(result,result.getHttpStatus());
	}

	/**
	 * 更新一个国家/地区信息
	 * @param model
	 * @return
	 */
	@ApiOperation("更新一个国家/地区信息")
	@PutMapping("/update")
	public ResponseEntity<FromResult> update(CountryInfo model) {

		if (Strings.isNullOrEmpty(model.getCountryCode())) {
			FromResult result = new FromResult();
			result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
			result.setMessage("错误：国家/地区 代码为空！ ");
			result.setDescription("该国家/地区 代码为空，无法更新！");
			return new ResponseEntity<FromResult>(result, result.getHttpStatus());
		}
		
		FromResult result = new FromResult();
		CountryInfo updatedModel = countryService.update(model);
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
	 * 删除一个国家/地区
	 * @param id
	 * @return
	 */
	@ApiOperation("删除一个国家/地区")
	@ApiImplicitParam(paramType = "path", name = "countryCode", dataType = "String", required = true, value = "要删除项的countryCode号")
	@DeleteMapping("/delete/{countryCode}")
	public ResponseEntity<FromResult> delete(@PathVariable String countryCode) {	
		
		countryService.delete(countryCode);		
		
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.OK);
		result.setMessage("删除成功 ");
		result.setDescription("该字典项删除成功");
	
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}

	/**
	 * 获取一个国家/地区信息
	 * @param uid
	 * @return
	 */
	@ApiOperation("获取一个国家/地区信息")
	@ApiImplicitParam(paramType = "path", name = "countryCode", dataType = "String", required = true, value = "要获得项的countryCode号")
	@GetMapping("/get/{countryCode}")
	public ResponseEntity<FromResult> get(@PathVariable String countryCode) {
		
		CountryInfo model = countryService.getEntity(countryCode);
		
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
		result.setDescription("该国家/地区请求成功！");
		result.setData(model);
		
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}

	/**
	 * 获得国家/地区列表
	 * @param pageIndex
	 * @param pageSize
	 * @param categoryCode
	 * @return
	 */
	@ApiOperation("获得国家/地区列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "pageIndex", dataType = "int", required = true, value = "当前页码"),
			@ApiImplicitParam(paramType = "query", name = "pageSize", dataType = "int", required = true, value = "一页的记录数")})
	@GetMapping("/get")
	public ResponseEntity<FromResult> getPage(int pageIndex, int pageSize) {		
		Page<CountryInfo> list = countryService.getPageList(pageIndex,pageSize);
		
		FromResult result = new FromResult();
		result.setStatus(HttpStatus.OK);
		result.setMessage("请求成功！");
		result.setDescription("该国家/地区请求成功！");
		result.setData(list);
		
		return new ResponseEntity<FromResult>(result, result.getHttpStatus());
	}
}

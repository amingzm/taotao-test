package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.util.TaotaoResult;
import com.taotao.service.ContentCategoryService;

//内容分类管理controller
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		return contentCategoryService.getContentCatList(parentId);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createNode(Long parentId, String name) {
		TaotaoResult taotaoResult = contentCategoryService.insertCategory(parentId, name);
		return taotaoResult;
	}
	
	@RequestMapping("/update")
	public void updateNode(Long id, String name) {
		contentCategoryService.updateCategory(id, name);
	}
	
	@RequestMapping("/delete")
	public void deleteNode(Long id) {
		contentCategoryService.deleteCategory(id);
	}
}

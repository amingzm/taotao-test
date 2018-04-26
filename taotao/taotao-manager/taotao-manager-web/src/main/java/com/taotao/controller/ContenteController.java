package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUTIDataGridResult;
import com.taotao.common.util.HttpClientUtil;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContenteController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/query/list")
	@ResponseBody
	public EasyUTIDataGridResult getContentList(int page, int rows, Long categoryId) {
		EasyUTIDataGridResult contentList = contentService.getContentList(page, rows, categoryId);
		return contentList;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		//调用taotao-rest发布d服务，清空缓存.
		HttpClientUtil.doGet("http://localhost:8080/rest/content/sync/" + content.getCategoryId());
		return result;
	}
	
}

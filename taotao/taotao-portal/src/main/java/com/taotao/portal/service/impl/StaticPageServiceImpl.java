package com.taotao.portal.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.portal.service.ItemService;
import com.taotao.portal.service.StaticPageService;

//import freemarker.template.Configuration;
//import freemarker.template.Template;

public class StaticPageServiceImpl implements StaticPageService {

//	@Autowired
//	private ItemService itemService;
//	@Autowired
//	private FreeMarkerConfigurer freeMarkerConfigurer;
//	
//	@Override
//	public TaotaoResult getItemHtml(Long itemId) throws Exception {
//		//商品基本信息
//		TbItem tbItem = itemService.getItemById(itemId);
//		//商品描述
//		String itemDesc = itemService.getItemDescById(itemId);
//		//规格参数
//		String itemParam = itemService.getItemParamById(itemId);
		//生成静态页面
		//-------------------------------注释 ， 不启用
//		Configuration configuration = freeMarkerConfigurer.getConfiguration();
//		Template template = configuration.getTemplate("item.ftl");
//		//创建数据集
//		Map root = new HashMap<>();
//		root.put("item", tbItem);
//		
//		//创建一个Writer对象
//		Writer out = new FileWriter(new File("D:\\JAVAPROJECT\\taotao\\taotao-portal\\src\\main\\webapp\\WEB-INF\\html\\" + itemId + ".html"));
//		//生成静态文件
//		template.process(root, out);
//		out.flush();
//		out.close();
//		return TaotaoResult.ok();
//	}

}

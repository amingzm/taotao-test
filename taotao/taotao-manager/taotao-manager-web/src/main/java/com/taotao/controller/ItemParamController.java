package com.taotao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.pojo.EasyUTIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	ItemParamService itemParamService;

	@RequestMapping("/list")
	@ResponseBody
	public EasyUTIDataGridResult getItemParamList(Integer page, Integer rows) {
		return itemParamService.getItemParamList(page, rows);
	}
	
	@RequestMapping("/cid/{cid}")
	@ResponseBody
	public TaotaoResult getItemByCid(@PathVariable Long cid) {
		return itemParamService.getItemParamByCid(cid);
	}
	
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemCatByCid(@PathVariable Long cid) {
		return itemParamService.getItemParamByCid(cid);
	}
	
	@ResponseBody
	@RequestMapping("/save/{cid}")
	public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
		return itemParamService.insertItemParam(cid, paramData);
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public TaotaoResult deleteItemParam(Long[] ids) {

		List<Long> list = new ArrayList<>();
		
		for (Long long1 : ids) {
			list.add(long1);
		}
        
		return itemParamService.deleteItemParam(list);
	}
}

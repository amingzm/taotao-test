package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUTIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	TbContentMapper tbContentMapper;
	
	@Override
	public EasyUTIDataGridResult getContentList(int page, int rows, Long categoryId) {
		//分页处理
		PageHelper.startPage(page, rows);
		// 执行查询
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = tbContentMapper.selectByExample(example);
		//取分页信息
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		//返回处理结果
		EasyUTIDataGridResult result = new EasyUTIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

	@Override
	public TaotaoResult insertContent(TbContent content) {
		// 插入
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//插入数据
		tbContentMapper.insert(content);
		
		return TaotaoResult.ok();
	}

}

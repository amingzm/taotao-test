package com.taotao.service;

import com.taotao.common.pojo.EasyUTIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {

	EasyUTIDataGridResult getContentList(int page, int rows, Long categoryId);
	TaotaoResult insertContent(TbContent content);
}

package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUTIDataGridResult;
import com.taotao.common.util.TaotaoResult;

public interface ItemParamService {

	EasyUTIDataGridResult getItemParamList(int page, int rows);
	TaotaoResult getItemParamByCid(Long cid);
	TaotaoResult insertItemParam(Long cid, String paramData);
	TaotaoResult deleteItemParam(List<Long> ids);
}

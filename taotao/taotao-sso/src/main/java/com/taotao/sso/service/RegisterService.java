package com.taotao.sso.service;

import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbUser;

public interface RegisterService {

	TaotaoResult checkData(String param, int type);
	TaotaoResult register(TbUser user);
}
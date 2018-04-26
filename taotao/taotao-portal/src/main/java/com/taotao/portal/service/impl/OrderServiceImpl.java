package com.taotao.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.util.HttpClientUtil;
import com.taotao.common.util.JsonUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.portal.pojo.OrderInfo;
import com.taotao.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	
	
	@Override
	public String createOrder(OrderInfo orderInfo) {
		//转成json
		String json = JsonUtils.objectToJson(orderInfo);
		//提交订单数据
		String jsonResult = HttpClientUtil.doPostJson("http://localhost:8085/order/create.action", json);
		//转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.format(jsonResult);
		String orderId = taotaoResult.getData().toString();
		//取订单号
		return orderId;
	}

}

package com.taotao.order.pojo;

import java.util.List;

import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

public class OrderInfo extends TbOrder {
	
	private List<TbOrderItem> orderitems;
	private TbOrderShipping orderShipping;
	public List<TbOrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<TbOrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
}

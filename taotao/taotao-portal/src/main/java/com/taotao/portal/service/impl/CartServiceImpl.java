package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.print.attribute.standard.MediaSize.JIS;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.util.CookieUtils;
import com.taotao.common.util.JsonUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.portal.component.JedisClient;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.ItemService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private ItemService itemService;
	@Autowired
	private JedisClient jedisCilent;
	
	@Value("${REDIS_CART_KEY}")
	private String REDIS_CART_KEY;

	@Override
	public TaotaoResult addCart(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
//		1、接收商品id
//		2、从cookie中购物车商品列表
		List<CartItem> itemList = getCartItemList(request);
//		3、从商品列表中查询列表是否存在此商品
		boolean haveFlag = false;
		for (CartItem cartItem : itemList) {
//		4、如果存在商品的数量加上参数中的商品数量
			if (cartItem.getId().longValue() == itemId) {
				cartItem.setNum(cartItem.getNum() + num);
				haveFlag = true;
				break;
			}
		}
//		5、如果不存在，调用rest服务，根据商品id获得商品数据。
		if (!haveFlag) {
			TbItem item = itemService.getItemById(itemId);
			//转换成CartItem
			CartItem cartItem = new CartItem();
			cartItem.setId(itemId);
			cartItem.setNum(num);
			cartItem.setPrice(item.getPrice());
			cartItem.setTitle(item.getTitle());
			cartItem.setImage(item.getImage());
//		6、把商品数据添加到列表中
			itemList.add(cartItem);
		}
//		7、把购物车商品列表写入cookie
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), 43200, true);
//		8、返回TaotaoResult
		return TaotaoResult.ok();
	}

	private List<CartItem> getCartItemList(HttpServletRequest request) {
		try {
			//从cookie中取商品列表
			String json = CookieUtils.getCookieValue(request, "TT_CART", true);
			//把json转换成java对象
			List<CartItem> list = JsonUtils.jsonToList(json, CartItem.class);
			return list == null ? new ArrayList<CartItem>() : list;
		} catch (Exception e) {
			return new ArrayList<CartItem>();
		}
		
	}

	@Override
	public List<CartItem> getCartItemLists(HttpServletRequest request) {
		List<CartItem> list = getCartItemList(request);
		return list;
	}

	@Override
	public TaotaoResult updatCartItem(Long itemId, Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		//从cookie中取购物车商品列表
		List<CartItem> itemList = getCartItemList(request);
		//根据商品id查询商品
		for (CartItem cartItem : itemList) {
			if (cartItem.getId().longValue() == itemId) {
				//更新数量
				cartItem.setNum(num);
				break;
			}
		}
		//写入cookie
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), 43200, true);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteCartItem(Long itemId, HttpServletRequest request, HttpServletResponse response) {
//		1、接收商品id
//		2、从cookie中取购物车商品列表
		List<CartItem> lists = getCartItemLists(request);
//		3、找到对应id的商品
		for (CartItem cartItem : lists) {
			if (cartItem.getId().longValue() == itemId) {
//		4、删除商品。
				lists.remove(cartItem);
				break;
			}
		}
//		5、再重新把商品列表写入cookie。
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(lists), 43200, true);
//		6、返回成功
		return TaotaoResult.ok();

	}

	@Override
	public TaotaoResult synCartItem(HttpServletRequest request) {
//		1.从cookie中取购物车商品列表
		List<CartItem> cookielists = getCartItemLists(request);
//		2.从redis中取购物车商品列表
		Map<String, String> map = jedisCilent.hgetAll(REDIS_CART_KEY);
//		3.二者同步
		Map<String, String> result = new HashMap<String, String>();
		for (CartItem cartItem : cookielists) {
//		4.写入redis
			if (!map.containsKey(cartItem.getId() + "")) {
				jedisCilent.hset(REDIS_CART_KEY, cartItem.getId() + "", JsonUtils.objectToJson(cartItem));
			}
		}
		return TaotaoResult.ok();
	}
}

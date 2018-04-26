package com.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/user/page/login")
	public String showLogin(String redirectURL, Model model) {
		//回调参数给jsp
		model.addAttribute("redirect", redirectURL);
		return "login";
	}
	
	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
}

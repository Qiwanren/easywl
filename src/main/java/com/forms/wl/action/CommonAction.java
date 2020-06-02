package com.forms.wl.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/common")
public class CommonAction {
	
	@RequestMapping("/toIndex")
	public ModelAndView toIndex(){
		ModelAndView view = new ModelAndView("common/index");
		
		return view;
	}
	@RequestMapping("/toProduct")
	public ModelAndView toProduct(){
		ModelAndView view = new ModelAndView("common/product");
		
		return view;
	}
	
	@RequestMapping("/toUpdatePwd")
	public ModelAndView toUpdatePwd(){
		ModelAndView view = new ModelAndView("common/updatePwd");
		
		return view;
	}
	
	@RequestMapping("/toUser")
	public ModelAndView toUser(){
		ModelAndView view = new ModelAndView("common/user");
		
		return view;
	}
	
	@RequestMapping("/toMessage")
	public ModelAndView toMessage(){
		ModelAndView view = new ModelAndView("common/message");
		
		return view;
	}
	
	@RequestMapping("/toLink")
	public ModelAndView toLink(){
		ModelAndView view = new ModelAndView("common/link");
		
		return view;
	}
	
	@RequestMapping("/toNews")
	public ModelAndView toNews(){
		ModelAndView view = new ModelAndView("common/news");
		
		return view;
	}
	
	@RequestMapping("/toNewsType")
	public ModelAndView toNewsType(){
		ModelAndView view = new ModelAndView("common/newsType");
		
		return view;
	}
}

package com.forms.wl.action.basic.login.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.forms.wl.action.basic.login.entity.UserInfo;
import com.forms.wl.action.basic.login.service.UserService;
import com.forms.wl.action.basic.utils.StringUtils;



@RestController
@RequestMapping("user")
public class UserAction {
	
	private static Logger logger=LoggerFactory.getLogger(LoginAction.class.getName());
	
	@Autowired
	UserService userService;
	/**
	 * 
	 * 进入注册页面
	 * 
	 * @return
	 */
	@RequestMapping("toRegister")
	public ModelAndView toRegister()
	{
		ModelAndView mAndView = new ModelAndView("register");
		
		return mAndView;
	}
	
	@RequestMapping("register")
	public ModelAndView register(@ModelAttribute(value = "user") UserInfo user)
	{
		ModelAndView mAndView = new ModelAndView("success");
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyymmddhhmmss");
		user.setUserId(fmt.format(new Date()));
		
		//对密码进行加密操作
		String pwd = StringUtils.encryptStr(user.getPassword());
		user.setPassword(pwd);
		
		logger.info("   ++++   "+ user.getUserId() +"   =============  " + user.getUserName() + "   ");
		
		userService.register(user);
		
		return mAndView;
	}
	
}

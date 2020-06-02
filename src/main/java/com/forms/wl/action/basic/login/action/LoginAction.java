package com.forms.wl.action.basic.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.forms.wl.action.basic.login.entity.UserInfo;



@RestController
@RequestMapping("/")
public class LoginAction {
	
	private static Logger logger=LoggerFactory.getLogger(LoginAction.class.getName());
	
	@Autowired
	LoginServiceImp loginServiceImp;
	
//	@RequestMapping(value="/login",method=RequestMethod.GET)
//    public ModelAndView loginForm(Model model){
//
//    	ModelAndView modelAndView = new ModelAndView("login");
//
//        model.addAttribute("user", new UserInfo());
//
//        return modelAndView;
//    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user")UserInfo user,Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes){

    	System.out.println("  === 进入登录验证窗口 ===  ");
    	if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }

        String username = user.getUserName();
    	String password = user.getPassword();
        
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();  
        try {  
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            logger.info("对用户[" + username + "]进行登录验证..验证开始");  
            currentUser.login(token);  
            logger.info("对用户[" + username + "]进行登录验证..验证通过");  
        }catch(UnknownAccountException uae){  
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
            redirectAttributes.addFlashAttribute("message", "未知账户");  
        }catch(IncorrectCredentialsException ice){  
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
            redirectAttributes.addFlashAttribute("message", "密码不正确");  
        }catch(LockedAccountException lae){  
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
            redirectAttributes.addFlashAttribute("message", "账户已锁定");  
        }catch(ExcessiveAttemptsException eae){  
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");  
        }catch(Exception ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");  
        }  
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){  
            logger.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");  
             ModelAndView mv = new ModelAndView("index");
            System.out.println(" -------- 即将进入index页面 --------------- ");
            return mv;
        }else{  
            token.clear();
            System.out.print(" ++++++++++++++++++++++++++++++++++ login fail +++++++++++++++++++++++++++++++");
            ModelAndView mv = new ModelAndView("login");
            return mv;
        }  
    }

    @RequestMapping(value="/login11",method=RequestMethod.POST)
    public ModelAndView testlogin() {

	    ModelAndView mv = new ModelAndView("index");

        System.out.println("  === 进入登录验证窗口 测试页面   ===  ");

        return mv;
    }
    @RequestMapping(value="/loginout",method=RequestMethod.GET)  
    public ModelAndView logout(RedirectAttributes redirectAttributes ){
    	ModelAndView mv = new ModelAndView("login");
    	
    	logger.info("======= this loginout ===========");
    	
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();  
        redirectAttributes.addFlashAttribute("message", "您已安全退出");  
//        return "redirect:/login";
        return mv;
    } 

    @RequestMapping("/403")
    public String unauthorizedRole(){
        logger.info("------没有权限-------");
        return "403";
    }
	
	@RequestMapping("toLogin")
	public ModelAndView toLogin()
	{
		ModelAndView mv = new ModelAndView("login");

		logger.info(" ------------ 即将进入登陆页面 --------------- ");
		
		return mv;
	}
	@RequestMapping("toRegister")
	public ModelAndView toRegister()
	{
		ModelAndView mv = new ModelAndView("register");
		
		logger.info(" ------------ 即将进入登陆页面 --------------- ");
		
		return mv;
	}

    @RequestMapping("index")
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("index");

        logger.info(" ------------ 即将进入index页面 --------------- ");

        return mv;
    }
}

package com.forms.wl.tool;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service
@Aspect
public class WebControllerAop {
	/**
	 * 定义切点  匹配某个包下的所有方法
	 * 
	 * 匹配com.forms.wl.action.wl.cost包及其子包下的所有类的所有方法
	 * 
	 */
	@Pointcut("execution(* com.forms.wl.action.wl.cost..*.*(..))") 
	public void executeService(){ }
	
	/**
	 * 定义切点 ，匹配分页查询的方法
	 * 
	 * 匹配com.forms.wl.action.wl.cost包及其子包下的所有类的所有方法
	 * 
	 */
	@Pointcut("execution(* com.forms.wl.action.wl..*.*Page(..))")
	public void executePageService(){}
	
	/** 
	 * 前置通知，方法调用前被调用 
	 * @param joinPoint 
	 * @throws  
	 * @throws Exception 
	 */
	@Before("executePageService()") 
	public void doBeforeAdvice(JoinPoint joinPoint) throws Exception{ 
	  System.out.println("我是前置通知!!!"); 
      // 获取操作内容  
      Object[] opContent = joinPoint.getArgs();
      
      for(Object object :opContent){
    	  System.out.println(" 参数类型名称 ： " + object.getClass().getName());
    	  
    	  if (object.getClass().getName().contains("com.forms.wl")) {
    		  Method pageNumMethod = object.getClass().getMethod("getPageNum");
    		  Method pageSizeMethod = object.getClass().getMethod("getPageSize");
    		  Method flagMethod = object.getClass().getMethod("getFlag");
        	  System.out.println(pageNumMethod.getName());
        	  
        	  Integer pageNum = (Integer) pageNumMethod.invoke(object);
        	  Integer pageSize = (Integer) pageSizeMethod.invoke(object);
        	  
        	  if (pageNum == null) {
        		  pageNum = 1;
        	  }
        	  
        	  String flag = (String) flagMethod.invoke(object);
        	  
        	  
        	  if ("next".equals(flag)) {
				pageNum +=1;
        	  }else if ("before".equals(flag)) {
				pageNum -=1;
        	  }
        	  PageHelper.startPage(pageNum,pageSize );
		}
    	 
      }
	  
	}
	
	/** 
	 * 后置返回通知 
	 * 这里需要注意的是: 
	 *   如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息 
	 *   如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数 
	 * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值 
	 * @param joinPoint 
	 * @param keys 
	 */
	//@AfterReturning(value = "execution(* com.forms.wl.action.wl.cost..*.*(..))",returning = "keys") 
	public void doAfterReturningAdvice1(JoinPoint joinPoint,Object keys){ 
	  
	  System.out.println("第一个后置返回通知的返回值："+keys); 
	} 
	  
	//@AfterReturning(value = "execution(* com.forms.wl.action.wl.cost..*.*(..))",returning = "keys",argNames = "keys") 
	public void doAfterReturningAdvice2(String keys){ 
	  
	  System.out.println("第二个后置返回通知的返回值："+keys); 
	}
	
	/** 
	 * 环绕通知： 
	 *  环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。 
	 *  环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型 
	 */
	//@Around("execution(* com.forms.wl.action.wl.cost..*.testAround*(..))") 
	public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){ 
	  System.out.println("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName()); 
	  try { 
	    Object obj = proceedingJoinPoint.proceed(); 
	    return obj; 
	  } catch (Throwable throwable) { 
	    throwable.printStackTrace(); 
	  } 
	  return null; 
	}

}

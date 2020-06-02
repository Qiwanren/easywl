package com.forms.wl.tool;

import org.springframework.stereotype.Service;

/**
 * 
 * 直接使用终端调用执行python脚本
 * 
 * 因为使用Jython不仅执行速度慢，而且因为是在jvm中执行的，因此不支持第三方类库
 * 
 * @author Administrator
 *
 */

@Service
public class CallPython {
	
	private Process proc = null;
	
	
	public void call(String path){
		
		// path = "D:/python/html/pyQuery.py";
		
		try {
			proc = Runtime.getRuntime().exec("python " + path);
			proc.waitFor();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public static void main(String[] args) {
		
		
	}
	
}

package com.forms.wl.action.basic.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha384Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CredentialsMatcher extends SimpleCredentialsMatcher{
	
	private static Logger logger=LoggerFactory.getLogger(CredentialsMatcher.class.getName());
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        
    	logger.info("  ==================采用加盐法，校验密码  =====================");
    	
    	UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(utoken.getPassword());
        //添加对密码的加密规则
        inPassword = encrypt(inPassword);
        
        //获得数据库中的密码
        String dbPassword=(String) info.getCredentials();
        //进行密码的比对
        return this.equals(inPassword, dbPassword);
    }
    
    //将传进来密码加密方法  
    private String encrypt(String data) {  
    	
    	logger.info("  ==================采用加盐法，加密密码  =====================");
        String sha384Hex = new Sha384Hash(data).toBase64();  
        System.out.println(data + ":" + sha384Hex);  
        return sha384Hex;  
    }  
    
}
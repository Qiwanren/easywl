package com.forms.wl.action.basic.utils;

import org.apache.shiro.crypto.hash.Sha384Hash;

public class StringUtils {
	
	public static String encryptStr(String string)
	{
		String sha384Hex = new Sha384Hash(string).toBase64();  
		
        return sha384Hex;  
	}
}

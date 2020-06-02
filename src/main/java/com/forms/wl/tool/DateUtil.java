package com.forms.wl.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtil {
	
	/**
	 * 获取唯一ID
	 * @return
	 */
	public String getKeyId(){
		//获得一个唯一ID
		String orderNo = "" ;        
		String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);        
		String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());        
		orderNo = trandNo.toString().substring(0, 4);        
		orderNo = orderNo + sdf ; 
		return orderNo;
	}
	
	/**
	 * 获取当前日期
	 * @param date
	 * @param format
	 * @return
	 */
	public String getNowDate(String format){
		
		 Date now=new Date();
	     SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	     return dateFormat.format(now);
	}
	
	public String getNowHour(){
		
		 Date now=new Date();
	     SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	     return dateFormat.format(now);
	}
	
	/**
	 * 获取某个特定的日期值
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getBeforeDay(int num,String format){
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		int value = 0 - num;
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        calendar.add(Calendar.DATE,value);
        Date date1 = calendar.getTime();
        
        return sdf.format(date1);
	}

}

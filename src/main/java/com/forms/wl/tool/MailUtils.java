package com.forms.wl.tool;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtils {
	
//	private static String HTML_THEME = "<style class=\"fox_global_style\"> "
//			+ "div.fox_html_content { line-height: 1.5;} "
//			+ "blockquote { margin-Top: 0px; margin-Bottom: 0px; "
//			+ "margin-Left: 0.5em } ol, ul { margin-Top: 0px; "
//			+ "margin-Bottom: 0px; list-style-position: inside; } "
//			+ "p { margin-Top: 0px; margin-Bottom: 0px } "
//			+ "</style> <div><span id=\"_FoxCURSOR\"></span><br>"
//			+ "</div> <div><br></div><hr id=\"FMSigSeperator\" "
//			+ "style=\"WIDTH: 210px; HEIGHT: 1px\" "
//			+ "color=\"#b5c4df\" size=\"1\" align=\"left\"> "
//			+ "<div><span id=\"_FoxFROMNAME\"><div style=\"MARGIN: 10px; "
//			+ "FONT-FAMILY: verdana; FONT-SIZE: 10pt\"><div>qiwr3@chinaunicom.cn</div>"
//			+ "</div></span></div>";
	
	
	private Transport transport = null;
	private Session session = null;
	
	private String from = "qwanren@126.com"; // 发件人邮箱地址
	private String user = "qwanren@126.com"; // 发件人称号，同邮箱地址
	private String password = "qiwanren123"; // 发件人邮箱客户端授权码

	public MailUtils(){
		
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", "smtp.126.com"); // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
		prop.put("mail.smtp.host", "smtp.126.com"); // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
		prop.put("mail.smtp.auth", "true"); // 用刚刚设置好的props对象构建一个session
	
		//使用JavaMail发送邮件的5个步骤
		//1、创建session
		session = Session.getInstance(prop);
		//开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
	}
	
	/**
    * @Method: createSimpleMail
    * @Description: 创建一封只包含文本的邮件
    * @Anthor:孤傲苍狼
    *
    * @param session
    * @return
    * @throws Exception
    */ 
    public boolean sendMessage(String to,String content,String title){
    	
    	System.out.println(content);
    	
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        try {
			message.setFrom(new InternetAddress(from));
			//指明邮件的收件人
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        //邮件的标题
	        message.setSubject(title);
	        Multipart multipart = new MimeMultipart(); // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			BodyPart contentPart = new MimeBodyPart(); // 设置邮件的文本内容
			contentPart.setContent(content, "text/html;charset=utf-8");
			multipart.addBodyPart(contentPart);
			message.setContent(multipart);
			message.saveChanges(); // 保存变化
			transport = session.getTransport("smtp"); // 连接服务器的邮箱
			transport.connect("smtp.126.com", user, password); // 把邮件发送出去
			transport.sendMessage(message, message.getAllRecipients());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				transport.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
        return true;
    }
    
    public static void main(String[] args) {
		
    	MailUtils ds = new MailUtils();
    	String message = "<html><head>"+
    				"<title>邮件测试</title></head><body><table border=\"1\"><tr><td>"+
    				"this is sendMail test !!!" +
    				"</td></tr></table></body></html>";

		ds.sendMessage("qwanhong@126.com", message, "测试邮件");
	}
	
}

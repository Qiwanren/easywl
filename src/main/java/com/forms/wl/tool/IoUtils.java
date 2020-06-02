package com.forms.wl.tool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;


@Service
public class IoUtils {
	
	private InputStream in = null;
	private BufferedReader bReader = null;
	
	/**
	 * 到指定路径，读取指定文件内容   filename 必须是全名称 ，例如 file.txt
	 * 
	 * @param readPath
	 * @param fileNmae
	 * @return
	 */
	public String readFiles(String readPath,String fileNmae){
		
		StringBuffer buffer = new StringBuffer("");
		
		try {
			in = new FileInputStream(readPath+fileNmae);
			//File doneFile = new File( doneFilePath );
	        bReader = new BufferedReader( new InputStreamReader(in) );
	        
	        String line = null;
	        while ( ( line = bReader.readLine() ) != null )
	        {
	        	buffer.append(line+"\n");
	        }
	        
	        return buffer.toString();
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
				bReader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}

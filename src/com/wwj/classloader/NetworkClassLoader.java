package com.wwj.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NetworkClassLoader extends ClassLoader {
	
	private String filePath;
	private boolean isDecode;

	public NetworkClassLoader(String filePath,boolean isDecode){
		super();
		this.filePath=filePath;
		this.isDecode=isDecode;
	}

	public Class<?> findClass(String name) {
		byte[] b = loadClassData(name);
		
		//把字节码数据转化为Clsss对象
		return defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData(String name) {
		// load the class data from the connection
		byte[] byteClass = null;

		String className=name.substring(name.lastIndexOf(".")+1);
		System.out.println(className);
		if(isDecode){
			className+=".classen";
		}else{
			className+=".class";
		}
		
		
		File file=new File(filePath,className);
		if(!file.exists()){
			System.out.println("------文件不存在="+file.getAbsolutePath());
			return null;
		}
		FileInputStream fileInputStream=null;
		try {
			int len=(int) file.length();
			fileInputStream=new FileInputStream(file);
			byteClass=new byte[len];
			
			fileInputStream.read(byteClass, 0, len);
			
			if(isDecode){
				for(int i=0;i<len;i++){
					byteClass[i] ^= FileUtils.PASSWORD;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return byteClass;
	}

}

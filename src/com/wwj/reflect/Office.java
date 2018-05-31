package com.wwj.reflect;


class Office{
	public static void main(String[] args) {
		//new 创建的对象是静态的
		//编译是加载所有可能用到的类
		if("word".equals(args[0])){
			Word word=new Word();
			word.start();
		}else if("excel".equals(args[0])){
			Excel excel=new Excel();
			excel.start();
		}else if("ppt".equals(args[0])){
			PPT ppt=new PPT();
			ppt.start();
		}
	}
}
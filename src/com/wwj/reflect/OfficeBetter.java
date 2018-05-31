package com.wwj.reflect;
class OfficeBetter{
	public static void main(String[] args) {
		try{
			//获取一个类的类类型
			Class clazz=Class.forName(args[0]);
			OfficeAble oa=(OfficeAble)clazz.newInstance();
			oa.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
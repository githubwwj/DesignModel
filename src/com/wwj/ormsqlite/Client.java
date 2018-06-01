package com.wwj.ormsqlite;

import java.lang.reflect.Field;

public class Client {

	public static void main(String[] args) {

		User user = new User();
		user.setId(10);
		user.setHobby("羽毛球,乒乓球,爬山,游泳");

		String sql = querySql(user);
		System.out.println(sql);

	}

	private static String querySql(User user) {
		// 我们想要获取类信息,首先要获取类类型

		Class clazz = user.getClass(); // java.lang.Class

		boolean isAnnotation = clazz.isAnnotationPresent(Table.class);
		if (!isAnnotation) {
			return null;
		}

		StringBuffer stringBuffer = new StringBuffer();
		Table table = (Table) clazz.getAnnotation(Table.class);

		stringBuffer.append("select * from " + table.value() + " where 1=1");

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			boolean isField = field.isAnnotationPresent(Column.class);
			if (!isField) {
				continue;
			}

			// 2 拿到字段值
			Object columnValue = null;
			try {
				field.setAccessible(true); // 设置可以访问私有属性
				columnValue = field.get(user);
				if (columnValue == null || columnValue.toString().equals("0")) {
					continue;
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 1 拿到字段名
			Column column = field.getAnnotation(Column.class);
			String columnName = column.value(); // 获取字段名
			

			if(columnValue instanceof String){
				String[] arr=((String) columnValue).split(",");
				stringBuffer.append(" and " + columnName + " in(");
				for(String str:arr){
					stringBuffer.append("'"+str + "',");
				}
				stringBuffer.deleteCharAt(stringBuffer.length()-1);
				stringBuffer.append(")");
			}else{
				stringBuffer.append(" and " + columnName + "=");
				stringBuffer.append(columnValue);
			}
			
		}

		return stringBuffer.toString();
	}

}

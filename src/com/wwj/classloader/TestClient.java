package com.wwj.classloader;

import java.lang.reflect.Method;

public class TestClient {

	public static void main(String[] args) {

		NetworkClassLoader networkClassLoader = new NetworkClassLoader(
				"D:\\Android\\eclipseWorkSpace\\DesignModel\\bin",false);

		try {
			Class<?> clazz = networkClassLoader.loadClass("com.wwj.classloader.Plane");
			System.out.println(networkClassLoader.getParent());

			if (null == clazz) {
				return;
			}

			Plane planeObj = (Plane) clazz.newInstance();
			planeObj.setName("波音747大飞机");

			System.out.println(planeObj.getName());

			Object planeObj2 = clazz.newInstance();

			Method mSetFlyHeight = clazz.getDeclaredMethod("setPlaneHeight",
					int.class);
			mSetFlyHeight.invoke(planeObj2, 99999);

			Method method = clazz.getDeclaredMethod("getPlaneHeight");
			Object result = method.invoke(planeObj2);
			System.out.println(result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int a = 2;
		int b = 13;
		int c = a ^ b;
		System.out.println("a^b=" + c);

	}

}

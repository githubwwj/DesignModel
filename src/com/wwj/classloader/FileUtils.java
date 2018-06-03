package com.wwj.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

	public static final int PASSWORD = 12345;

	public static void test(String path) {
		File file = new File(path);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(path+"en");
			int b = 0;
			while ((b = fis.read()) != -1) {
				// 每一个byte异或一个数字2
				fos.write(b ^ PASSWORD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

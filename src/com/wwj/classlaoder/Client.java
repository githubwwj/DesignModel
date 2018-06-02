package com.wwj.classlaoder;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.StringTokenizer;

public class Client {

	public static void main(String[] args) {
		System.out.println("Hello world!");

		Class<?> clazz = Client.class;
		ClassLoader classLoader = clazz.getClassLoader();

		System.out.println(classLoader);

		URL[] urls = ((URLClassLoader) (classLoader)).getURLs();

		for (URL u : urls) {
			System.out.println(u.toString());
		}

		ClassLoader parentClassLoader = classLoader.getParent();
		System.out.println(parentClassLoader);

		urls = ((URLClassLoader) (parentClassLoader)).getURLs();

		for (URL u : urls) {
			System.out.println(u.toString());
		}

		parentClassLoader = parentClassLoader.getParent();
		System.out.println(parentClassLoader);

		// sun.misc.Launcher

		final String s = System.getProperty("java.class.path");
		System.out.println(s);
		File[] paths = (s == null) ? new File[0] : getClassPath(s);

		for (File path : paths) {
			System.out.println(path);
		}

		String strManager = System.getProperty("java.security.manager");
		System.out.println(strManager);

		ClassLoader currentThreadClassLoader = Thread.currentThread()
				.getContextClassLoader();
		System.out.println(currentThreadClassLoader);

		paths = getExtDirs();

		for (File path : paths) {
			System.out.println(path);
		}

		String bootClassPath = System.getProperty("sun.boot.class.path");
		String[] strBottClassPath = bootClassPath.split(";");
		for (String strBoot : strBottClassPath) {
			System.out.println(strBoot);
		}

		ClassLoader cl = int.class.getClassLoader();

		System.out.println("ClassLoader is:" + cl.toString());
	}

	private static File[] getExtDirs() {
		String s = System.getProperty("java.ext.dirs");
		File[] dirs;
		if (s != null) {
			StringTokenizer st = new StringTokenizer(s, File.pathSeparator);
			int count = st.countTokens();
			dirs = new File[count];
			for (int i = 0; i < count; i++) {
				dirs[i] = new File(st.nextToken());
			}
		} else {
			dirs = new File[0];
		}
		return dirs;
	}

	private static File[] getClassPath(String cp) {
		File[] path;
		if (cp != null) {
			int count = 0, maxCount = 1;
			int pos = 0, lastPos = 0;
			// Count the number of separators first
			while ((pos = cp.indexOf(File.pathSeparator, lastPos)) != -1) {
				maxCount++;
				lastPos = pos + 1;
			}
			path = new File[maxCount];
			lastPos = pos = 0;
			// Now scan for each path component
			while ((pos = cp.indexOf(File.pathSeparator, lastPos)) != -1) {
				if (pos - lastPos > 0) {
					path[count++] = new File(cp.substring(lastPos, pos));
				} else {
					// empty path component translates to "."
					path[count++] = new File(".");
				}
				lastPos = pos + 1;
			}
			// Make sure we include the last path component
			if (lastPos < cp.length()) {
				path[count++] = new File(cp.substring(lastPos));
			} else {
				path[count++] = new File(".");
			}
			// Trim array to correct size
			if (count != maxCount) {
				File[] tmp = new File[count];
				System.arraycopy(path, 0, tmp, 0, count);
				path = tmp;
			}
		} else {
			path = new File[0];
		}
		// DEBUG
		// for (int i = 0; i < path.length; i++) {
		// System.out.println("path[" + i + "] = " + '"' + path[i] + '"');
		// }
		return path;
	}

}
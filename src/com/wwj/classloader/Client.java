package com.wwj.classloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.StringTokenizer;

import sun.net.www.ParseUtil;

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
		System.out.println("----------"+parentClassLoader);

		// 引用类加载器 大致推算出 负责加载核心类库
		String bootClassPath = System.getProperty("sun.boot.class.path");
		String[] bootClassPathArr = bootClassPath.split(";");
		for (String bootStr : bootClassPathArr) {
			System.out.println(bootStr);
		}

		ClassLoader contextClassLoader = Thread.currentThread()
				.getContextClassLoader();
		System.out.println(contextClassLoader);

		// sun.misc.Launcher
		File[] dirs = getExtDirs();
		for (File dir : dirs) {
			System.out.println(dir);
		}

		
		
//		=====================打印工程的URL
		System.out.println("--------------------------------------");
		final String s = System.getProperty("java.class.path");
		System.out.println(s);

		final File[] path = (s == null) ? new File[0] : getClassPath(s);
		urls = (s == null) ? new URL[0] : pathToURLs(path);
		for (URL u : urls) {
			System.out.println(u.toString());
		}
		
		ClassLoader	cl = int.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());

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

	private static URL[] pathToURLs(File[] path) {
		URL[] urls = new URL[path.length];
		for (int i = 0; i < path.length; i++) {
			urls[i] = getFileURL(path[i]);
		}
		// DEBUG
		// for (int i = 0; i < urls.length; i++) {
		// System.out.println("urls[" + i + "] = " + '"' + urls[i] + '"');
		// }
		return urls;
	}

	static URL getFileURL(File file) {
		try {
			file = file.getCanonicalFile();
		} catch (IOException e) {
		}

		try {
			return ParseUtil.fileToEncodedURL(file);
		} catch (MalformedURLException e) {
			// Should never happen since we specify the protocol...
			throw new InternalError();
		}
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

}
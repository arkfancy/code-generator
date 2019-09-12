package com.arkfancy.generator.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

	private static final Properties properties;

	private static final String BASE_PATH = "application.properties";

	static {
		properties = new Properties();
		try {
			InputStream is = PropertiesUtils.class.getClassLoader().getResourceAsStream(BASE_PATH);
			properties.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static Properties getProperties() {
//		if (properties == null) {
//			synchronized (properties) {
//				if (properties == null) {
//					try {
//						properties = new Properties();
//						InputStream is = new FileInputStream(BASE_PATH);
//						properties.load(is);
//					} catch (FileNotFoundException e) {
//						e.printStackTrace();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//		}
//		return properties;
//	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(get("a"));
	}
}

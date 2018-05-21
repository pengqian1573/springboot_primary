package com.pq.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	
	public static Gson getGson() {
		return new Gson();
	}

	/**
	 * 将对象转为JSON字符串
	 * 
	 * @param src
	 * @return
	 */
	public static String toJson(Object src) {
		return getGson().toJson(src);
	}

	/**
	 * 将对象转为JSON字符串(不忽略NULL值)
	 * 
	 * @param src
	 * @param serializeNulls
	 * @return
	 */
	public static String toJson(Object src, boolean serializeNulls) {
		if (serializeNulls)
			return new GsonBuilder().serializeNulls().create().toJson(src);
		return toJson(src);
	}

	/**
	 * 将JSON转为指定的对象
	 * 
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> classOfT) {
		return getGson().fromJson(json, classOfT);
	}

	/**
	 * 从请求体中读取客户端发送的JSON串
	 * 
	 * @param stream
	 *            输入流
	 * @return String 类型，接收到的JSON串
	 */
	public static String readStringFromRequestBody(InputStream stream) {
		StringBuffer sb = new StringBuffer();
		char[] buf = new char[2048];
		int len = -1;
		try {
			InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
			while ((len = reader.read(buf)) != -1) {
				sb.append(new String(buf, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
				}
			}
		}
		return sb.toString();
	}
}

package com.sf.jvm.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：内存溢出时查看系统内存结构
 * 
 * 		VM arguments添加：
 *			 			-Xms1m 
 *						-Xmx8m 
 *						-XX:+PrintGCDetails 
 *						-XX:+HeapDumpOnOutOfMemoryError 
 *						-XX:HeapDumpPath=D:/app/dep/test-jvm.hprof			//生成的hprof文件位置，不加默认生成在当前工程下
 *																			//java -jar启动jar包，如不加路径默认生成的hprof文件与jar包同级
 * @author 80002888
 * @date   2018年7月5日
 */
public class Mat {
	
	@SuppressWarnings("unused")
	private byte[] bytes = new byte[1*1024*1024];
	
	public static void main(String[] args) {
		List<Mat> list = new ArrayList<Mat>();
		while (true) {
			list.add(new Mat());
		}
	}

}
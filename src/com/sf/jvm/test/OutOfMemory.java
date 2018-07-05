package com.sf.jvm.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：堆内存溢出异常--------Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * @author 80002888
 * @date   2018年7月5日
 */
public class OutOfMemory {

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		// 不断创建对象，并保证GC Roots到对象之间有可达路径，避免垃圾回收清除创建的对象
		while (true) {
			list.add(new OOMObject());
		}
	}
	
	// 定义一个静态内部类
	public static class OOMObject {
		private byte[] bytes = new byte[1*1024*1024];

		public byte[] getBytes() {
			return bytes;
		}
		public void setBytes(byte[] bytes) {
			this.bytes = bytes;
		}
	}

}

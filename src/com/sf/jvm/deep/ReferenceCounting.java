package com.sf.jvm.deep;

/**
 * 描述：引用计数法
 * @author 80002888
 * @date   2019年11月27日
 */
public class ReferenceCounting {

	private Object instance;
	
	/**
	 * 1MB，这个变量的唯一意义是占内存，以便能在GC日志中看清楚是否被回收过
	 */
	private byte[] arr = new byte[1024 * 1024];
	
	public static void main(String[] args) {
		ReferenceCounting objectA = new ReferenceCounting();
		ReferenceCounting objectB = new ReferenceCounting();
		objectA.instance = objectB;
		objectB.instance = objectA;
		
		objectA = null;
		objectB = null;
		// 假设这里发生GC，objectA和objectB能否被回收？
		// -XX:+PrintGCDetails 
		System.gc();
		System.gc();
	}
	
}

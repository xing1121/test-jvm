package com.sf.jvm.test;

public class TestMemory {
	
	public static void main(String[] args) {
		long maxMemory = Runtime.getRuntime().maxMemory();	//Java虚拟机中试图使用的最大内存量（堆）  默认 1/4 物理内存
		long totalMemory = Runtime.getRuntime().totalMemory();//Java虚拟机中的内存总量（堆）（初始分配大小）  默认 1/64 物理内存
		System.out.println("MAX_MEMORY = "+maxMemory+"（字节）、"+((double)maxMemory/1024/1024)+"MB");
		System.out.println("TOTAL_MEMORY = "+totalMemory+"（字节）、"+((double)totalMemory/1024/1024)+"MB");
	}
	
}

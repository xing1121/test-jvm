package com.sf.jvm.test;

/**
 * 描述：栈溢出异常--------Exception in thread "main" java.lang.StackOverflowError
 * @author 80002888
 * @date   2018年7月5日
 */
public class StackOverFlow {
	
	public static void main(String[] args) {
		sayHello();
	}
	
	public static void sayHello(){
		sayHello();
	}
	
}

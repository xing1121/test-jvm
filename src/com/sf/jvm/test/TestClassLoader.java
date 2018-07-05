package com.sf.jvm.test;

/**
 * 三种类加载器：
 * 第一种：启动类加载器（Bootstarp），使用C++编写，加载$JAVAHOME/jre/lib/rt.jar......
 * 第二种：扩展类加载器（Extension），使用Java编写， 加载$JAVAHOME/jre/lib/ext/*.jar
 * 第三种：应用程序类加载器（App），使用Java编写，也叫系统类加载器，加载当前应用的classpath的所有类
 */
public class TestClassLoader {

	public static void main(String[] args) throws Exception {
		
		// 		D:\DevSoft\JDK\jdk1.8.0_45\jre\lib\resources.jar;
		//		D:\DevSoft\JDK\jdk1.8.0_45\jre\lib\rt.jar;
		//		D:\DevSoft\JDK\jdk1.8.0_45\jre\lib\sunrsasign.jar;
		//		D:\DevSoft\JDK\jdk1.8.0_45\jre\lib\jsse.jar;
		//		D:\DevSoft\JDK\jdk1.8.0_45\jre\lib\jce.jar;
		//		D:\DevSoft\JDK\jdk1.8.0_45\jre\lib\charsets.jar;
		//		D:\DevSoft\JDK\jdk1.8.0_45\jre\lib\jfr.jar;
		//		D:\DevSoft\JDK\jdk1.8.0_45\jre\classes
		System.out.println("BootstarpClassLoader 加载：" + System.getProperty("sun.boot.class.path"));

		//		D:\DevSoft\JDK\jdk1.8.0_45\jre\lib\ext;
		//		C:\Windows\Sun\Java\lib\ext
		System.out.println("ExtensionClassLoader 加载：" + System.getProperty("java.ext.dirs"));
		
		//		D:\DevSoft\mars-workspace\test-jvm\bin
		System.out.println("AppClassLoader 加载：" + System.getProperty("java.class.path"));
		
		System.out.println("--------------------------");
		
		System.out.println("****:"+new Object().getClass().getClassLoader());//****:null，因为Bootstarp加载器使用c++编写， 所以获取不到名字
		System.out.println("****:"+Class.forName("com.sun.media.jfxmediaimpl.HostUtils").getClassLoader());//****:sun.misc.Launcher$ExtClassLoader@6d06d69c
		System.out.println("****:"+TestClassLoader.class.getClassLoader());//****:sun.misc.Launcher$AppClassLoader@c387f44

		System.out.println("--------------------------");
		
		System.out.println("****:"+TestClassLoader.class.getClassLoader());//****:sun.misc.Launcher$AppClassLoader@c387f44
		System.out.println("****parent:"+TestClassLoader.class.getClassLoader().getParent());//****parent:sun.misc.Launcher$ExtClassLoader@6d06d69c
		System.out.println("****parent parent:"+TestClassLoader.class.getClassLoader().getParent().getParent());//****parent parent:null
	
	}
	
}

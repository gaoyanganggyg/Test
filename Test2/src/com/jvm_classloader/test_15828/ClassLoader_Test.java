package com.jvm_classloader.test_15828;
/**
 * 1、启动类加载器（BootStrap ClassLoader）
 * 		主要负责加载<JAVA_HOME>/lib目录中或者-Xbootclasspath参数指定的路径中的，并且可以被虚拟机识别（仅仅按照文件名识别）的类库加载到虚拟机内存当中。
 * 		它加载的是System.getProperty（“sun.boot.class.path”）所指定路径或jar
 * 
 * 2、扩展类加载器（Extension ClassLoader）
 * 		主要负责加载<JAVA_HOME>/lib/ext目录中的，或者被java.ext.dirs系统环境变量所指定路径中的所有类库。
 * 		它加载的是System.getProperty("java.ext.dirs")所指定的路径或jar
 * 
 * 3、应用程序类加载器（Application ClassLoader）又叫系统类加载器
 * 		主要加载ClassPath路径上的类库，如果应用程序没有定义自己的类加载器，则这个是默认的类加载器
 * 		它主要加载System.getProperty("java.class.path")所指定的路径或jar
 * 
 * 4、类加载器的特点
 * 	  （1）、运行一个程序时，总是由系（Application ClassLoader）统类加载器开始加载指定的类
 * 	  （2）、在加载类时，每个类将加载任务上交给父类，如果父类找不到，再由自己去加载
 *   （3）、BootStrap Loader（启动类加载器）是最顶级的类加载器，其父加载器为null
 * 
 * 5、使用双亲委派两个原因：（1）、避免重复加载，（2）、安全因素  
 * 
 * 6、类加载实例
 *  （1）、寻找jre目录，寻找jvm.dll,并初始化JVM
 *  （2）、产生一个BootStrap Loader
 *  （3）、BootStrap Loader会加载指定目录下的java核心API，并且再自动加载Extended ClassLoader，
 *  	 Extended ClassLoader会加载指定目录下的扩展JavaAPI，并将父类Loader设为BootStrap Loader
 *  （4）、BootStrap Loader也会加载AppClass Loader，并将父类Loader设为Extended Loader
 *  （5）、最后又AppClass Loader加载CLASSPATH目录定义的类
 * 
 * @author Administrator
 *
 */

public class ClassLoader_Test {
	public static void main(String[] args) {
		//启动类加载器
		System.out.println(System.getProperty("sun.boot.class.path"));
		//扩展类加载器
		System.out.println(System.getProperty("java.ext.dirs"));
		//应用程序加载器
		System.out.println(System.getProperty("java.class.path"));
	}

}

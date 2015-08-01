package com.java.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.java.service.CacheaBleT1;
import com.java.service.CacheaBleT2;
import com.java.service.CacheaBleT3;
import com.java.service.Hello;
import com.java.service.User;
import com.java.util.Print;

public class SpringTest {
	public static void main(String[] args) {
		String fileName = "struts.xml";
		//resourceTest(new ClassPathResource(fileName));
		//resourceTest(new FileSystemResource(fileName));
		resourceLoaderTest();
	}
	
	private static void resourceTest(Resource resource){
		Resource re = resource;
		Print.print(re.getFilename());
		Print.print(re.getDescription());
	}
	
	private static void resourceLoaderTest(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		CacheaBleT1 c1 = ctx.getBean("cache1", CacheaBleT1.class);
//		User u1 = c1.t1("gao", 11);
//		CacheaBleT2 c2 = ctx.getBean("cache2", CacheaBleT2.class);
//		User u2 = c2.t1("gao", 12);
//		Print.print(u1 == u2);
//		CacheaBleT3 c3 = ctx.getBean("cache3", CacheaBleT3.class);
//		c3.t2("gao", 11);
//		
//		User u3 = c2.t1("gao", 11);
//		Print.print(u1 == u3);
		
		Hello hello = ctx.getBean("hello", Hello.class);
		hello.foo();
		hello.addUser("gao", "123");
		
//		com.mchange.v2.c3p0.ComboPooledDataSource cpds = ctx.getBean("dataSource", com.mchange.v2.c3p0.ComboPooledDataSource.class);
//		
//		Print.print(cpds.getDriverClass());
//		Print.print(cpds.getJdbcUrl());
//		Print.print(cpds.getDescription());
//		Print.print(cpds.getDataSourceName());
//		
//		Resource re = ctx.getResource("file:struts.xml");
//		resourceTest(re);
	}
}

package com.java.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

import com.java.util.Print;

@Component("cache3")
public class CacheaBleT3 {
	@CacheEvict(value="users")
	public void t1(String name, int age) {
		Print.print("t1 cacheevict: " + name + " " + age);
	}
	@CacheEvict(value="users", allEntries=true)
	public void t2(String name, int age) {
		Print.print("t2 cacheevict: " + name + " " + age);
	}
}

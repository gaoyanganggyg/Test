package com.java.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.java.util.Print;

@Component("cache2")
public class CacheaBleT2 {
	@Cacheable(value="users", key="#name")
	public User t1(String name, int age) {
		Print.print("t1: " + name + " " + age);
		return new User(name, age);
	}
	@Cacheable(value="users")
	public void t2(String name, int age) {
		Print.print("t2: " + name + " " + age);
	}
}

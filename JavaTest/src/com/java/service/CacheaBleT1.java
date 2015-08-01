package com.java.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.java.util.Print;

@Cacheable(value = "users", key="#name")
@Component("cache1")
public class CacheaBleT1 {
	public User t1(String name, int age) {
		Print.print("t1: " + name + " " + age);
		return new User(name, age);
	}

	public void t2(String name, int age) {
		Print.print("t2: " + name + " " + age);
	}
}

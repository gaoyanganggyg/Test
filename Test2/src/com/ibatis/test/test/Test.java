package com.ibatis.test.test;

import java.util.ArrayList;
import java.util.List;

import com.ibatis.test.dao.IPersonDao;
import com.ibatis.test.dao.impl.PersonDao;
import com.ibatis.test.domain.Person;

public class Test {
	public static void main(String[] args) {
		IPersonDao personDao = new PersonDao();
//		for(int i = 0; i < 10; i++){
//			Person person = new Person();
//			person.setId(i + 2);
//			person.setName("gao" + i);
//			person.setSex(i % 2 == 0 ? 1 : 2);
//			
//			personDao.addPerson(person);
//		}
		
//		for (Person person2 : personDao.selectPerson()) {
//			System.out.println(person2.getId() + " " + person2.getName() + " "+ person2.getSex());
//		}
//		
//		for (Person person : personDao.selectPersonById(1)) {
//			System.out.println(person.getName());
//		}
		
		Person person1 = new Person();
		person1.setId(1);
		person1.setName("hello");
		person1.setSex(1);
		personDao.updatePerson(person1);
		
		personDao.deletePerson(11);
		
	}
}

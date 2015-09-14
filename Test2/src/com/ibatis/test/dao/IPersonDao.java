package com.ibatis.test.dao;

import java.util.List;

import com.ibatis.test.domain.Person;

public interface IPersonDao {
	
	List<Person> selectPerson();
	
	List<Person> selectPersonById(int id);
	
	List<Person> selectPersonByName(String name);
	
	void updatePerson(Person person);
	
	void addPerson(Person person);
	
	void deletePerson(int id);
}

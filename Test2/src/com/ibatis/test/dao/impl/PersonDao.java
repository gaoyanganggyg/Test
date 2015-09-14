package com.ibatis.test.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.test.dao.IPersonDao;
import com.ibatis.test.domain.Person;

public class PersonDao implements IPersonDao{
	static SqlMapClient sqlMapClient;
	static Reader reader;
	
	static{
		try {
			reader = Resources.getResourceAsReader("com/ibatis/test/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void addPerson(Person person) {
		try {
			Object object = sqlMapClient.insert("addPerson", person);
			System.out.println(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePerson(int id) {
		try {
			int num = sqlMapClient.delete("deletePerson", id);
			System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	};
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> selectPerson() {
		List<Person> list = null;
		try {
			list = sqlMapClient.queryForList("selectAllPerson");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public java.util.List<Person> selectPersonById(int id) {
		List<Person> list = null;
		try {
			list = sqlMapClient.queryForList("selectPersonById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	};
	
	@SuppressWarnings("unchecked")
	public java.util.List<Person> selectPersonByName(String name) {
		List<Person> list = null;
		
		try {
			list = sqlMapClient.queryForList("selectPersonByName", name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	};
	
	@Override
	public void updatePerson(Person person) {
		try {
			sqlMapClient.update("updatePerson", person);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

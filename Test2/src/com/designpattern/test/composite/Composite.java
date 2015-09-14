package com.designpattern.test.composite;

import java.util.ArrayList;
import java.util.List;
/**
 * 组合模式（Composite）
 * 
 * 将对象组合为树型结构以表示“部分-整体”的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性
 * @author Administrator
 *
 */
public class Composite {
	public static void main(String[] args) {
		Employer employer1 = new Programmer("A");
		Employer employer2 = new ProjectAssist("B");

		employer2.add(employer1);
		
		for (Employer employer : employer2.getEmplyers()) {
			System.out.println(employer.getName());
		}
	}
}

abstract class Employer{
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	 abstract void add(Employer employer);
	 abstract void delete(Employer employer);
	
	 List<Employer> employers;
	 
	 public List<Employer> getEmplyers() {
		return employers;
	}
}

class Programmer extends Employer{
	
	public Programmer(String name) {
		setName(name);
		employers = null;
	}
	
	@Override
	void add(Employer employer) {
	}
	
	@Override
	void delete(Employer employer) {
	}
}

class ProjectAssist extends Employer{
	
	public ProjectAssist(String name) {
		setName(name);
		employers = new ArrayList<Employer>();
	}
	
	@Override
	void add(Employer employer) {
		employers.add(employer);
	}
	
	@Override
	void delete(Employer employer) {
		
	}
}





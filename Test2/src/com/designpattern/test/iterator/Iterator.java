package com.designpattern.test.iterator;

import java.util.ArrayList;
import java.util.List;
/**
 * 迭代器模式（Iterator）
 * 提供一种方法顺序访问一个聚合对象中各个元素，而不暴露该对象的内部表示
 * @author Administrator
 *
 */
public class Iterator {
	public static void main(String[] args) {
		IAggregate aggregate = new Aggregate();
		
		aggregate.add(100);
		aggregate.add(101);
		aggregate.add(102);
		
		IIterator iterator = aggregate.iIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}

interface IIterator{
	Integer next();
	boolean hasNext();
}

class Iterator1 implements IIterator{
	private List<Integer> list;
	private int curs;
	
	public Iterator1(List<Integer> list) {
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		if(curs == list.size())
			return false;
		return true;
	}
	
	@Override
	public Integer next() {
		return list.get(curs++);
	}
}

interface IAggregate{
	void add(Integer num);
	void remove(Integer num);
	IIterator iIterator();
}

class Aggregate implements IAggregate{
	private List<Integer> list = new ArrayList<Integer>();
	
	@Override
	public void add(Integer num) {
		list.add(num);
	}
	
	@Override
	public void remove(Integer num) {
		list.remove(num);
	}
	
	@Override
	public IIterator iIterator() {
		return new Iterator1(list);
	}
}

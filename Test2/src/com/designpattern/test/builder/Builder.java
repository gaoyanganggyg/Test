package com.designpattern.test.builder;
/**
 * 建造者模式
 * 将一个复杂对象的构建与他的表示分离，使得同样的构建过程可以创建不同的表示
 * @author Administrator
 *
 */
public class Builder {
	public static void main(String[] args) {
		Director director = new Director();
		director.createProductA();
		
		director.createProductB();
	}

}

class Product{
	private String name;
	private String type;
	
	public void showProduct(){
		System.out.println(type);
		System.out.println(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
}

interface Builder1{
	public void setPart(String type, String name);
	public Product getProduct();
}

class Builder1Impl implements Builder1{
	Product products = new Product();
	@Override
	public Product getProduct() {
		return products;
	}
	@Override
	public void setPart(String type, String name) {
		products.setName(name);
		products.setType(type);
	}
}

class Director{
	public void createProductA() {
		Builder1 builder1 = new Builder1Impl();
		builder1.setPart("car", "gao");
		builder1.getProduct();
	}
	
	public void createProductB(){
		Builder1 builder1 = new Builder1Impl();
		builder1.setPart("bycicle", "gao");
		builder1.getProduct();
	}
}






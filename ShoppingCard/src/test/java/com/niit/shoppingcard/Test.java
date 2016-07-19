package com.niit.shoppingcard;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcard");
		context.refresh();
		Product p=(Product) context.getBean("product");
		p.setId("101");
		p.setName("Phone");
		p.setPrice(6000);
		System.out.println (p.getId());
		System.out.println (p.getName());
		System.out.println(p.getPrice());
		System.out.println("Category is created");

	}
}

package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.model.Product;

public class ProductTest {
	

public static void main(String[] args) {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcartbackend");
	context.refresh();
	
	ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
	Product product=(Product) context.getBean("product");
	product.setId("CG102");
	product.setName("CGName120");
	product.setDescription("CGDesc120");
	product.setPrice(1500);
	productDAO.saveOrUpdate(product);
	
}	
} 
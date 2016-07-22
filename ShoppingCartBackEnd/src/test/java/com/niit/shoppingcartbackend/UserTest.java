package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;

public class UserTest {
	

public static void main(String[] args) {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcartbackend");
	context.refresh();
	
	UserDAO userDAO = (UserDAO)context.getBean("userDAO");
	User user=(User) context.getBean("user");
	user.setId("CG102");
	user.setName("CGName120");
	user.setEmail("xyz@gmail.com");
	user.setPassword("******");
	user.setAddress("Hyderabad");
	user.setMobile("9999988888");
	userDAO.saveOrUpdate(user);
	
}	
} 
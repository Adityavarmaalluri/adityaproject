package com.niit.shoppingcartbackend.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Product;

import java.util.List;

@Repository("productDAO")

public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sesssionFactory)
	{
		this.sessionFactory= sesssionFactory;
	}
	@Transactional
	public void saveOrUpdate(Product product)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	
	}
	@Transactional
	public void delete(String id)
	{
		Product ProductToDelete=new Product();
		ProductToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
	}
	
 
@Transactional
public Product get(String id)
{
	String hql="from product whereid="+""+id+"";
	@SuppressWarnings("rawtypes")
	Query query=(Query)sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Product> listProduct=(List<Product>)query.getResultList();
	{ 
	if(listProduct!=null && listProduct.isEmpty())
		return listProduct.get(0);
	}
	return null;
}
@Transactional
public List<Product> list()
{
	
	List<Product>listProduct=(List<Product>)
	sessionFactory.getCurrentSession()
	.createCriteria(Product.class)
	.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
return listProduct;
}

}




 

 
 
 
 
 
 
 
 
 

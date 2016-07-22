package com.niit.shoppingcartbackend.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Category;

import java.util.List;

@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sesssionFactory)
	{
		this.sessionFactory= sesssionFactory;
	}
	@Transactional
	public void saveOrUpdate(Category category)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	
	}
	@Transactional
	public void delete(String id)
	{
		Category CategoryToDelete=new Category();
		CategoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
	}
	
 
@Transactional
public Category get(String id)
{
	String hql="from category whereid="+""+id+"";
	@SuppressWarnings("rawtypes")
	Query query=(Query)sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Category> listCategory=(List<Category>)query.getResultList();
	{ 
	if(listCategory!=null && listCategory.isEmpty())
		return listCategory.get(0);
	}
	return null;
}
@Transactional
public List<Category> list()
{
	
	List<Category>listCategory=(List<Category>)
	sessionFactory.getCurrentSession()
	.createCriteria(Category.class)
	.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
return listCategory;
}

}




 

 
 
 
 
 
 
 
 
 

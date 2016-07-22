package com.niit.shoppingcartbackend.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.User;

import java.util.List;

@Repository("userDAO")

public class UserDAOImpl implements UserDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sesssionFactory)
	{
		this.sessionFactory= sesssionFactory;
	}
	@Transactional
	public void saveOrUpdate(User user)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	
	}
	@Transactional
	public void delete(String id)
	{
		User UserToDelete=new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
	}
	
 
@Transactional
public User get(String id)
{
	String hql="from user whereid="+""+id+"";
	@SuppressWarnings("rawtypes")
	Query query=(Query)sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<User> listUser=(List<User>)query.getResultList();
	{ 
	if(listUser!=null && listUser.isEmpty())
		return listUser.get(0);
	}
	return null;
}
@Transactional
public List<User> list()
{
	
	List<User>listUser=(List<User>)
	sessionFactory.getCurrentSession()
	.createCriteria(User.class)
	.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
return listUser;
}

}




 

 
 
 
 
 
 
 
 
 

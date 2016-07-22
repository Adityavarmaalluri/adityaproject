package com.niit.shoppingcartbackend.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Supplier;

import java.util.List;

@Repository("supplierDAO")

public class SupplierDAOImpl implements SupplierDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sesssionFactory)
	{
		this.sessionFactory= sesssionFactory;
	}
	@Transactional
	public void saveOrUpdate(Supplier supplier)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	
	}
	@Transactional
	public void delete(String id)
	{
		Supplier SupplierToDelete=new Supplier();
		SupplierToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
	}
	
 
@Transactional
public Supplier get(String id)
{
	String hql="from supplier whereid="+""+id+"";
	@SuppressWarnings("rawtypes")
	Query query=(Query)sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Supplier> listSupplier=(List<Supplier>)query.getResultList();
	{ 
	if(listSupplier!=null && listSupplier.isEmpty())
		return listSupplier.get(0);
	}
	return null;
}
@Transactional
public List<Supplier> list()
{
	
	List<Supplier>listSupplier=(List<Supplier>)
	sessionFactory.getCurrentSession()
	.createCriteria(Supplier.class)
	.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
return listSupplier;
}

}




 

 
 
 
 
 
 
 
 
 


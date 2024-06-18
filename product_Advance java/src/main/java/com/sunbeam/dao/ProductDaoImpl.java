package com.sunbeam.dao;

import com.sunbeam.entities.Product;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;
import java.io.Serializable;




public class ProductDaoImpl implements ProductDao {
	

	@Override
	public String addProduct(Product product) {
		String mesg="product registration failed!!!";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Serializable productId=session.save(product);
			tx.commit();
			mesg="products added succesfully ,with ID"+productId;
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			
		}
		return mesg;
	}

	@Override
	public Product getProductDetailsById(Long productId) {
		Product user=null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			user=session.get(Product.class, productId);
			
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx !=null)
				 tx.rollback();
			throw e;
			
		}
		return user;
	}

}

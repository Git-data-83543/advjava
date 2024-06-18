package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;


import org.hibernate.*;
import org.hibernate.property.access.spi.Setter;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    public String addProduct(Product product) {
    	String msg = "Product added Successfully";
    	
    	Session session = getFactory().getCurrentSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	try {
    		Serializable prodId = session.save(product);
    		tx.commit();
    		msg = "Product added Successfully, with id: " + prodId;
    	}catch (RuntimeException e) {
			// TODO: handle exception
    		if(tx!=null) {
    			tx.rollback();
    		}
    		throw e;
		}
    	
		return msg;
    	
    }
    
    @Override
	public Product getProductById(int id) {
		Product product =null;
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			
			product=session.get(Product.class,id);//select
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return product;
	}

	@Override
	public List<Product> getProductRange(Double price1,Double price2, Category cat) {
	    String jpql = "select p from Product p where p.price between :start and :end and p.category = :cat";
	    List<Product> product  = null;
	    Session session = getFactory().getCurrentSession();
	    Transaction tx= session.beginTransaction();
	    
	    try {
			product = session.createQuery(jpql,Product.class).setParameter("start", price1).setParameter("end", price2).setParameter("cat", cat).getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return product;

	}

	@Override
	public String DiscountedProduct(Double discount,Category cat) {
        String msg = "Applying Discount Failed";
		String jpql = "update Product p set p.price=p.price-:disc where p.category=:cat";
		
		Session session = getFactory().getCurrentSession();
		    Transaction tx= session.beginTransaction();
		    
		    try {
				int dis = session.createQuery(jpql).setParameter("disc", discount).setParameter("cat", cat).executeUpdate();
				tx.commit();
				msg = "Applied discount to Product: " + dis;
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}

			return msg;
	}

	@Override
	public String purchaseProduct(int id, int quantity) {
        String msg = "Purchasing Failed";
        Session session = getFactory().getCurrentSession();
	    Transaction tx= session.beginTransaction();
	    
	    try {
			Product prod = session.get(Product.class, id);
			
			if(prod.getQuantity()>=quantity) {
			   prod.setQuantity(prod.getQuantity()-quantity);
				msg = "Product Purchased";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return msg;
	}

	@Override
	public String deleteProduct(String productName) {
		 String msg = "Deleting Failed";
		 Product p = null;
		 String jpql = "select p from Product p where p.productName =:productName";
	        Session session = getFactory().getCurrentSession();
		    Transaction tx= session.beginTransaction();
		    
		    try {
               p = session.createQuery(jpql,Product.class).setParameter("productName", productName).getSingleResult();				
				
				   session.delete(p);
					msg = "Product Deleted";
				
				tx.commit();
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}

			return msg;
	}
	
	
	
}

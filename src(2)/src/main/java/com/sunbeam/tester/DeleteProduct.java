package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public class DeleteProduct {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
			Scanner sc=new Scanner(System.in)
			) {
		//create dao instance
		ProductDao dao=new ProductDaoImpl();
		System.out.println(" Enter product name(unique)"
				);
		System.out.println(dao.deleteProduct(sc.next().toUpperCase()));
	} //JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
}

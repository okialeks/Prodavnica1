package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Product;
import model.User;

public class AdminMetode {
	
	private SessionFactory sf = new Configuration()
			.configure()
			.buildSessionFactory();
	
public boolean ubaciProizvodUBazu(String productName, String price, String stock, String discount) {
		
		Product product = new Product();
			product.setProductName(productName);
			product.setPrice(Double.parseDouble(price));
			product.setStock(Integer.parseInt(stock));
			product.setDiscount(Double.parseDouble(discount));
		Session sesija = sf.openSession();
			sesija.beginTransaction();
				try {
					sesija.save(product);
					sesija.getTransaction().commit();
					return true;
				} catch (Exception e) {
					sesija.getTransaction().rollback();
					return false;
				}finally {
					sesija.close();
				}
	}
	

}

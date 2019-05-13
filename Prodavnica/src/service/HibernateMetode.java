package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Product;
import model.User;

public class HibernateMetode {
	
	private SessionFactory sf = new Configuration()
									.configure()
									.buildSessionFactory();
	
	
	public boolean ubaciUseraUBazu(String userName, String password) {
		
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
		
		Session sesija = sf.openSession();
			sesija.beginTransaction();
				try {
					sesija.save(user);
					sesija.getTransaction().commit();
					return true;
				} catch (Exception e) {
					sesija.getTransaction().rollback();
					return false;
				}finally {
					sesija.close();
				}
	}
	
	
	public List<Product> vratiSveProizvode(){
		
		List<Product> listaProizvoda = new ArrayList<Product>();
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				String hql = "FROM Product";
				Query query = sesija.createQuery(hql);
				listaProizvoda = query.getResultList();
				
				sesija.getTransaction().commit();
				return listaProizvoda;
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				return null;
			}finally {
				sesija.close();
			}
		
	}
	
	

	
	
}

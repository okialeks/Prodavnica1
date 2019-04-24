package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class LoginMetode {
	
	private SessionFactory sf = new Configuration()
			.configure()
			.buildSessionFactory();
	
	public boolean daLiPostojiUser(String userName){
		
		List<User> listOfUsers = new ArrayList<User>();
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				String hql = "FROM User WHERE userName = :comi";
				Query query = sesija.createQuery(hql);
				query.setParameter("comi", userName);
				
				listOfUsers = query.getResultList();
				
					if(listOfUsers.size()==1) {
						sesija.getTransaction().commit();
						System.out.println("Postoji taj user name");
						return true;
					}else {
						sesija.getTransaction().commit();
						System.out.println("Ne postoji taj user name");
						return false;
					}
					
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				return false;
			}finally {
				sesija.close();
			}
		
	}
	
	
	

}

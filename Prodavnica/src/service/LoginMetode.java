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
	
	public boolean daLiJeDobarPass(String userName, String password) {
		
		List<String>passwordi = null;
		String passwordIzBaze = null;
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				String hql = "SELECT password FROM User WHERE userName = :ime";
				Query query = sesija.createQuery(hql);
				query.setParameter("ime", userName);
					passwordi = query.getResultList(); // preuzimam rezultate iz baze
						if(!(passwordi.isEmpty())) { 
							passwordIzBaze = passwordi.get(0); // preuzimam password iz liste
								if(passwordIzBaze.equals(password)) {
									sesija.getTransaction().commit();
									System.out.println("pass ok");
									return true;
								}else {
									sesija.getTransaction().commit();
									System.out.println("pass nije ok");
									return false;
								}
						}else {
							sesija.getTransaction().commit();
							System.out.println("parzna je lista!");
							return false;
						}	
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				return false;
			}finally {
				sesija.close();
			}
		
	}
	
	public User vratiUsera(String userName, String password) {
		User user = null;
		Session sesija = sf.openSession();
		sesija.beginTransaction();
			try {
				String hql = "FROM User WHERE userName = :un AND password = :pass";
				Query query = sesija.createQuery(hql);
				query.setParameter("un", userName);
				query.setParameter("pass", password);
				user = (User)query.getResultList().get(0);
				sesija.getTransaction().commit();
				return user;
			} catch (Exception e) {
				sesija.getTransaction().rollback();
				return null;
			}finally {
				sesija.close();
			}
	}
	
	
	
	
	
	
	
	

}

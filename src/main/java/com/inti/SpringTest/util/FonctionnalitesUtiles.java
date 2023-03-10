package com.inti.SpringTest.util;

import org.hibernate.Session;

public class FonctionnalitesUtiles {
	
	public static Session session = HibernateUtil.getSessionFactory().openSession();

}

package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();  
	  
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("Onkar Londhe");
		emp.setEmpSal(50000);
		
		Address add1 = new Address();
		add1.setCity("Solapur");
		add1.setState("Maharastra");
		add1.setPincode(413410);
		
		Address add2 = new Address();
		add2.setCity("Pune");
		add2.setState("Maharastra");
		add2.setPincode(413411);
		
		List<Address> address = new ArrayList<>();
		address.add(add1);
		address.add(add2);
		
		emp.setAddress(address);
		
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		
		s.save(emp);
		s.save(add1);
		s.save(add2);
		
		t.commit();
		s.close();
		
		
	}

}
       
package com.jsp.person.bank;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDriver {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bank bank1 = new Bank();
		bank1.setName("HDFC");
		bank1.setLoc("Kamothe");

		Bank bank2 = new Bank();
		bank2.setName("ICICI");
		bank2.setLoc("Kharghar");

		Bank bank3 = new Bank();
		bank3.setName("SBI");
		bank3.setLoc("Panvel");

		ArrayList<Bank> al = new ArrayList<Bank>();
		al.add(bank1);
		al.add(bank2);
		al.add(bank3);

		Person person = new Person();
		person.setName("Advaith");
		person.setEmail("advaith12@gmail.com");
		person.setBanks(al);

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bank1);
		entityManager.persist(bank2);
		entityManager.persist(bank3);
		entityTransaction.commit();
		System.out.println("all good");
	}
}

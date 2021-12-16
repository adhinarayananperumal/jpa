package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class CompanySaveExp {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("corebanking");
			entityManager = emf.createEntityManager();
			
			transaction = entityManager.getTransaction();

			// start transaction
			transaction.begin();

			// entity
			CompanyExp company = new CompanyExp();
			company.setCompanyName("erer");
			company.setRegno("ew");
			company.setContactNo("44644");
			

			// save call
			entityManager.persist(company);
			
			transaction.commit();
			entityManager.close();
			
			System.out.println("Company details successfull....");

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			if (transaction.isActive()) {
				transaction.commit();
			}
			if (entityManager != null) {
				entityManager.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}
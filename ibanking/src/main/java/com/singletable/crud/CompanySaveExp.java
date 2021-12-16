package com.singletable.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cs.entity.CompanyExp;

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
			company.setCompanyName("citibank");
			company.setRegno("c12345678");
			company.setContactNo("3432111234");

			// save call
			entityManager.persist(company);
			
			transaction.commit();
			entityManager.close();
			


			System.out.println("Company details successfull....");

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			if (transaction != null) {
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
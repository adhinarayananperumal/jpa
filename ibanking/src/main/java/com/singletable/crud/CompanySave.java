package com.singletable.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cs.entity.Company;

public class CompanySave {
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
			Company company = new Company();
			company.setCompanyName("citi bank");
			company.setRegno("ci1234");
			company.setContactNo("9999999999999");

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
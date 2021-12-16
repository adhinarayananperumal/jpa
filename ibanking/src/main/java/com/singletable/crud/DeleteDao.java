package com.singletable.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cs.entity.CompanyExp;

public class DeleteDao {
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

			// get call
			CompanyExp company = entityManager.getReference(CompanyExp.class, 5);
			//company.getCompanyName();
			entityManager.remove(company);
			transaction.commit();

			System.out.println("Delete company   successfull....");

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
package com.singletable.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cs.entity.Company;
import com.cs.entity.Invoice;

public class ManytoOneSaveInvoiceWithParentBiDirectional {
	
	
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
			Company company = entityManager.getReference(Company.class, 1);
			

			Invoice invoice = new Invoice();
			invoice.setAmount(98000);
			invoice.setCompany(company);


			// save call
			entityManager.persist(invoice);
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

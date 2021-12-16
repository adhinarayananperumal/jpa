package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class RetrivalDao {
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
			CompanyExp company = entityManager.find(CompanyExp.class, 6);
			System.out.println(company.getCid());
			System.out.println(company.getCompanyName());
			System.out.println(company.getRegno());
			System.out.println(company.getContactNo());
			/*
			 * List<Invoice> ilist = company.getListInvoice();
			 * 
			 * for( Invoice i:ilist) { System.out.println("invoice no :" +
			 * i.getInvoiceNo()); System.out.println("Amount...." + i.getAmount()); }
			 */			
			System.out.println("Company details retrival  successfull....");

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
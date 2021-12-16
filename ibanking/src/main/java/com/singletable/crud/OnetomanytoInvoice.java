package com.singletable.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cs.entity.Company;
import com.cs.entity.Invoice;

public class OnetomanytoInvoice {

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
			company.setCompanyName("incedo1");
			company.setRegno("1111");
			company.setContactNo("+1-408-575-1317");

			Invoice invoice1 = new Invoice();
			invoice1.setAmount(2000);
			invoice1.setCompany(company);

			Invoice invoice2 = new Invoice();
			invoice2.setAmount(5000);
			invoice2.setCompany(company);


			List<Invoice> list = new ArrayList();
			list.add(invoice1);
			list.add(invoice2);


			company.setListInvoice(list);
			// company.getListInvoice().add(invoice2);

			// save call
			entityManager.persist(company);
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

package com.onetomanyexp;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entity.Country;

public class RetriveCompanyAndRelatedInvoicesRecord {

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
			Company company = entityManager.find(Company.class, 10);

			System.out.println(company.getContactNo());
			System.out.println(company.getCompanyName());

			List<Invoice> invoiceList = company.getListInvoice();

			for (Invoice inv : invoiceList) {
				System.out.println("\n" + inv.getAmount());
				System.out.println(inv.getInvoiceNo());
			}

			Country country = company.getCountry();
			Optional<Country> cnt = Optional.ofNullable(country);

			cnt.ifPresent(v -> System.out.println("\n Country Name : " + v.getCountryName()));

			System.out.println("Company details retrived....");

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

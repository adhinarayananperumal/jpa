package com.singletable.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cs.entity.CompanyExp;

public class ListAllRowDaoByCompanySomeLetter {
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

			//JPAQL
			Query q = entityManager.createQuery(" from CompanyExp where companyName Like '%Pvt%'");
			//SELECT * FROM movie WHERE title LIKE '%in%';

			List<CompanyExp> companyList = q.getResultList();
			
			System.out.println("num of sudents:" + companyList.size());
			for (CompanyExp company : companyList) {
				System.out.println(company.getCid());
				System.out.println(company.getCompanyName());
				System.out.println(company.getRegno());
				System.out.println(company.getContactNo());
			}

			System.out.println("Company details retrival  successfull....");

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
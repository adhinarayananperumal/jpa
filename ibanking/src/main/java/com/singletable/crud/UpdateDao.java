package com.singletable.crud;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cs.entity.CompanyExp;

public class UpdateDao {
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
		
			
			transaction.begin();
			
			// get call
			CompanyExp company2 = entityManager.find(CompanyExp.class, 50);
			//company.setRegno("00987654");
			company2.setCompanyName("eeee India Pvt Ltd");
			//company.setContactNo("11111");
			
			transaction.commit();


			System.out.println("Company details updated  successfull....");

		} catch (Exception e) {
			System.out.println(e);
			if(transaction!=null && transaction.isActive() ) {
			transaction.rollback();
			}
		} finally {
			if(transaction!=null && transaction.isActive() ) {
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
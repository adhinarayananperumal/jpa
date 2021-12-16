package com.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//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
public class DepartmentToPersonClient {

	EntityManagerFactory emf = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	EntityManager getEntityManager() {
		try {
			emf = Persistence.createEntityManagerFactory("corebanking");
			entityManager = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityManager;
	}

	void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
		}

	}

	void addNewManagerAlsoAssignDepartment(String managerName , long depNo) {
		try {
			entityManager = getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Department department = entityManager.getReference(Department.class, depNo);

			DepartmentManager departmentManager = new DepartmentManager();
			departmentManager.setName(managerName);
			departmentManager.setDepartment(department);

			entityManager.persist(departmentManager);

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (transaction != null && transaction.isActive()) {
				transaction.commit();
			}
			if (entityManager != null) {
				entityManager.close();
			}

			closeEntityManagerFactory();

		}
	}

	void addDepartment() {
		try {
			entityManager = getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Department d = new Department();
			d.setName("BSC");
			entityManager.persist(d);

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (transaction != null && transaction.isActive()) {
				transaction.commit();
			}
			if (entityManager != null) {
				entityManager.close();
			}

			closeEntityManagerFactory();

		}

	}
	
	void changeDepartmentManager(long departmentManagerId,long depno) {
		try {
			entityManager = getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			Department department = entityManager.getReference(Department.class, depno);

			DepartmentManager departmentManager = entityManager.getReference(DepartmentManager.class, departmentManagerId);
			departmentManager.setDepartment(department);


		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (transaction != null && transaction.isActive()) {
				transaction.commit();
			}
			if (entityManager != null) {
				entityManager.close();
			}

			closeEntityManagerFactory();

		}

	}


	public static void main(String[] args) {
		try {
			
			DepartmentToPersonClient departmentToPersonClient = new DepartmentToPersonClient();
			//departmentToPersonClient.addNewManagerAlsoAssignDepartment("ravi",3);
			//departmentToPersonClient.addDepartment();
			departmentToPersonClient.changeDepartmentManager(1,5);


		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

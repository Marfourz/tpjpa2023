package jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();

		tx.begin();
		try {

			// TODO create and persist entity
			//test.createEmployees();

			//manager.persist(employee);
			//manager.persist(department);



		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}


	public void createUsers() {

	}




	// public void createEmployees() {
	// 	int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
	// 	if (numOfEmployees == 0) {
	// 		Department department = new Department("java");
	// 		manager.persist(department);

	// 		manager.persist(new Employee("Jakab Gipsz",department));
	// 		manager.persist(new Employee("Captain Nemo",department));

	// 	}
	// }

	// public void listEmployees() {
	// 	List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
	// 	System.out.println("num of employess:" + resultList.size());
	// 	for (Employee next : resultList) {
	// 		System.out.println("next employee: " + next);
	// 	}
	// }





}

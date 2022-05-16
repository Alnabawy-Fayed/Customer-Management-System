package com.spring.project.CustomerManagemtSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.CustomerManagemtSystem.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
 private EntityManager entityManager;
 
 @Autowired
	public CustomerDaoImpl(EntityManager thEntityManager) {
		this.entityManager = thEntityManager;
	}

	@Override
	public List<Customer> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer findCustomer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Customer theCustomer = session.get(Customer.class, id);
		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
		
	}
	
	@Override
	public Customer deleteCustomer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Customer theCustomer = session.get(Customer.class, id);
		Query theQuery = session.createQuery("delete from Customer where id =:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
		return theCustomer;
	}

}

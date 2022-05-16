package com.spring.project.CustomerManagemtSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.CustomerManagemtSystem.entity.Customer;

@Repository
public class CustomerDaoJpaImpl implements CustomerDao {
	private EntityManager entityManager;

	@Autowired
	public CustomerDaoJpaImpl(EntityManager thEntityManager) {
		// TODO Auto-generated constructor stub
		this.entityManager = thEntityManager;
	}

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> myQuery = entityManager.createQuery("form customer",Customer.class);
		List<Customer> customers  = myQuery.getResultList();
		return customers;
	}

	@Override
	public Customer findCustomer(int id) {
		Customer customer = entityManager.find(Customer.class,id);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Customer theCustomer = entityManager.merge(customer);
		customer.setId(theCustomer.getId());

	}

	@Override
	public Customer deleteCustomer(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		Query  query= entityManager.createQuery("delete form Customer where id =: id");
		query.setParameter("id", id);
		query.executeUpdate();
		return customer;
	}

}

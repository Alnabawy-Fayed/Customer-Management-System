package com.spring.project.CustomerManagemtSystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.CustomerManagemtSystem.dao.CustomerDaoImpl;
import com.spring.project.CustomerManagemtSystem.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDaoImpl customerDaoImpl;
	
	@Autowired
	public CustomerServiceImpl(CustomerDaoImpl theCustomerDaoImpl) {
		this.customerDaoImpl = theCustomerDaoImpl;
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		
		return customerDaoImpl.findAll();
	}

	@Override
	@Transactional
	public Customer findCustomer(int id) {
		
		return customerDaoImpl.findCustomer(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDaoImpl.saveCustomer(customer);

	}

	@Override
	@Transactional
	public Customer deleteCustomer(int id) {
		
		return customerDaoImpl.deleteCustomer(id);
	}

}

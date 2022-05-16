package com.spring.project.CustomerManagemtSystem.service;

import java.util.List;

import com.spring.project.CustomerManagemtSystem.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();
	public Customer findCustomer(int id);
	public void saveCustomer(Customer customer);
	public Customer deleteCustomer(int id);

}

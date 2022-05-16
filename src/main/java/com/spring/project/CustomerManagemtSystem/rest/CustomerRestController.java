package com.spring.project.CustomerManagemtSystem.rest;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.CustomerManagemtSystem.dao.CustomerDaoImpl;
import com.spring.project.CustomerManagemtSystem.entity.Customer;
import com.spring.project.CustomerManagemtSystem.service.CustomerService;
import com.spring.project.CustomerManagemtSystem.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	public CustomerRestController(CustomerServiceImpl theCustomerServiceImpl) {
		this.customerServiceImpl = theCustomerServiceImpl;
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		 return customerServiceImpl.findAll();
	}
	
	@GetMapping("/customer/{theId}")
	public Customer getCustomer(@PathVariable int theId) {
		Customer customer = customerServiceImpl.findCustomer(theId);
		if(customer == null) {
			throw new RuntimeException("this customer doenst exist " + theId);
		}
		return customer;
	}
	
	@PostMapping("/customer")
	public void addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerServiceImpl.saveCustomer(theCustomer);
	}
	
	@PutMapping("/customer")
	public void updateCustomer(@RequestBody Customer myCustomer) {
		customerServiceImpl.saveCustomer(myCustomer);
	}
	
	@DeleteMapping("/customer/{theId}")
	public void deleteCustomer(@PathVariable int theId) {
		Customer customer = customerServiceImpl.findCustomer(theId);
		if(customer == null) {
			throw new RuntimeException("this customer doenst exist " + theId);
		}
		customerServiceImpl.deleteCustomer(theId);
	}
	
	

}

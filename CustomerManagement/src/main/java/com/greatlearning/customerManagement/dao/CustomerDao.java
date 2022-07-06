package com.greatlearning.customerManagement.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.greatlearning.customerManagement.model.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveCustomer(Customer customer) {
		hibernateTemplate.saveOrUpdate(customer);
	}
	
	public Customer getCustomerById(Integer customerId) {
		return hibernateTemplate.get(Customer.class, customerId);
	}
	
	public List<Customer> getAllCustomers() {
		return hibernateTemplate.loadAll(Customer.class);
	}
	
	@Transactional
	public void deleteCustomer(Customer customer) {
		hibernateTemplate.delete(customer);
		
	}

}

package com.greatlearning.customerManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.customerManagement.dao.CustomerDao;
import com.greatlearning.customerManagement.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> findAll() {
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer findById(int theId) {
		return customerDao.getCustomerById(theId);
	}

	@Override
	public void save(Customer thecustomer) {
		customerDao.saveCustomer(thecustomer);
	}

	@Override
	public void deleteById(int theId) {
		Customer customerById = customerDao.getCustomerById(theId);
		customerDao.deleteCustomer(customerById);
	}

}

package com.greatlearning.customerManagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerManagement.model.Customer;
import com.greatlearning.customerManagement.service.CustomerService;


@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String getAllCustomers(Model theModel) {

		List<Customer> theCustomers = customerService.findAll();
		theModel.addAttribute("customerModel", theCustomers);

		return "customerlist";
	}

	@RequestMapping("/add")
	public String addCustomer(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customersave";
	}

	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("id") int id, Model theModel) {

		Customer theCustomer = customerService.findById(id);
		theModel.addAttribute("customer", theCustomer);
		return "customersave";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) {
		System.out.println(id);
		customerService.deleteById(id);
		return "redirect:/customers/list";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Customer customer) {
		customerService.save(customer);
		return "redirect:/customers/list";
	}

}

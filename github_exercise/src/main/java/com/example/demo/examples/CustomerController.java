package com.example.demo.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.training.Customer;

public class CustomerController {
	@Autowired
	private Customer customer;
	
	@Autowired
	private CustomerRepository repo;
	
	@RequestMapping(value="/customers",method=RequestMethod.GET)
	public String initForm(Model model) {
		
		model.addAttribute("command", customer);
		return "addCustomer";
	}

}

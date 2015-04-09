package com.lucianomolinari.arquillian_example.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.lucianomolinari.arquillian_example.dao.CustomerDao;
import com.lucianomolinari.arquillian_example.entity.Customer;
import com.lucianomolinari.arquillian_example.services.CustomerServices;

@Stateless
public class CustomerServicesImpl implements CustomerServices {

	@Inject
	private CustomerDao customerDao;

	public Customer add(Customer customer) {
		return customerDao.add(customer);
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

}
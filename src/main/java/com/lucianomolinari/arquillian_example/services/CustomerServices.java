package com.lucianomolinari.arquillian_example.services;

import java.util.List;

import javax.ejb.Local;

import com.lucianomolinari.arquillian_example.entity.Customer;

@Local
public interface CustomerServices {

	Customer add(Customer customer);

	List<Customer> findAll();

}
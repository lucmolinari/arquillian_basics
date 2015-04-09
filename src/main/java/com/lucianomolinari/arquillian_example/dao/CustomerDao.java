package com.lucianomolinari.arquillian_example.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lucianomolinari.arquillian_example.entity.Customer;

@Stateless
public class CustomerDao {

	@PersistenceContext
	private EntityManager em;

	public Customer add(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		return em.createQuery("from Customer c order by c.id").getResultList();
	}

}
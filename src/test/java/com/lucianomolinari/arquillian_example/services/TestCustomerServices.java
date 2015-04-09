package com.lucianomolinari.arquillian_example.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.lucianomolinari.arquillian_example.entity.Customer;

@RunWith(Arquillian.class)
public class TestCustomerServices {

	@Inject
	private CustomerServices customerServices;

	@Deployment
	public static JavaArchive createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "testCustomer.jar")
				.addPackages(true, "com.lucianomolinari.arquillian_example")
				.addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
				.addAsManifestResource("test-persistence.xml", "persistence.xml");
	}

	@Test
	public void testAddAndFindCustomers() {
		List<Customer> customers = customerServices.findAll();

		assertNotNull(customers);
		assertEquals(0, customers.size());

		customerServices.add(new Customer("Customer 1"));
		customerServices.add(new Customer("Customer 2"));

		customers = customerServices.findAll();
		assertNotNull(customers);
		assertEquals(2, customers.size());
		assertEquals("Customer 1", customers.get(0).getName());
		assertEquals("Customer 2", customers.get(1).getName());
	}

}
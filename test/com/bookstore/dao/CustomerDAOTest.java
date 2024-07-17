package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Customer;

class CustomerDAOTest {
	private static CustomerDAO customerDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customerDao = new CustomerDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		customerDao.close();
	}

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("customer11@gmail.com");
		customer.setFirstname("Raj");
		customer.setLastname("Kapoor");
		customer.setCity("Mumbai");
		customer.setState("Uttar Pradesh");
		customer.setCountry("India");
		customer.setAddressLine1("10, Rajashri Nagar");
		customer.setAddressLine2("Near bank");
		customer.setZipcode("300504");
		customer.setPhone("8877556644");
		customer.setPassword("customer11");
		
		Customer savedCustomer = customerDao.create(customer);
		
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	void testGet() {
		Integer customerId = 1;
		Customer customer = customerDao.get(customerId);
		
		assertNotNull(customer);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDao.get(6);
		String lastname = "Surya";
		customer.setLastname(lastname);
		
		Customer updatedCustomer = customerDao.update(customer);
		
		assertTrue(updatedCustomer.getLastname().equals(lastname));
	}
	
	@Test
	void testDeleteCustomer() {
		Integer customerId = 12;
		customerDao.delete(customerId);
		
		Customer customer = customerDao.get(customerId);

		assertNull(customer);
	}
	
	@Test
	public void testListAll() {
		List<Customer> listCustomers = customerDao.listAll();
		for(Customer customer : listCustomers) {
			System.out.println(customer.getFirstname());
		}
		
		assertFalse(listCustomers.isEmpty());
	}

	@Test
	public void testCount() {
		long totalCustomers = customerDao.count();
		
		assertEquals(2, totalCustomers);
	}
	
	@Test
	public void testFindByEmail() {
		String email ="akaSurya@gmail.com";
		Customer customer = customerDao.findByEmail(email);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "akasurya@gmail.com";
		String password = "secret";
		
		Customer customer = customerDao.checkLogin(email, password);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLoginFail() {
		String email = "aka@gmail.com";
		String password = "secret";
		
		Customer customer = customerDao.checkLogin(email, password);
		
		assertNull(customer);
	}
}

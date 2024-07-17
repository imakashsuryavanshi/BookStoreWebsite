package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUpClass() throws Exception {
		userDAO = new UserDAO();
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("root@gmail.com");
		user1.setFullName("Joe root");
		user1.setPassword("England");

		user1 = userDAO.create(user1);

		assertTrue(user1.getUserId() > 0);
	}

	@Test(expected = Exception.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();

		user1 = userDAO.create(user1);

	}

	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(9);
		user.setEmail("abd@gmail.com");
		user.setFullName("AB Devillers");
		user.setPassword("Mr.36");

		userDAO.update(user);

		String expected = "Mr.36";
		String actual = user.getPassword();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if (user != null) {
			System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer  userId= 99;
		Users user = userDAO.get(userId);
		assertNull(user);
	}

	@Test
	public void testDeleteUser() {
		Integer userId = 8;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test(expected = Exception.class)
	public void testDeleteNonExistUsers() {
		Integer userId = 8;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		for (Users user : listUsers) {
			System.out.println(user.getFullName());
		}
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		Long totalUsers = userDAO.count();
		assertTrue(totalUsers > 0);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email= "akash@gmail.com";
		String password = "akash";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
	}
	
	@Test
	public void testCheckLoginFailed() {
		String email= "ash@gmail.com";
		String password = "akash1";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "virat@rcb.com";
		Users user = userDAO.findByEmail(email);
		
		assertNotNull(user);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userDAO.close();
	}
}

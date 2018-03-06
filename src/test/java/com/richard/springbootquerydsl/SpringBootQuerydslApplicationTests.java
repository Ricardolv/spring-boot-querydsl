package com.richard.springbootquerydsl;

import com.richard.springbootquerydsl.model.Admin;
import com.richard.springbootquerydsl.model.User;
import com.richard.springbootquerydsl.service.AdminService;
import com.richard.springbootquerydsl.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class SpringBootQuerydslApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private AdminService adminService;

	@Before
	public void init() {

		Admin adminSteveJobs = new Admin();
		adminSteveJobs.setUsername("steve_jobs");
		adminSteveJobs.setEmail("sjobs@apple.com");
		adminService.save(adminSteveJobs);

		Admin adminJeffBezos = new Admin();
		adminJeffBezos.setUsername("jeff_bezos");
		adminJeffBezos.setEmail("jbezos@amazon.com");
		adminService.save(adminJeffBezos);

		User userSteveJobs = new User();
		userSteveJobs.setUsername("steve_jobs");
		userSteveJobs.setEmail("sjobs@apple.com");
		userService.save(userSteveJobs);

		User userJeffBezos = new User();
		userJeffBezos.setUsername("jeff_bezos");
		userJeffBezos.setEmail("jbezos@amazon.com");
		userService.save(userJeffBezos);


	}

	@Test
	public void findAdminByUsernameAndEmail_JPA() {
		Admin admin = adminService.findAdminByUsernameAndEmail("steve_jobs", "sjobs@apple.com");
		Assert.assertNotNull(admin);
	}

	@Test
	public void findAll_JPA() {
		List<Admin> admins = adminService.findAll();
		assertEquals(2, admins.size());
	}

	@Test
	public void findUserByUsernameAndEmail_QueryDsl() {
		List<User> users = userService.findUsersByUsernameAndEmail("jeff_bezos", "jbezos@amazon.com");
		Assert.assertNotNull(users.get(0));
	}

	@Test
	public void findUserByEmail_QueryDsl() {
		User user = userService.findByEmail("jbezos@amazon.com");
		Assert.assertNotNull(user);
	}

}
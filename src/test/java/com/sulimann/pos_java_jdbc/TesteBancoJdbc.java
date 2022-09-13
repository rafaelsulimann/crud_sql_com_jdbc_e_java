package com.sulimann.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import com.sulimann.dao.UserDAO;
import com.sulimann.model.BeanUserPhone;
import com.sulimann.model.PhoneModel;
import com.sulimann.model.UserModel;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserDAO dao = new UserDAO();
		UserModel model = new UserModel(null, "Henrique Sulimann", "henrique.sulimann@gmail.com");
		dao.save(model);
	}
	
	@Test
	public void initFindAll() {
		UserDAO dao = new UserDAO();
		try {
			List<UserModel> list = dao.findAll();
			for(UserModel x : list) {
				System.out.println(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initFindById() {
		UserDAO dao = new UserDAO();
		try {
			UserModel obj = dao.findById(1L);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initUpdate() {
		UserDAO dao = new UserDAO();
		try {
			UserModel obj = dao.findById(1L);
			obj.setNome("Luana");
			obj.setEmail("luanaeloi99@gmail.com");
			dao.update(obj);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initDelete() {
		UserDAO dao = new UserDAO();
		try {
			dao.delete(3L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initInsertPhone() {
		UserDAO dao = new UserDAO();
		try {
			PhoneModel phone = new PhoneModel(null, "51981658626", "celular", 2L);
			dao.insertPhone(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initFindUserPhone() {
		UserDAO dao = new UserDAO();
		try {
			List<BeanUserPhone> list = dao.findUserPhone(1L);
			for(BeanUserPhone x : list) {
				System.out.println(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeleteUserPhone() {
		UserDAO dao = new UserDAO();
		try {
			dao.deleteUserPhone(1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

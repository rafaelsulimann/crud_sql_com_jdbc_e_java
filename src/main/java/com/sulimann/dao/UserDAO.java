package com.sulimann.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sulimann.conexaoJdbc.SingleConnection;
import com.sulimann.model.BeanUserPhone;
import com.sulimann.model.PhoneModel;
import com.sulimann.model.UserModel;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void save(UserModel userModel) {
		try {
			String sql = "insert into tb_users (nome, email) values (?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userModel.getNome());
			insert.setString(2, userModel.getEmail());
			insert.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<UserModel> findAll() throws Exception{
		List<UserModel> list = new ArrayList<>();
		String sql = "select * from tb_users";
		PreparedStatement findAll = connection.prepareStatement(sql);
		ResultSet result = findAll.executeQuery();
		while(result.next()) {
			UserModel obj = new UserModel();
			obj.setId(result.getLong("id"));
			obj.setNome(result.getString("nome"));
			obj.setEmail(result.getString("email"));
			list.add(obj);
		}
		return list;
	}
	
	public UserModel findById(Long id) throws Exception {
		UserModel obj = new UserModel();
		String sql = "select * from tb_users where id = " + id;
		PreparedStatement findById = connection.prepareStatement(sql);
		ResultSet result = findById.executeQuery();
		
		while(result.next()) {			
			obj.setId(result.getLong("id"));
			obj.setNome(result.getString("nome"));
			obj.setEmail(result.getString("email"));			
		}
		return obj;
	}
	
	public void update(UserModel userModel) {
		try {
			String sql = "update tb_users set nome = ?, email = ? where id = " + userModel.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userModel.getNome());
			statement.setString(2, userModel.getEmail());
			statement.execute();
			connection.commit();			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void delete(Long id) {
		try {
			String sql = "delete from tb_users where id = " + id;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void insertPhone(PhoneModel phoneModel) {
		try {
			String sql = "insert into tb_phones(phone, tipo, user_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, phoneModel.getPhone());
			statement.setString(2, phoneModel.getType());
			statement.setLong(3, phoneModel.getUserId());
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<BeanUserPhone> findUserPhone(Long userId) {
		List<BeanUserPhone> list = new ArrayList<>();
		String sql = "select user_id, nome, email, phone from tb_phones as phones\r\n"
				+ "inner join tb_users as users\r\n"
				+ "on phones.user_id = users.id\r\n"
				+ "where users.id = " + userId;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				BeanUserPhone obj = new BeanUserPhone();
				obj.setUserId(resultSet.getLong("user_id"));
				obj.setNome(resultSet.getString("nome"));
				obj.setPhone(resultSet.getString("phone"));
				obj.setEmail(resultSet.getString("email"));
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteUserPhone(Long userId) {
		try {
			String sqlPhone = "delete from tb_phones where user_id = " + userId;
			String sqlUser = "delete from tb_users where id = " + userId;
			PreparedStatement statement  = connection.prepareStatement(sqlPhone);
			statement.executeUpdate();
			connection.commit();
			
			statement = connection.prepareStatement(sqlUser);
			statement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}

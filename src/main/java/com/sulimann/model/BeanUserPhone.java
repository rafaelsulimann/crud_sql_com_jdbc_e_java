package com.sulimann.model;

public class BeanUserPhone {
	
	private Long userId;
	private String nome;
	private String phone;
	private String email;
	
	public BeanUserPhone() {
	}

	public BeanUserPhone(Long userId, String nome, String phone, String email) {
		super();
		this.userId = userId;
		this.nome = nome;
		this.phone = phone;
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BeanUserPhone [userId=" + userId + ", nome=" + nome + ", phone=" + phone + ", email=" + email + "]";
	}	

}

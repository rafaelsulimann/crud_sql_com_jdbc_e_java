package com.sulimann.model;

public class PhoneModel {
	
	private Long id;
	private String phone;
	private String tipo;	
	private Long userId;
	
	public PhoneModel() {
	}
	
	public PhoneModel(Long id, String phone, String tipo, Long userId) {
		super();
		this.id = id;
		this.phone = phone;
		this.tipo = tipo;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return tipo;
	}

	public void setType(String tipo) {
		this.tipo = tipo;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}

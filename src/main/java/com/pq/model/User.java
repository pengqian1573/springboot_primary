package com.pq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User  extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2149719753991379229L;
	
	//账号
	@Column(name= "name",nullable = false)
	private String name;
	//密码
	@Column(name= "password")
	private String password;	
	//idCard
	@Column(name= "id_card")
	private String idCard;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public User(String name, String password, String idCard) {
		super();
		this.name = name;
		this.password = password;
		this.idCard = idCard;
	}
	
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", idCard=" + idCard + "]";
	}
	
}

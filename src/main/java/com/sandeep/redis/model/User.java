package com.sandeep.redis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Table")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5162007226158031749L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private long id;	
	
	@Column(name="userName")
	private String name;
	
	@Column(name="userFollowers")
	private Long followers;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getFollowers() {
		return followers;
	}
	public void setFollowers(Long followers) {
		this.followers = followers;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", followers=" + followers + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, Long followers) {
		super();
		this.name = name;
		this.followers = followers;
	}
	
	
	

}

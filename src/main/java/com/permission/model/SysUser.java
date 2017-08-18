package com.permission.model;


public class SysUser {
	
	/*
	* 
	*/
	private Integer id;
	/*
	* 
	*/
	private String username;
	/*
	* 
	*/
	private String password;
	
	
	/*
	* 
	*/
	public void setId(Integer id){
		this.id = id ;
	}
	/*
	* 
	*/
	public Integer getId(){
		return this.id ; 
	}
	
	/*
	* 
	*/
	public void setUsername(String username){
		this.username = username ;
	}
	/*
	* 
	*/
	public String getUsername(){
		return this.username ; 
	}
	
	/*
	* 
	*/
	public void setPassword(String password){
		this.password = password ;
	}
	/*
	* 
	*/
	public String getPassword(){
		return this.password ; 
	}
}
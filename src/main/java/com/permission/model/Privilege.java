package com.permission.model; 


public class Privilege {
	
	/*
	* 
	*/
	private Integer id;
	/*
	* 
	*/
	private String name;
	/*
	* 
	*/
	private String url;
	
	
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
	public void setName(String name){
		this.name = name ;
	}
	/*
	* 
	*/
	public String getName(){
		return this.name ; 
	}
	
	/*
	* 
	*/
	public void setUrl(String url){
		this.url = url ;
	}
	/*
	* 
	*/
	public String getUrl(){
		return this.url ; 
	}
}
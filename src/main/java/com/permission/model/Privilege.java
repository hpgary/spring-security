package com.permission.model; 


public class Privilege {
	
	/*
	* 节点ID
	*/
	private Integer id;
	/*
	* 父节点
	*/
	private Integer pid;
	/*
	* 功能名
	*/
	private String name;
	/*
	* 访问URL
	*/
	private String url;
	/*
	* 是否启用
	*/
	private Integer isEnable;
	
	
	/*
	* 节点ID
	*/
	public void setId(Integer id){
		this.id = id ;
	}
	/*
	* 节点ID
	*/
	public Integer getId(){
		return this.id ; 
	}
	
	/*
	* 父节点
	*/
	public void setPid(Integer pid){
		this.pid = pid ;
	}
	/*
	* 父节点
	*/
	public Integer getPid(){
		return this.pid ; 
	}
	
	/*
	* 功能名
	*/
	public void setName(String name){
		this.name = name ;
	}
	/*
	* 功能名
	*/
	public String getName(){
		return this.name ; 
	}
	
	/*
	* 访问URL
	*/
	public void setUrl(String url){
		this.url = url ;
	}
	/*
	* 访问URL
	*/
	public String getUrl(){
		return this.url ; 
	}
	
	/*
	* 是否启用
	*/
	public void setIsEnable(Integer isEnable){
		this.isEnable = isEnable ;
	}
	/*
	* 是否启用
	*/
	public Integer getIsEnable(){
		return this.isEnable ; 
	}
}
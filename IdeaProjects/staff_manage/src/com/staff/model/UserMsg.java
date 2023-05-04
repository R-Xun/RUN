package com.staff.model;
public class UserMsg {
	private Integer id;//ID
	private String loginName;//登录名
	private String password;//密码
	private Integer userType;//权限类型
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getLoginName(){
		return loginName;
	}
	public void setLoginName(String loginName){
		this.loginName = loginName == null ? null : loginName.trim();
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password == null ? null : password.trim();
	}
	public Integer getUserType(){
		return userType;
	}
	public void setUserType(Integer userType){
		this.userType = userType;
	}
}

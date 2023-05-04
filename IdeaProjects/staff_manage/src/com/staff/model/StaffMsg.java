package com.staff.model;
public class StaffMsg {
	private Integer id;//ID
	private String staffNo;//职工号
	private String realName;//姓名
	private String celphone;//联系电话
	private String email;//邮箱
	private Integer sex;//性别
	private Integer departId;//所属部门
	private Integer jobId;//职位
	private String createDate;//创建日期
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getStaffNo(){
		return staffNo;
	}
	public void setStaffNo(String staffNo){
		this.staffNo = staffNo == null ? null : staffNo.trim();
	}
	public String getRealName(){
		return realName;
	}
	public void setRealName(String realName){
		this.realName = realName == null ? null : realName.trim();
	}
	public String getCelphone(){
		return celphone;
	}
	public void setCelphone(String celphone){
		this.celphone = celphone == null ? null : celphone.trim();
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email == null ? null : email.trim();
	}
	public Integer getSex(){
		return sex;
	}
	public void setSex(Integer sex){
		this.sex = sex;
	}
	public Integer getDepartId(){
		return departId;
	}
	public void setDepartId(Integer departId){
		this.departId = departId;
	}
	public Integer getJobId(){
		return jobId;
	}
	public void setJobId(Integer jobId){
		this.jobId = jobId;
	}
	public String getCreateDate(){
		return createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate == null ? null : createDate.trim();
	}
}

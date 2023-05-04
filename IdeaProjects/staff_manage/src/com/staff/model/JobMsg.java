package com.staff.model;
public class JobMsg {
	private Integer id;//ID
	private String jobName;//职位名
	private Integer departId;//所属部门
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getJobName(){
		return jobName;
	}
	public void setJobName(String jobName){
		this.jobName = jobName == null ? null : jobName.trim();
	}
	public Integer getDepartId(){
		return departId;
	}
	public void setDepartId(Integer departId){
		this.departId = departId;
	}
}

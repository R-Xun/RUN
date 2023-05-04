package com.staff.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.staff.dao.*;
import com.staff.model.*;
import com.staff.service.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import com.staff.util.*;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.staff.service.*;
import com.staff.controller.LoginModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.io.IOException;
@Service
public class JobMsgServiceImpl implements JobMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	DepartMsgMapper departMsgMapper;
	@Autowired
	JobMsgMapper jobMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(JobMsg model,LoginModel login){
		if(model.getJobName()==null||model.getJobName().equals("")){
			return "职位名为必填属性";
		}
		if(model.getDepartId()==null){
			return "所属部门为必填属性";
		}
		jobMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(JobMsg model,LoginModel login){
		JobMsg preModel = jobMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getJobName()==null||model.getJobName().equals("")){
			return "职位名为必填属性";
		}
		if(model.getDepartId()==null){
			return "所属部门为必填属性";
		}
		preModel.setJobName(model.getJobName());
		preModel.setDepartId(model.getDepartId());
		jobMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询职位列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(JobMsg queryModel,Integer pageSize,LoginModel login) {
		JobMsgExample se = new JobMsgExample();
		JobMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getJobName()!=null&&queryModel.getJobName().equals("")==false){
			sc.andJobNameLike("%"+queryModel.getJobName()+"%");//模糊查询
		}
		if(queryModel.getDepartId()!=null){
			sc.andDepartIdEqualTo(queryModel.getDepartId());//查询所属部门等于指定值
		}
		int count = (int)jobMsgMapper.countByExample(se);
		int totalPage = 0;
		if ((count > 0) && ((count % pageSize) == 0)) {
			totalPage = count / pageSize;
		} else {
			totalPage = (count / pageSize) + 1;
		}
		Map<String,Integer> rs = new HashMap<String,Integer>();
		rs.put("count",count);//数据总数
		rs.put("totalPage",totalPage);//总页数
		return rs;
	}
	/**
	*根据参数查询职位列表数据
	*/
	@Override
	public Map<String,Object> getDataList(JobMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		JobMsgExample se = new JobMsgExample();
		JobMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getJobName()!=null&&queryModel.getJobName().equals("")==false){
			sc.andJobNameLike("%"+queryModel.getJobName()+"%");//模糊查询
		}
		if(queryModel.getDepartId()!=null){
			sc.andDepartIdEqualTo(queryModel.getDepartId());//查询所属部门等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<JobMsg> list = jobMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(JobMsg model:list){
			list2.add(getJobMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装职位为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getJobMsgModel(JobMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("jobMsg",model);
		if(model.getDepartId()!=null){
			DepartMsg departMsg = departMsgMapper.selectByPrimaryKey(model.getDepartId());//所属部门为外接字段，需要关联部门来解释该字段
			if(departMsg!=null){
				map.put("departIdStr",departMsg.getDname());
			}
		}
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		jobMsgMapper.deleteByPrimaryKey(id);
	}
}

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
public class UserMsgServiceImpl implements UserMsgService{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM");
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	新增
	*/
	@Override
	public String add(UserMsg model,LoginModel login){
		if(model.getLoginName()==null||model.getLoginName().equals("")){
			return "登录名为必填属性";
		}
		if(model.getLoginName()!=null){
			UserMsgExample te=new UserMsgExample();
			UserMsgExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(model.getLoginName());
			int count = (int)userMsgMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 登录名 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getUserType()==null){
			return "权限类型为必填属性";
		}
		userMsgMapper.insertSelective(model);//插入数据
		return "";
	}
	/**
	修改
	*/
	@Override
	public String update(UserMsg model,LoginModel login){
		UserMsg preModel = userMsgMapper.selectByPrimaryKey(model.getId());
		if(model.getLoginName()==null||model.getLoginName().equals("")){
			return "登录名为必填属性";
		}
		if(model.getLoginName()!=null){
			UserMsgExample te=new UserMsgExample();
			UserMsgExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(model.getLoginName());
			tc.andIdNotEqualTo(model.getId());
			int count = (int)userMsgMapper.countByExample(te);
			if(count>0){
				return "系统已存在该 登录名 ,请重新填写";
			}
		}
		if(model.getPassword()==null||model.getPassword().equals("")){
			return "密码为必填属性";
		}
		if(model.getUserType()==null){
			return "权限类型为必填属性";
		}
		preModel.setLoginName(model.getLoginName());
		preModel.setPassword(model.getPassword());
		preModel.setUserType(model.getUserType());
		userMsgMapper.updateByPrimaryKey(preModel);//更新数据
		return "";
	}
	/**
	*根据参数查询用户列表总数
	*/
	@Override
	public Map<String,Integer> getDataListCount(UserMsg queryModel,Integer pageSize,LoginModel login) {
		UserMsgExample se = new UserMsgExample();
		UserMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getUserType()!=null){
			sc.andUserTypeEqualTo(queryModel.getUserType());//查询权限类型等于指定值
		}
		int count = (int)userMsgMapper.countByExample(se);
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
	*根据参数查询用户列表数据
	*/
	@Override
	public Map<String,Object> getDataList(UserMsg queryModel,Integer page,Integer pageSize,LoginModel login) {
		UserMsgExample se = new UserMsgExample();
		UserMsgExample.Criteria sc = se.createCriteria();
		se.setOrderByClause("id desc");//默认按照id倒序排序
		if(queryModel.getLoginName()!=null&&queryModel.getLoginName().equals("")==false){
			sc.andLoginNameLike("%"+queryModel.getLoginName()+"%");//模糊查询
		}
		if(queryModel.getUserType()!=null){
			sc.andUserTypeEqualTo(queryModel.getUserType());//查询权限类型等于指定值
		}
		if(page!=null&&pageSize!=null){
			se.setPageRows(pageSize);
			se.setStartRow((page-1)*pageSize);
		}
		List<UserMsg> list = userMsgMapper.selectByExample(se);//执行查询语句
		Map<String,Object> rs = new HashMap<String,Object>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		for(UserMsg model:list){
			list2.add(getUserMsgModel(model,login));
		}
		rs.put("list",list2);//数据列表
		return rs;
	}
	/**
	封装用户为前台展示的数据形式
	*/
	@Override
	public Map<String,Object> getUserMsgModel(UserMsg model,LoginModel login){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userMsg",model);
		map.put("userTypeStr",DataListUtils.getUserTypeNameById(model.getUserType()+""));//解释权限类型字段
		return map;
	}
	/**
	* 删除数据
	*/
	@Override
	public void delete(Integer id) {
		userMsgMapper.deleteByPrimaryKey(id);
	}
}

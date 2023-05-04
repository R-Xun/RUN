package com.staff.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.staff.controller.LoginModel;
import org.springframework.web.bind.annotation.ResponseBody;
import com.staff.util.CommonVal;
import  com.staff.model.*;
import com.staff.dao.*;
import com.staff.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.*;
@Controller
@RequestMapping("/regist")
public class RegistController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	UserMsgMapper userMsgMapper;
	/**
	进入注册页面接口
	*/
	@RequestMapping(value="user_msg_regist")
	public String user_msg_regist(ModelMap modelMap,String msg){
		modelMap.addAttribute("msg",msg);
		getUserList(modelMap);
		return "user_msg_regist";
	}
	/**
	提交注册信息接口
	*/
	@RequestMapping("userMsgRegistSubmit")
	@ResponseBody
	public Object userMsgRegistSubmit(String imgCode,String name,String password,Integer userType,ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> rs = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		if (imgCode!=null&&!imgCode.toLowerCase().equals(request.getSession().getAttribute(CommonVal.code).toString().toLowerCase())){//当前验证码存储session的值是否和输入的值一致
			rs.put("code",0);
			rs.put("msg", "图片验证码错误");
			return rs;
		}
		if(name==null||name.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入登录名");
			return rs;
		}
		if(name!=null){
			UserMsgExample te=new UserMsgExample();
			UserMsgExample.Criteria tc=te.createCriteria();
			tc.andLoginNameEqualTo(name);
			int count = (int)userMsgMapper.countByExample(te);
			if(count>0){
				rs.put("code",0);
				rs.put("msg",   "该账号已被注册，请用该账号登录");
				return rs;
			}
		}
		if(password==null||password.equals("")){
			rs.put("code",0);
			rs.put("msg",   "请填入密码");
			return rs;
		}
		if(userType==null){
			rs.put("code",0);
			rs.put("msg",   "请填入权限类型");
			return rs;
		}
		UserMsg model = new UserMsg();
		model.setLoginName(name);
		model.setPassword(password);
		model.setUserType(userType);
		userMsgMapper.insertSelective(model);//注册成功，插入该账号进数据库，并返回提示
		rs.put("code",1);
		rs.put("msg",  "注册成功，请使用该账号密码登录");
		return rs;
	}
	public void getUserList(ModelMap modelMap){
		modelMap.addAttribute("userTypeList",DataListUtils.getUserTypeList());//user_type列表
	}
}

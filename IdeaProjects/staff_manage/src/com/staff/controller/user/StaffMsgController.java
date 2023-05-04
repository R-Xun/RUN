package com.staff.controller.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import com.staff.dao.*;
import com.staff.model.*;
import com.staff.service.impl.*;
import com.staff.util.*;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import com.staff.controller.LoginModel;
import com.staff.service.*;
@Controller
@RequestMapping("/user/staff_msg")
public class StaffMsgController{
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	StaffMsgService staffMsgService;
	@Autowired
	UserMsgMapper userMsgMapper;
	@Autowired
	DepartMsgMapper departMsgMapper;
	@Autowired
	JobMsgMapper jobMsgMapper;
	@Autowired
	StaffMsgMapper staffMsgMapper;
	public void getList(ModelMap modelMap,LoginModel login){
		modelMap.addAttribute("sexList",DataListUtils.getSexList());//返回sex列表
		DepartMsgExample departMsgE = new DepartMsgExample();
		List<DepartMsg> departMsgList=departMsgMapper.selectByExample(departMsgE);
		List<Map<String,Object>>  departMsgList2 = new ArrayList<Map<String,Object>>();
		for(DepartMsg m:departMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getDname());
			departMsgList2.add(map);
		}
		modelMap.addAttribute("departMsgList",departMsgList2);
		JobMsgExample jobMsgE = new JobMsgExample();
		List<JobMsg> jobMsgList=jobMsgMapper.selectByExample(jobMsgE);
		List<Map<String,Object>>  jobMsgList2 = new ArrayList<Map<String,Object>>();
		for(JobMsg m:jobMsgList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",m.getId());
			map.put("name",m.getJobName());
			jobMsgList2.add(map);
		}
		modelMap.addAttribute("jobMsgList",jobMsgList2);
	}
	/**
	* 根据所属部门查询职位列表
	*/
	@RequestMapping(value="getJobMsgListByDepartId")
	@ResponseBody
	public Object getJobMsgListByDepartId(Integer departId){
		List<Map<String,Object>> rs = new ArrayList<Map<String,Object>>();
		if(departId==null){
			return rs;
		}
		JobMsgExample te = new JobMsgExample();
		JobMsgExample.Criteria tc = te.createCriteria();
		tc.andDepartIdEqualTo(departId);
		List<JobMsg> tl = jobMsgMapper.selectByExample(te);
		for(JobMsg t:tl){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",t.getId());
			map.put("name",t.getJobName());
			rs.add(map);
		}
		return rs;
	}
	/**
	* 根据查询条件分页查询员工数据总数
	*/
	@RequestMapping(value="queryCount")
	@ResponseBody
	public Object queryCount(StaffMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return staffMsgService.getDataListCount(model,CommonVal.pageSize,login);//分页查询数据总数
	}
	/**
	* 返回员工列表jsp页面
	*/
	@RequestMapping(value="")
	public String index(ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//获取当前登录账号信息
		UserMsg userMsg = userMsgMapper.selectByPrimaryKey(login.getId());
		modelMap.addAttribute("user",userMsg);
		getList( modelMap,login);//获取数据列表并返回给前台
		return "user/staff_msg/list";
	}
	/**
	* 根据查询条件分页查询员工数据，然后返回给前台渲染
	*/
	@RequestMapping(value="queryList")
	@ResponseBody
	public Object toList(StaffMsg model,Integer page,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		return staffMsgService.getDataList(model,page,CommonVal.pageSize,login);//分页查询数据
	}
	/**
	进入新增页面
	*/
	@RequestMapping("add")
	public String add(ModelMap modelMap,StaffMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		modelMap.addAttribute("data",model);
		return "user/staff_msg/add_page";
	}
	/**
	新增提交信息接口
	*/
	@RequestMapping("add_submit")
	@ResponseBody
	public Object add_submit(StaffMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = staffMsgService.add(model,login);//执行添加操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","新增成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	进入修改页面
	*/
	@RequestMapping("update")
	public String update(ModelMap modelMap,StaffMsg model,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);//从session中获取当前登录账号
		getList( modelMap,login);//获取前台需要用到的数据列表并返回给前台
		StaffMsg data = staffMsgMapper.selectByPrimaryKey(model.getId());
		modelMap.addAttribute("data",data);
		return "user/staff_msg/update_page";
	}
	/**
	修改提交信息接口
	*/
	@RequestMapping("update_submit")
	@ResponseBody
	public Object update_submit(StaffMsg model,ModelMap modelMap,HttpServletRequest request){
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		String msg = staffMsgService.update(model,login);//执行修改操作
		if(msg.equals("")){
			rs.put("code",1);
			rs.put("msg","修改成功");
			return rs;
		}
		rs.put("code",0);
		rs.put("msg",msg);
		return rs;
	}
	/**
	删除员工接口
	*/
	@RequestMapping("del")
	@ResponseBody
	public Object del(Integer id,ModelMap modelMap,HttpServletRequest request) {
		LoginModel login = (LoginModel) request.getSession().getAttribute(CommonVal.sessionName);
		Map<String,Object> rs = new HashMap<String,Object>();
		staffMsgService.delete(id);
		rs.put("code",1);
		rs.put("msg","删除成功");
		return rs;
	}
}

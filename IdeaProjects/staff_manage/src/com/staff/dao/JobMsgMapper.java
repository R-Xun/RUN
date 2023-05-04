package com.staff.dao;
import com.staff.model.JobMsg;
import com.staff.model.JobMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface JobMsgMapper {
	long countByExample(JobMsgExample example);
	int deleteByExample(JobMsgExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(JobMsg record);
	int insertSelective(JobMsg record);
	List<JobMsg> selectByExample(JobMsgExample example);
	JobMsg selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("record") JobMsg record, @Param("example") JobMsgExample example);
	int updateByExample(@Param("record") JobMsg record, @Param("example") JobMsgExample example);
	int updateByPrimaryKeySelective(JobMsg record);
	int updateByPrimaryKey(JobMsg record);
}

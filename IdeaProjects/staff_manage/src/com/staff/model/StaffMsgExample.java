package com.staff.model;
import java.util.ArrayList;
import java.util.List;
public class StaffMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public StaffMsgExample() {
		oredCriteria = new ArrayList<>();
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	public boolean isDistinct() {
		return distinct;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageRows() {
		return pageRows;
	}
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;
		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}
		public boolean isValid() {
			return criteria.size() > 0;
		}
		public List<Criterion> getAllCriteria() {
			return criteria;
		}
		public List<Criterion> getCriteria() {
			return criteria;
		}
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}
		public Criteria andIdIsNotNull(){
			addCriterion("id is not null");
			return (Criteria) this;
		}
		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "Id");
			return (Criteria) this;
		}
		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdLike(Integer value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotLike(Integer value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}
		public Criteria andStaffNoIsNull() {
			addCriterion("staff_no is null");
			return (Criteria) this;
		}
		public Criteria andStaffNoIsNotNull(){
			addCriterion("staff_no is not null");
			return (Criteria) this;
		}
		public Criteria andStaffNoEqualTo(String value) {
			addCriterion("staff_no =", value, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoNotEqualTo(String value) {
			addCriterion("staff_no <>", value, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoGreaterThan(String value) {
			addCriterion("staff_no >", value, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoGreaterThanOrEqualTo(String value) {
			addCriterion("staff_no >=", value, "StaffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoLessThan(String value) {
			addCriterion("staff_no <", value, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoLessThanOrEqualTo(String value) {
			addCriterion("staff_no <=", value, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoIn(List<String> values) {
			addCriterion("staff_no in", values, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoNotIn(List<String> values) {
			addCriterion("staff_no not in", values, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoBetween(String value1, String value2) {
			addCriterion("staff_no between", value1, value2, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoNotBetween(String value1, String value2) {
			addCriterion("staff_no not between", value1, value2, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoLike(String value) {
			addCriterion("staff_no like", value, "staffNo");
			return (Criteria) this;
		}
		public Criteria andStaffNoNotLike(String value) {
			addCriterion("staff_no not like", value, "staffNo");
			return (Criteria) this;
		}
		public Criteria andRealNameIsNull() {
			addCriterion("real_name is null");
			return (Criteria) this;
		}
		public Criteria andRealNameIsNotNull(){
			addCriterion("real_name is not null");
			return (Criteria) this;
		}
		public Criteria andRealNameEqualTo(String value) {
			addCriterion("real_name =", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotEqualTo(String value) {
			addCriterion("real_name <>", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameGreaterThan(String value) {
			addCriterion("real_name >", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameGreaterThanOrEqualTo(String value) {
			addCriterion("real_name >=", value, "RealName");
			return (Criteria) this;
		}
		public Criteria andRealNameLessThan(String value) {
			addCriterion("real_name <", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameLessThanOrEqualTo(String value) {
			addCriterion("real_name <=", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameIn(List<String> values) {
			addCriterion("real_name in", values, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotIn(List<String> values) {
			addCriterion("real_name not in", values, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameBetween(String value1, String value2) {
			addCriterion("real_name between", value1, value2, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotBetween(String value1, String value2) {
			addCriterion("real_name not between", value1, value2, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameLike(String value) {
			addCriterion("real_name like", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotLike(String value) {
			addCriterion("real_name not like", value, "realName");
			return (Criteria) this;
		}
		public Criteria andCelphoneIsNull() {
			addCriterion("celphone is null");
			return (Criteria) this;
		}
		public Criteria andCelphoneIsNotNull(){
			addCriterion("celphone is not null");
			return (Criteria) this;
		}
		public Criteria andCelphoneEqualTo(String value) {
			addCriterion("celphone =", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneNotEqualTo(String value) {
			addCriterion("celphone <>", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneGreaterThan(String value) {
			addCriterion("celphone >", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneGreaterThanOrEqualTo(String value) {
			addCriterion("celphone >=", value, "Celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneLessThan(String value) {
			addCriterion("celphone <", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneLessThanOrEqualTo(String value) {
			addCriterion("celphone <=", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneIn(List<String> values) {
			addCriterion("celphone in", values, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneNotIn(List<String> values) {
			addCriterion("celphone not in", values, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneBetween(String value1, String value2) {
			addCriterion("celphone between", value1, value2, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneNotBetween(String value1, String value2) {
			addCriterion("celphone not between", value1, value2, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneLike(String value) {
			addCriterion("celphone like", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneNotLike(String value) {
			addCriterion("celphone not like", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}
		public Criteria andEmailIsNotNull(){
			addCriterion("email is not null");
			return (Criteria) this;
		}
		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "Email");
			return (Criteria) this;
		}
		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}
		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}
		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}
		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}
		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}
		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}
		public Criteria andSexIsNotNull(){
			addCriterion("sex is not null");
			return (Criteria) this;
		}
		public Criteria andSexEqualTo(Integer value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexNotEqualTo(Integer value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexGreaterThan(Integer value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexGreaterThanOrEqualTo(Integer value) {
			addCriterion("sex >=", value, "Sex");
			return (Criteria) this;
		}
		public Criteria andSexLessThan(Integer value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexLessThanOrEqualTo(Integer value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexIn(List<Integer> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}
		public Criteria andSexNotIn(List<Integer> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}
		public Criteria andSexBetween(Integer value1, Integer value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}
		public Criteria andSexNotBetween(Integer value1, Integer value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}
		public Criteria andSexLike(Integer value) {
			addCriterion("sex like", value, "sex");
			return (Criteria) this;
		}
		public Criteria andSexNotLike(Integer value) {
			addCriterion("sex not like", value, "sex");
			return (Criteria) this;
		}
		public Criteria andDepartIdIsNull() {
			addCriterion("depart_id is null");
			return (Criteria) this;
		}
		public Criteria andDepartIdIsNotNull(){
			addCriterion("depart_id is not null");
			return (Criteria) this;
		}
		public Criteria andDepartIdEqualTo(Integer value) {
			addCriterion("depart_id =", value, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdNotEqualTo(Integer value) {
			addCriterion("depart_id <>", value, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdGreaterThan(Integer value) {
			addCriterion("depart_id >", value, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("depart_id >=", value, "DepartId");
			return (Criteria) this;
		}
		public Criteria andDepartIdLessThan(Integer value) {
			addCriterion("depart_id <", value, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdLessThanOrEqualTo(Integer value) {
			addCriterion("depart_id <=", value, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdIn(List<Integer> values) {
			addCriterion("depart_id in", values, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdNotIn(List<Integer> values) {
			addCriterion("depart_id not in", values, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdBetween(Integer value1, Integer value2) {
			addCriterion("depart_id between", value1, value2, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdNotBetween(Integer value1, Integer value2) {
			addCriterion("depart_id not between", value1, value2, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdLike(Integer value) {
			addCriterion("depart_id like", value, "departId");
			return (Criteria) this;
		}
		public Criteria andDepartIdNotLike(Integer value) {
			addCriterion("depart_id not like", value, "departId");
			return (Criteria) this;
		}
		public Criteria andJobIdIsNull() {
			addCriterion("job_id is null");
			return (Criteria) this;
		}
		public Criteria andJobIdIsNotNull(){
			addCriterion("job_id is not null");
			return (Criteria) this;
		}
		public Criteria andJobIdEqualTo(Integer value) {
			addCriterion("job_id =", value, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdNotEqualTo(Integer value) {
			addCriterion("job_id <>", value, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdGreaterThan(Integer value) {
			addCriterion("job_id >", value, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("job_id >=", value, "JobId");
			return (Criteria) this;
		}
		public Criteria andJobIdLessThan(Integer value) {
			addCriterion("job_id <", value, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdLessThanOrEqualTo(Integer value) {
			addCriterion("job_id <=", value, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdIn(List<Integer> values) {
			addCriterion("job_id in", values, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdNotIn(List<Integer> values) {
			addCriterion("job_id not in", values, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdBetween(Integer value1, Integer value2) {
			addCriterion("job_id between", value1, value2, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
			addCriterion("job_id not between", value1, value2, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdLike(Integer value) {
			addCriterion("job_id like", value, "jobId");
			return (Criteria) this;
		}
		public Criteria andJobIdNotLike(Integer value) {
			addCriterion("job_id not like", value, "jobId");
			return (Criteria) this;
		}
		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}
		public Criteria andCreateDateIsNotNull(){
			addCriterion("create_date is not null");
			return (Criteria) this;
		}
		public Criteria andCreateDateEqualTo(String value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotEqualTo(String value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateGreaterThan(String value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
			addCriterion("create_date >=", value, "CreateDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLessThan(String value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLessThanOrEqualTo(String value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateIn(List<String> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotIn(List<String> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateBetween(String value1, String value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotBetween(String value1, String value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLike(String value) {
			addCriterion("create_date like", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotLike(String value) {
			addCriterion("create_date not like", value, "createDate");
			return (Criteria) this;
		}
	}
	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;
		public String getCondition() {
			return condition;
		}
		public Object getValue() {
			return value;
		}
		public Object getSecondValue() {
			return secondValue;
		}
		public boolean isNoValue() {
			return noValue;
		}
		public boolean isSingleValue() {
			return singleValue;
		}
		public boolean isBetweenValue() {
			return betweenValue;
		}
		public boolean isListValue() {
			return listValue;
		}
		public String getTypeHandler() {
			return typeHandler;
		}
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}

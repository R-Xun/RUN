<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>新增-员工</title>
<meta name="keywords" content="新增-员工">
<meta name="description" content="新增-员工">

<link href="${pageContext.request.contextPath}/static/admin/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="${pageContext.request.contextPath}/static/admin/css/plugins/morris/morris-0.4.3.min.css?t=322" rel="stylesheet">

<!-- Gritter -->
<link href="${pageContext.request.contextPath}/static/admin/js/plugins/gritter/jquery.gritter.css?t=322" rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/admin/css/animate.css?t=322" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/css/style.css?v=2.2.0" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.css" />

<c:set var="uri" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
var uri='${uri}';
</script>
<style>
.bodyClass::-webkit-scrollbar {
display: none; /* Chrome Safari */
}
.bodyClass {
scrollbar-width: none; /* firefox */
-ms-overflow-style: none; /* IE 10+ */
overflow-x: hidden;
overflow-y: auto;
}

.dz-image>img{
width:120px;
height:120px;
}
</style>
</head>

<body class="bodyClass"  style="background-color:#f3f3f4">

<div class="modal inmodal"  id="bodyModal" tabindex="-1" role="dialog" aria-hidden="true" style="top:80px;left:-200px;">
	<div class="modal-dialog">
		<div class="modal-content animated bounceInRight">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
				</button>
				<h4 class="modal-title"  id="bodyModalTile"></h4>
			</div>
			<div class="modal-body"  id="bodyModalContent">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>新增-员工 </h2>
	</div>
	<div class="col-lg-2">
	</div>
</div>
<div class="gray-bg dashbard-1" style="height:758px">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<div class="ibox-tools">
					</div>
				</div>
				<div class="ibox-content">
					<div class="row"   style="width:80%;margin-left:10%">
						<div class="col-lg-6">
							<div class="form-group" id="staffNoParentContent">
								<label>职工号<span style="color:red">(*必填)</span></label>
								<input type="text" value="" placeholder="请输入职工号" id="staffNo" class="form-control">
							</div>
							<div class="form-group" id="realNameParentContent">
								<label>姓名<span style="color:red">(*必填)</span></label>
								<input type="text" value="" placeholder="请输入姓名" id="realName" class="form-control">
							</div>
							<div class="form-group" id="celphoneParentContent">
								<label>联系电话<span style="color:red">(*必填)</span></label>
								<input type="text" value="" placeholder="请输入联系电话" id="celphone" class="form-control">
							</div>
							<div class="form-group" id="emailParentContent">
								<label>邮箱<span style="color:red">(*必填)</span></label>
								<input type="text" value="" placeholder="请输入邮箱" id="email" class="form-control">
							</div>
							<div class="form-group" id="sexParentContent">
								<label>性别<span style="color:red">(*必填)</span></label>
								<select id="sex"  class="form-control">
									<c:forEach items="${sexList}" var="item">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group" id="departIdParentContent">
								<label>所属部门<span style="color:red">(*必填)</span></label>
								<select  id="departId"   >
									<c:forEach items="${departMsgList}" var="item">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group" id="jobIdParentContent">
								<label>职位<span style="color:red">(*必填)</span></label>
								<select  id="jobId"   >
									<c:forEach items="${jobMsgList}" var="item">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<button type="button" onclick="submitData();" class="btn btn-primary">提交</button>
								<button type="button"   onclick="javascript:history.back(-1);" class="btn btn-light">返回</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/static/admin/js/jquery-2.1.1.min.js?t=322"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/bootstrap.min.js?v=3.4.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=1586"></script>

<script>
$(function(){
	$('#departId').next().remove();
	$('#departId').searchableSelect();
	$(".searchable-select").css("width","100%");
	$(".searchable-select").css("height","35px");
	$(".searchable-select-holder").css("min-height","20px");
	$(".searchable-select-holder").css("height","35px");
	$(".searchable-select").css("min-width","40px");
	$("#departId").change(function(){
		changeDepartIdVal();
	});
	changeDepartIdVal();
	$('#jobId').next().remove();
	$('#jobId').searchableSelect();
	$(".searchable-select").css("width","100%");
	$(".searchable-select").css("height","35px");
	$(".searchable-select-holder").css("min-height","20px");
	$(".searchable-select-holder").css("height","35px");
	$(".searchable-select").css("min-width","40px");
})
function changeDepartIdVal(){
	var id = $("#departId").val();
	$.ajax({
		async:false,
		type: 'post',
		url: '${pageContext.request.contextPath}/user/staff_msg/getJobMsgListByDepartId',
		data:{
			"departId":id
		},
		success: function(result) {
			var html='<option value="" >全部</option>';
			for(var i=0;i<result.length;i++){
				html+='<option value='+result[i].id+' >'+result[i].name+'</option>';
			}
			$("#jobId").html(html);
			$("#jobId").next().remove();
			$("#jobId").searchableSelect();
			
			$(".searchable-select").css("width","100%");
			$(".searchable-select").css("height","35px");
			$(".searchable-select-holder").css("min-height","20px");
			$(".searchable-select-holder").css("height","35px");
			$(".searchable-select").css("min-width","40px");
		}
	});
}
function submitData(){
	var staffNo= $('#staffNo').val();
	var realName= $('#realName').val();
	var celphone= $('#celphone').val();
	var email= $('#email').val();
	var sex= $('#sex').val();
	var departId=$('#departId').val()
	var departId= $('#departId').val();
	var jobId=$('#jobId').val()
	var jobId= $('#jobId').val();
	$.ajax({
		type: 'post',
		url: '${pageContext.request.contextPath}/user/staff_msg/add_submit',
		data:{
			"staffNo":staffNo,
			"realName":realName,
			"celphone":celphone,
			"email":email,
			"sex":sex,
			"departId":departId,
			"jobId":jobId
		},
		success: function(result) {
			if(result.code == 0){
				alert(result.msg);
				}else{
				alert(result.msg);
				window.location.href="${pageContext.request.contextPath}/user/staff_msg";
			}
		}
	});
}

</script>

</body>

</html>


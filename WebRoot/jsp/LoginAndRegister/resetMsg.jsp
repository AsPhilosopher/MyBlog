<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/inc/constants.inc" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modify</title>
		
		<link rel="stylesheet" href="${CSS_PATH}syntaxhighlighter/shCore.css">
		<link rel="stylesheet" href="${CSS_PATH}syntaxhighlighter/shThemeDefault.css">
		<link rel="stylesheet" href="${CSS_PATH}rendezvous.css">
		<link rel="stylesheet" type="text/css" href="${CSS_PATH}RegisterCss.css"/>
		
		<script src="${JS_PATH}jquery-1.10.2.min.js"></script>
		<script>
			$(document).ready(function() {
				$(".rendezvous-input-date:eq(0)").attr("placeholder","出生日期");
				var sex=$("#slo_sex").html();
				//alert(sex);
				if(sex == "0") {
					$("#nv").attr("checked","checked");
				}else {
					$("#nan").attr("checked","checked");
				}
				var birth = $("#slo_birth").html();
				//alert(birth);
				$(".rendezvous-input-date:eq(0)").val(birth);
			});
		</script>
		
	</head>
	<body>
		<div id="register">
		<h1>Modify</h1>  
        <form method="post">  
            <div class="regdiv">
            	<input id="truename" type="text" placeholder="真实姓名" name="truename"  value="<s:property value='#request.truename' />">
            </div>
            <div class="regdiv">
            	<input id="email" type="text" placeholder="邮箱" name="text"  value="<s:property value='#request.email' />"></input><span class="errortip" id="emailtip"></span>
            </div>
            <div class="regdiv" >
            
            	<span id="slo_sex" style="display:none"><s:property value='#request.sex' /></span>
            	
            	<label for="nan" style="position: relative; right: 30px; color: #FFB90F;">男</label>
            	<input id="nan" type="radio" name="sex" value="1" style="position: relative; right: 28px; width: 15px;height: 15px;" checked></input>
            	<label for="nv" style="position: relative; color: #FFB90F;">女</label>
            	<input id="nv" type="radio" name="sex" value="0" style="position: relative;  width: 15px;height: 15px;"></input>
            </div>
            <span id="slo_birth" style="display:none"><s:property value='#request.birth' /></span>
            <div id="rendez-vous-french" style="position: relative;left: 363px;"></div>
           
            <button id="login_but" class="but" type="button" onclick="saveMsg()">保存信息</button><br />
            <a href="MyBlog_modifyPsw" style="color:#fff; text-decoration:none;" >
            	<button id="register_but" class="but" type="button" >重设密码</button><br />
            </a>
            
        </form>  
        </div>
		
	</body>
	
	<script src="${JS_PATH}syntaxhighlighter/shCore.js"></script>
	<script src="${JS_PATH}syntaxhighlighter/shBrushJScript.js"></script>
	<script src="${JS_PATH}syntaxhighlighter/shBrushXml.js"></script>
	<script src="${JS_PATH}syntaxhighlighter/shBrushCss.js"></script>
	<script src="${JS_PATH}rendezvous.js"></script>
	<script src="${JS_PATH}app.js"></script>
	<script src="${JS_PATH}my.min.js"></script>
	
	<script type="text/javascript">
		function saveMsg() {
		
			var email=$("#email").val();
			var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
			if(""==$.trim(email)){
				flag=false;
				$("#emailtip").html("邮箱不能为空");return;
			}else if(!reg.test(email)) {
				flag=false;
				$("#emailtip").html("邮箱格式不正确");return;
			}
			var truename = $("#truename").val();
			var sex = $("input[name='sex']:checked").val();
			var birthday = $(".rendezvous-input-date:eq(0)").val();
			
			var url="../Jsecond/MyJBlog_JmodifyMsg";
		var Myjson = {
				"truename": truename,
				"email" : email,
				"sex" : sex,
				"birthday" : birthday,
				timestamp : new Date().getTime()
		};
		$.post(url, Myjson, function(data) {
			alert("信息修改成功");
			window.location.href="../second/MyBlog_modifyMsg";
		});
			
		}
	</script>
	
</html>


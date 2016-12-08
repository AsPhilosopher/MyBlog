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
		<title>ResetPassword</title>
		<link rel="stylesheet" type="text/css" href="${CSS_PATH}RegisterCss.css"/>
		<script src="${JS_PATH}jquery-1.10.2.min.js"></script>
		<script>
			$(document).ready(function() {
				$("#oldpsw").val("");
				$("#psw").val("");
				$("#repsw").val("");
			});
		</script>
	</head>
	<body>
		<div id="register">  
        <h1>ResetPassword</h1>  
        <form method="post">  
        	<div class="regdiv">
            	<input id="oldpsw" type="password" placeholder="老密码" name="oldpsw"></input><span class="errortip" id="oldpswtip"></span>
            </div>
            <div class="regdiv">
            	<input id="psw" type="password" placeholder="密码" name="password"></input><span class="errortip" id="pswtip"></span>
            </div>
            <div class="regdiv">
            	<input id="repsw" type="password" placeholder="重复密码" name="repassword"></input><span class="errortip" id="repswtip"></span>
            </div>
             <button id="login_but" class="but" type="button" onclick="savePsw()" style="margin-top: 5px;">修改密码</button><br />
        </form>
        </div>
	</body>
	
	<script src="${JS_PATH}my.min.js"></script>
	<script type="text/javascript">
	
	$("#oldpsw").bind('keypress',function(event) {
		if(event.keyCode == "13") {
			savePsw();
		}
	});$("#psw").bind('keypress',function(event) {
		if(event.keyCode == "13") {
			savePsw();
		}
	});$("#repsw").bind('keypress',function(event) {
		if(event.keyCode == "13") {
			savePsw();
		}
	});
	
	function savePsw() {
			var flag;
			var oldpsw = $("#oldpsw").val();
			if(""==$.trim(oldpsw)) {
				flag=false;
				$("#oldpswtip").html("老密码不能为空");return;
			}else if(oldpsw.indexOf(" ")!=-1){
				flag=false;
				$("#oldpswtip").html("老密码不会含空格");return;
			}
			
			var psw = $("#psw").val();
			if(""==$.trim(psw)) {
				flag=false;
				$("#pswtip").html("密码不能为空");return;
			}else if(psw.indexOf(" ")!=-1){
				flag=false;
				$("#pswtip").html("密码不能含空格");return;
			}
			
			var repsw = $("#repsw").val();
			if(""==$.trim(repsw)) {
				flag=false;
				$("#repswtip").html("重复密码不能为空");return;
			}else if(repsw != psw) {
				flag=false;
				$("#repswtip").html("重复密码输入不一致");return;
			}
			
			var url="../Jsecond/MyJBlog_modifyPsw";
			var Myjson = {
					"oldpsw": oldpsw,
					"psw" : psw,
					"repsw" : repsw,
					"birthday" : birthday,
					timestamp : new Date().getTime()
			};
			$.post(url, Myjson, function(data) {
			//alert("hehe");
			//alert(result);
			var result = data.result;
				if(result == false) {
					$("#oldpswtip").html("老密码不正确");
				}else {
				alert("信息修改成功");
				window.location.href="../second/MyBlog_modifyPsw";
				}
			});
			
		}
		</script>
	
</html>


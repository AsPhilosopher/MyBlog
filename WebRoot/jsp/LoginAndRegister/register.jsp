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
		<title>Register</title>
		
		<link rel="stylesheet" href="${CSS_PATH}syntaxhighlighter/shCore.css">
		<link rel="stylesheet" href="${CSS_PATH}syntaxhighlighter/shThemeDefault.css">
		<link rel="stylesheet" href="${CSS_PATH}rendezvous.css">
		<link rel="stylesheet" type="text/css" href="${CSS_PATH}RegisterCss.css"/>
		
		<!--<script src="js/jquery.js"></script>-->
		<script src="${JS_PATH}jquery-1.10.2.min.js"></script>
		<script>
			$(document).ready(function() {
				$(".rendezvous-input-date:eq(0)").attr("placeholder","出生日期");
				/*$(".rendezvous-input-date:eq(0)").val("12 十一月 2016");*/
			});
		</script>
		
	</head>
	<body>
		<div id="register">  
        <h1>Register</h1>  
        <form method="post">  
        	<div class="regdiv">
            	<input id="username" type="text" placeholder="用户名" name="username"></input><span class="errortip" id="usernametip"></span>
            </div>
            <div class="regdiv">
            	<input id="psw" type="password" placeholder="密码" name="password"></input><span class="errortip" id="pswtip"></span>
            </div>
            <div class="regdiv">
            	<input id="repsw" type="password" placeholder="重复密码" name="repassword"></input><span class="errortip" id="repswtip"></span>
            </div>
            <div class="regdiv">
            	<input id="truename" type="text" placeholder="真实姓名" name="truename"><!--</input><span class="errortip" id="truenametip"></span>-->
            </div>
            <div class="regdiv">
            	<input id="email" type="text" placeholder="邮箱" name="text"></input><span class="errortip" id="emailtip"></span>
            </div>
            <div class="regdiv" >
            	<label for="nan" style="position: relative; right: 30px; color: #FFB90F;">男</label>
            	<input id="nan" type="radio" name="sex" value="1" style="position: relative; right: 28px; width: 15px;height: 15px;" checked></input>
            	<label for="nv" style="position: relative; color: #FFB90F;">女</label>
            	<input id="nv" type="radio" name="sex" value="0" style="position: relative;  width: 15px;height: 15px;"></input>
            </div>
            <div id="rendez-vous-french" style="position: relative;left: 363px;"></div>
            <!--<div class="regdiv">
            	<input id='mydatepicker2' type='text' placeholder="出生日期" readonly/>
            </div>-->
            <button id="login_but" class="but" type="button" onclick="register()">注&nbsp;册</button><br />
            
        </form>  
    </div>
    
    
	<script src="${JS_PATH}syntaxhighlighter/shCore.js"></script>
	<script src="${JS_PATH}syntaxhighlighter/shBrushJScript.js"></script>
	<script src="${JS_PATH}syntaxhighlighter/shBrushXml.js"></script>
	<script src="${JS_PATH}syntaxhighlighter/shBrushCss.js"></script>
	<script src="${JS_PATH}rendezvous.js"></script>
	<script src="${JS_PATH}app.js"></script>
	<script src="${JS_PATH}my.min.js"></script>
    
	</body>
</html>

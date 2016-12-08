<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/inc/constants.inc" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>  
<html lang="en">  
<head>  

	<script type="text/javascript">
			window.onload=function() {
				var url = window.location.href;
				//alert(document.getElementById("hhd").innerText);
				if(url.indexOf("login") == -1) {
					window.location.href="login";
				}else if(url.indexOf("second") != -1) {
					window.location.href="../login";
				}
			}
		</script>

    <meta charset="UTF-8">  
    <title>Login</title>  
    <link rel="stylesheet" type="text/css" href="${CSS_PATH}LoginCss.css"/>  
    <link rel="stylesheet" type="text/css" href="${CSS_PATH}slideunlock.min.css">
    
</head>  
<body>  
    <div id="login">  
        <h1>Login</h1>  <%-- <span id="hhd" style="display:none;">haha</span> --%>
        <form method="post"  style="width:700px;">  
        	<div id="errorTip"  style="margin-bottom:10px;"></div>
        	<!-- required oninvalid="setCustomValidity('用户名不能为空')" oninput="setCustomValidity('')" -->
        	<div>
            	<input type="text"  placeholder="用户名" name="username" id="username"  style="display: inline-block;"></input>
            	<span id="un" style="display: inline-block;"></span>  
            </div>
            <div>
            	<input type="password"  placeholder="密码" name="password" id="password"></input>  <span id="pw"></span>  
            </div>
           <!--  <button id="login_but" class="but" type="submit"  style="display:none;">登&nbsp;录</button><br /> -->
            
            <div class="slideunlock-wrapper"  style="position:relative; left:-200px;">
		        <input type="hidden" value="" class="slideunlock-lockable"/>
		        <div class="slideunlock-slider">
		            <span class="slideunlock-label"></span>
		            <span class="slideunlock-lable-tip">滑动我到右侧</span>
		        </div>
		    </div>
            
            <a href="second/MyBlog_register" style="color:#fff; text-decoration:none;">
            	<button id="register_but" class="but" type="button">注&nbsp;册</button>
            </a>
        </form>  
    </div>  
    
    <script type="text/javascript" src="${JS_PATH}jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${JS_PATH}jquery.slideunlock.js"></script>
    <script type="text/javascript">
    $(function () {
        var slider = new SliderUnlock(".slideunlock-slider", {}, function(){
//          alert('success');
			//window.location.href ="http://localhost:8080/MyBlog/first";
			var url = "user_dologin";
			var username = $("#username").val();
			var password = $("#password").val();
			var flag = true;
			$("#un").html("");
			$("#pw").html("");
			if(""==$.trim(username)) {
				flag=false;
				$("#un").html("<span style=\"font-family:'楷体';color: red;margin-bottom: 3px;\"><strong>" + "用户名不能为空" + "</strong></span>");
			}
			if(""==$.trim(password)) {
				flag=false;
				$("#pw").html("<span style=\"font-family:'楷体';color: red;margin-bottom: 3px;\"><strong>" + "密码不能为空" + "</strong></span>");
			}
			
			if(flag) {
				var Myjson = {
					"username": username,
					"password": password,
					timestamp : new Date().getTime()
				};
				$.post(url, Myjson, function(data) {
					var result = data.errorString;
					//var result = data.username;
					if(""==result) {
						window.location = "second/MyBlog_showList";
					}else {
						//alert(data.errorString + "###");
						//alert(result);
						$("#errorTip").html("<span style=\"font-family:'楷体';color: red;margin-bottom: 3px;\"><strong>" + result + "</strong></span>");
						slider.reset();
					}
				});
			}else {
				slider.reset();
			}
			
        } ,
        function(){
            /*$(".warn").text("index:" + slider.index + "， max:" + slider.max + ",lableIndex:" + slider.lableIndex + 
            ",value:" + $(".slideunlock-lockable").val() + " date:" + new Date().getUTCDate());*/
        });
        slider.init();
		/* slider.reset(); */
    })
    </script>
    
</body>  
</html>

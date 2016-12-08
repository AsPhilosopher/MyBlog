<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	    
    <title>index</title>
    
  </head>
  
  <body>
  <%=path %><br/>
    成了，成了，Fuck God!!!<br> ${username}<%-- <%=session.getAttribute("username") %> --%>
    <a href="picture?pagenum=1">图片库</a>
    <a href="editor">文章编辑页</a>
    
  </body>
</html>

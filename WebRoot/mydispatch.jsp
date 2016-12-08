<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	    
    <title></title>
    
    <script type="text/javascript">
			window.onload=function() {
				var url = window.location.href;
				if(url.indexOf("display") != -1) {
					window.location.href="MyBlog_showList";
				}else if(url.indexOf("delete") != -1) {
					window.location.href="MyBlog_showList";
				}else if(url.indexOf("modify") != -1) {
					window.location.href="MyBlog_showList";
				}else {
					window.location.href="../login";
				}
			}
		</script>
    
  </head>
  
  <body>
  </body>
</html>

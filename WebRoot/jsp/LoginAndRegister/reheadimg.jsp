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
		<title>HeadImg</title>
		<style type="text/css">
			h1{ 
				font-family: 'Open Sans',sans-serif;
			    font-size: 2em;   
			    margin: 0.67em 0;
			}   
		</style>
		
		<script type="text/javascript">
			 window.onload=function() {
				var url = window.location.href;
				if(url.indexOf("upload") > 0) {
					window.location.href="MyBlog_showHeadImg";
				}
			} 
		</script>
		
	</head>
	<body style="background-color: #604050;">
	<div id="register">
		<h1 style="text-align: center;">头像设置</h1>
		<div style="text-align: center;">
			<s:if test="#request.imgurl=='' || #request.imgurl==null">
			<img id="previewImg" src="${IMAGE_PATH}preview2.png"  width="80" height="100"/>
		</s:if>
		<s:else>
			<img id="previewImg" src="<%=path %>/../img/<s:property value='#session.username' />/<s:property value='#request.imgurl' />"  width="80" height="100"/>
		</s:else>
		
		</div>
		<div id="large" style="position:absolute; width: 100px;height: 130px;overflow: hidden;"></div>
		<form action="MyBlog_uploadImg" id="myform"  method="post" enctype="multipart/form-data"style="text-align: center;">
	  		<input id="myfile" name="myfile" type="file" onchange="showPreview(this)"style="text-align: center;"/>
	  		<br /><span style="font-size: 5px; color: red; font:'楷体';"><strong id="errorTip"></strong></span><br />
	  		<input type="button" id="sub"  value="提交"  style="text-align: center;" onclick="submit_upload_picture();"/>
  		</form>
  	</div>
	</body>
	<script src="${JS_PATH}/jquery-1.10.2.min.js"></script>
	<script src="${JS_PATH}picture.js"></script>
</html>


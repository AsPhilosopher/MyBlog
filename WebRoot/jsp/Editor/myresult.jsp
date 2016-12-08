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
	    
    <title>文章</title>
	<link rel="stylesheet" type="text/css" href="${CSS_PATH}wangEditor.min.css">
	<script type="text/javascript" src="${JS_PATH}jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${JS_PATH}wangEditor.min.js"></script>
	
	<style type="text/css">
	
		#editor-trigger {
           /*  height: 400px; */
            /*max-height: 500px;*/
        }
		
		.wangEditor-container .wangEditor-txt {
			margin: 0 auto;
			width: 100%;
		}
		
		.wangEditor-container {
			margin: 0 auto;
			width: 80%;
		}
	</style>
	
	<script type="text/javascript">
		
		 $(document).ready(function() {
		
			var val = $("#my_txt").text();
			var s = val.split("@@");
			
			//console.log(s);
			console.log($("iframe"));
			
			var frame = new Array();
			//frame = $("iframe");
			for(i=0; i<s.length-1;i++) {
				$("iframe:eq(" + i + ")").attr("src",s[i]);
			} 
		});
		
		
	</script>
	
  </head>
  
  <body>
    
    <!--  <div id="editor-container"  class="container"> -->
    <div class="wangEditor-container" >
    	<div id="editor-trigger" class="wangEditor-txt"  contenteditable="false"><%=request.getAttribute("txt") %></div>
    </div>
    
    <textarea rows="5" cols="5" style="display:none" id="my_txt" name="textArea">
    	<%=request.getAttribute("val") %>
    </textarea>
    
  </body>
</html>

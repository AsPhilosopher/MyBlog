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
    <title>编辑文章</title>
    <link rel="stylesheet" type="text/css" href="${CSS_PATH}wangEditor.min.css">
    <link rel="stylesheet" type="text/css" href="${CSS_PATH}my.min.css" />
    <style type="text/css">
        #editor-trigger {
            height: 400px;
            /*max-height: 500px;*/
        }
        .container {
            width: 100%;
            margin: 0 auto;
            position: relative;
        }
        
        #sub_but {
        	margin-left : 10%;
        }
    </style>
</head>


<body style="padding:0 20px;  min-width:1200px;">

	<h2 align="center">编辑文章</h2>
	<div style="width:1100px;margin:0 auto;">
 	<embed style="position:relative; left:10%;" wmode="transparent" src="http://chabudai.sakura.ne.jp/blogparts/honehoneclock/honehone_clock_tr.swf" 
 	quality="high" bgcolor="#ffffff" width="160" height="70" name="honehoneclock" align="middle" allowscriptaccess="always" 
 	type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
 	
	<br /><br />
	
	<form action="#"  method="post" style="position:relative; left:10%; width:1035px;" id="myform">
	   <label for="tit" style="color: #FFB90F;"><span>标题:</span></label>
	   <input id="tit" type="text" style="width: 560px;height: 20px; margin-bottom: 6px;" maxlength="100"  name="title" value='<s:property value="#request.title" />'/><span style="color:red" id="errorTip"></span>
	   <br /><br />
	   
	   <label class="mylabel" style="color:#FFB90F;"><span>文章正文</span></label>
	   
	    <div id="editor-container"  class="container" >
	        <div id="editor-trigger"><%=request.getAttribute("blogtext") %></div>
	    </div><br />
	    
	    <textarea rows="5" cols="5" style="display:none" id="txt" name="textArea"></textarea>
	    
	    <a href="/MyBlog/picture?pagenum=1" target="_blank" style="float: right;"><input type="button" value="图片库" class="mybut" /></a><br />
		
		<label class="mylabel" style="color:#FF7F24; font-weight: bold;"><span>文章类别：</span></label>
		
		<s:iterator value="#request.text_type" var="tt">
			
			<s:if test="#tt.texttypeId==#request.typeid">
				<label for="che<s:property value="#tt.texttypeId" />">
				<span class="myfont_kai_B" ><s:property value="#tt.ttName" /></span> 
				</label>
				<input type="radio" value="<s:property value="#tt.ttfName" />" name="type" id="che<s:property value="#tt.texttypeId" />"  checked/>
			</s:if>
			
			<s:else>
				<label for="che<s:property value="#tt.texttypeId" />">
				<span class="myfont_kai_B" ><s:property value="#tt.ttName" /></span> 
				</label>
				<input type="radio" value="<s:property value="#tt.ttfName" />" name="type" id="che<s:property value="#tt.texttypeId" />"/>
			</s:else>
			
		</s:iterator>
		<br /><br />
		
	    <button id="sub_but" type="button" onclick="setVal()" class="mysub" style="position:relative;left:-10%;">
	    	<span class="myfont_kai_B">更新文章</span>
	    </button>
	    
    </form>
    <br /><br />
    </div>
    
    <script type="text/javascript" src="${JS_PATH}jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${JS_PATH}wangEditor.min.js"></script>
    
    <script type="text/javascript">
    
    function getUrlParam(name) {
    	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r!=null) return unescape(r[2]); 
		return null;
    }
    
    	function setVal() {
    		
    		var value = $("#tit").val();
    		var blogid = getUrlParam('blogid');
    		//alert(blogid);////
    		value = $.trim(value); 
    		if(value == "") {
    			$("#errorTip").html("标题不能为空！");
    			window.location.href="#";
    		}
    		else {
	    		var blogtextcontent = $("#editor-trigger").html();
	    		//$("#txt").text(txt);
	    		var url = "Jsecond/MyJBlog_updateBlogText?blogid="+blogid;
	    		var title=$("#tit").val();
	    		//var blogtextcontent = txt;
	    		var texttype=$("input[name='type']:checked").val();
	    		
		    		var Myjson = {
						"title": title,
						"textArea": blogtextcontent,
						"type" : texttype,
						timestamp : new Date().getTime()
					};
					$.post(url, Myjson, function(data) {
						//var result = data.blogid;
						//var result = data.username;
						//alert("blogid");////
						window.location.href="MyBlog_displayText?blogid="+blogid;
		    		});
	    		}
	    		//$("#myform").submit();
    	}
		
		
		
		
		
        var editor = new wangEditor('editor-trigger');

        // 上传图片
        editor.config.uploadImgUrl = '/upload';

        // 自定义上传事件
        editor.config.uploadImgFns.onload = function (resultText, xhr) {
            // resultText 服务器端返回的text
            // xhr 是 xmlHttpRequest 对象，IE8、9中不支持

            // 上传图片时，已经将图片的名字存在 editor.uploadImgOriginalName
            var originalName = editor.uploadImgOriginalName || '';  
            alert(resultText);
            // 如果 resultText 是图片的url地址，可以这样插入图片：
            editor.command(null, 'insertHtml', '<img src="' + resultText + '" alt="' + originalName + '" style="max-width:100%;"/>');
            // 如果不想要 img 的 max-width 样式，也可以这样插入：
            // editor.command(null, 'InsertImage', resultText);
        };

        editor.create();
    </script>
</body>
</html>

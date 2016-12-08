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
		<title>你的博客</title>
		
	     <link rel="stylesheet" type="text/css" href="${CSS_PATH}wangEditor.min.css">
	    <link rel="stylesheet" type="text/css" href="${CSS_PATH}my.min.css" />
	   
    
	    <style type="text/css">
		*{
			padding: 0;
			margin: 0;
		}
		#editor-trigger {
            /*height: 400px;*/
            /*max-height: 500px;*/
           
        }
		
		.wangEditor-container .wangEditor-txt {
			margin: 0 auto;
			width: 100%;
		}
		
		.wangEditor-container {
			float: right;
			/*margin: 0 auto;*/
			width: 80%;
			
		}
	</style>
		
	</head>
	<body style="padding:0px; min-width:1000px;">
		
		
		<div id="headdiv" style="width: 100%; position: relative; margin-bottom:150px ;">
			<a id="thisBlog" href="MyBlog_showList" style="position:absolute; left: 20%; "><h2>M<span style="color:red">y</span>Blog</h2></a>
			<div >
				<!-- <img id="headPIC" style="position: relative;left: 80%; vertical-align: middle;" 
					src="http://127.0.0.1:8080/img/测试1/20161126080656鞠婧祎.png" height="25" width="25"/> -->
				<s:if test="#request.user.getExp2()==null || #request.user.getExp2()==''">
						<img  id="headPIC"  style="position: relative;left: 80%; vertical-align: middle;"  src="<%=path %>/img/preview2.png"  height="25" width="25"/>
					</s:if>
					<s:else>
						<%-- <img  id="headPIC"  style="position: relative;left: 80%; vertical-align: middle;" src="http://127.0.0.1:8080/img/<s:property value='#session.username' />/<s:property value='#request.user.getExp2()' />"  height="25" width="25"/> --%>
						<img  id="headPIC"  style="position: relative;left: 80%; vertical-align: middle;" src="<%=path %>/../img/<s:property value='#session.username' />/<s:property value='#request.user.getExp2()' />"  height="25" width="25"/>
					</s:else>
			</div>
		</div>
		
		<div id="display_menu" style="position: absolute; left:80%; top: 35px; background-color: white; width: 230px; padding-left: 5px; display: none;">
			<input type="input" class="search" placeholder="搜索" style="width: 90%;" /><br />
			<a class="mya" href="MyBlog_modifyMsg" target="_blank"><span>账号信息</span><br /></a>
			<a class="mya" href="MyBlog_logout"><span>退出</span></a>
		</div>
		
		<div style="width:1355px;margin: 0 auto;">
			
			<div id="but_div">
				
				<a href="MyBlog_showList" class="listlink">
					<img src="<%=path %>/../img/list.gif" class="text_but_img"/>
					<!--<input type="button" value="目录视图" class="mybut">-->
					<span class="text_word">目录视图</span>
				</a>
				
				<a href="../editor" class="listlink">
					<img src="<%=path %>/../img/write.gif" class="text_but_img"/>
					<!--<input type="button" value="目录视图" class="mybut">-->
					<span class="text_word">写新文章</span>
				</a>
			</div>
			
			<div id="message" style="position: absolute; top: 240px; width: 200px;  float: left;">
				<div style="width: 100%; text-align: center;  background-color: white;">
					<span>个人资料</span><br />
					<!-- <img src="http://127.0.0.1:8080/img/测试1/20161126080656鞠婧祎.png" height="140px" width="140px"/><br /> -->
					
					<s:if test="#request.user.getExp2()==null || #request.user.getExp2()==''">
					<a href="MyBlog_showHeadImg"  target="_blank">
						<img src="<%=path %>/img/preview2.png"  height="140px" width="140px"/></a><br/>
					</s:if>
					<s:else>
					<a href="MyBlog_showHeadImg"  target="_blank">
<img src="<%=path %>/../img/<s:property value='#session.username' />/<s:property value='#request.user.getExp2()' />"  height="140px" width="140px"/></a><br/>
					</s:else>
					
					<a class="mya" href="MyBlog_modifyMsg" target="_blank"><span><s:property value="#request.user.getUsername()"/></span></a><br />
					<span>访问次数:<s:property value="#request.user.getAccesstimes()"/></span><br />
					<span>博文数量:<s:property value="#request.user.getBlognum()"/></span>
				</div>
				<br />
				<div style="width: 100%; text-align: center;  background-color: white;">
					<span>文章类型</span><br />
					<ul>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(0).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(0).getTtName()' />(<s:property value='#request.typeManager.getCodelanguage()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(1).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(1).getTtName()' />(<s:property value='#request.typeManager.getAlgorithm()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(2).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(2).getTtName()' />(<s:property value='#request.typeManager.getFront()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(3).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(3).getTtName()' />(<s:property value='#request.typeManager.getBack()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(4).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(4).getTtName()' />(<s:property value='#request.typeManager.getMobile()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(5).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(5).getTtName()' />(<s:property value='#request.typeManager.getBigdata()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(6).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(6).getTtName()' />(<s:property value='#request.typeManager.getMachinelearning()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(7).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(7).getTtName()' />(<s:property value='#request.typeManager.getCloud()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(8).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(8).getTtName()' />(<s:property value='#request.typeManager.getAi()' />)
						</span>
						</a></li>
						<li><a href="MyBlog_showList?dir=<s:property value='#request.textTypeName.get(9).getTtName()' />" class="mya">
						<span>
							<s:property value='#request.textTypeName.get(9).getTtName()' />(<s:property value='#request.typeManager.getOthertype()' />)
						</span>
						</a></li>
					</ul>
				</div>
			</div>
			
			<!--<span style="color: #EE6363;"></span>-->
			<div style="margin-top: 25px;">
				
				<s:iterator value="#request.myList" var="ml">
				<div class="TL">
					<a class="mya" href="MyBlog_displayText?blogid=<s:property value="#ml.get('blogtext').getBtId()"/>"><span><s:property value="#ml.get('title')"  escape="false"/></span></a>
					<div class="textmsg">
						<span><s:property value="#ml.get('time')"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<span>阅读(<span style="color: blue;"><s:property value="#ml.get('blogtext').getReadtimes()" /></span>)</span>
						<a href="MyBlog_modifyText?blogid=<s:property value="#ml.get('blogtext').getBtId()"/>"    class="mya">编辑</a>
						<a href="MyBlog_deleteText?blogid=<s:property value="#ml.get('blogtext').getBtId()"/>"  onclick="afun()"  class="mya">删除</a>
					</div>
				</div>
				</s:iterator>
				
				<div id="page">
				<s:if test="#request.flag==1">
					<a class="mya" href="MyBlog_searchWord?pagenum=<s:property value="#request.lastpage"/>&search=<s:property value="#request.kewword"/>">
				</s:if>
				<s:else>
					<a class="mya" href="MyBlog_showList?pagenum=<s:property value="#request.lastpage"/>&dir=<s:property value="#request.dir"/>">
				</s:else>
					<span>上一页</span>
				</a>
					<s:property value="#request.pagenum"/>/<s:property value="#request.maxpage"/>
					
				<s:if test="#request.flag==1">
					<a class="mya" href="MyBlog_searchWord?pagenum=<s:property value="#request.nextpage"/>&search=<s:property value="#request.kewword"/>">
				</s:if>
				<s:else>
					<a class="mya" href="MyBlog_showList?pagenum=<s:property value="#request.nextpage"/>&dir=<s:property value="#request.dir"/>">
				</s:else>
					<span>下一页</span>
					</a>
				</div>
				
	    	</div>
    	
    	</div>
	</body>
	
	<script type="text/javascript" src="${JS_PATH}jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${JS_PATH}wangEditor.min.js"></script>
	
	<script type="text/javascript">
	
		$(".search:eq(0)").bind('keypress',function(event){  
    		if(event.keyCode == "13") {
    			var keyword = $(".search:eq(0)").val();
    			if($.trim(keyword) != "") {
    				//alert("搜索");
    				window.location.href="MyBlog_searchWord?search="+keyword;
    			}
    		}
    	});
	
		function afun(e) {
		//alert("333");
	        //利用对话框返回的值 （true 或者 false）  
	        if (confirm("确认删除？")) {  
	            alert("删除成功！");
	            //window.location.href="MyBlog_deleteText?blogid="+$(".blogid:eq(0)").text();
	        }  
	        else {  
	        	if(e && e.preventDefault) {
	        		e.preventDefault();
	        	}
	        	else
	           		window.event.returnValue=false;
	        }  
			
		}
	
		$("#headPIC").on("mouseover",function(){
			$("#display_menu").css("display","block");
		}).on("mouseout",function(){
			$("#display_menu").css("display","none");
		});
		
		$("#display_menu").on("mouseover",function(){
			$("#display_menu").css("display","block");
		}).on("mouseout",function(){
			$("#display_menu").css("display","none");
		});
		
	</script>
</html>

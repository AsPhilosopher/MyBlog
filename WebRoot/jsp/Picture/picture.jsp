<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/inc/constants.inc" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List urllist = (List)request.getAttribute("picurl");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图片库</title>
		
		<link rel="stylesheet" type="text/css" href="${CSS_PATH}my.min.css" />
		
		<style type="text/css">
			body{
				background-image:url("../img/bj.jpg");
				/* background-repeat:no-repeat; */
				overflow-x: hidden;
			}
			a:hover {
				cursor:hand;
			}
		</style>
		
		<script type="text/javascript">
			window.onload=function() {
				var url = window.location.href;
				if(url.indexOf("upload") > 0) {
					window.location.href="picture?pagenum=1";
				}
			}
		</script>
		
	</head>
	<body>
		
		<h2 style="text-align: center;">&nbsp; 图片库	</h2>
		<div style="text-align: center;">
			<img id="previewImg" src="${IMAGE_PATH}preview2.png"  width="80" height="100"/>
		</div>
		<div id="large" style="position:absolute; width: 100px;height: 130px;overflow: hidden;"></div>
		
		<form action="upload" id="myform"  method="post" enctype="multipart/form-data"style="text-align: center;">
	  		<input id="myfile" name="myfile" type="file" onchange="showPreview(this)"style="text-align: center;"/>
	  		<br /><span style="font-size: 5px; color: red; font:'楷体';"><strong id="errorTip"></strong></span><br />
	  		<input type="button" id="sub"  value="提交"  style="text-align: center;" onclick="submit_upload_picture();"/>
  		</form>
  		
  		<table style="width: 550px; margin: auto; border-spacing: 30px;">
  			<tr>
  				<td style="width: 33%">
  				<s:if test="#request.num >=1">
  					<img src="/MyBlog/../img/<%=session.getAttribute("username") %>/<%=urllist.get(0) %>"  id="img1" height="200" width="175"/>
  					<a href="javascirpt:;" id="copy_btn1" data='1' class="copyBtn"><input type="button" value="复制链接"  id="mg1"  /></a>
  					<a href="download?filename=<%=urllist.get(0) %>"> <input type="button" value="下载图片" style="position: relative;left: 28px;"/> </a>
  				</s:if>
  				</td>
  				
  				<td style="width: 33%">
  				<s:if test="#request.num >=2">
  					<img src="/MyBlog/../img/<%=session.getAttribute("username") %>/<%=urllist.get(1) %>"  id="img2" height="200" width="175"/>
  					<a href="javascirpt:;" id="copy_btn2" data='2' class="copyBtn"><input type="button" value="复制链接"  id="mg2"  /></a>
  					<a href="download?filename=<%=urllist.get(1) %>"> <input type="button" value="下载图片" style="position: relative;left: 28px;"/> </a>
  				</s:if>
  				</td>
  				
  				<td style="width: 33%">
  				<s:if test="#request.num >=3">
  					<img src="/MyBlog/../img/<%=session.getAttribute("username") %>/<%=urllist.get(2) %>"  id="img3" height="200" width="175"/>
  					<a href="javascirpt:;" id="copy_btn3" data='3' class="copyBtn"><input type="button" value="复制链接"  id="mg3"  /></a>
  					<a href="download?filename=<%=urllist.get(2) %>"> <input type="button" value="下载图片" style="position: relative;left: 28px;"/> </a>
  				</s:if>
  				</td>
  				
  			</tr>
  			<tr>
  				<td style="width: 33%">
  					<s:if test="#request.num >=4">
  					<img src="/MyBlog/../img/<%=session.getAttribute("username") %>/<%=urllist.get(3) %>"  id="img4" height="200" width="175"/>
  					<a href="javascirpt:;" id="copy_btn4" data='4' class="copyBtn"><input type="button" value="复制链接"  id="mg4"  /></a>
  					<a href="download?filename=<%=urllist.get(3) %>"> <input type="button" value="下载图片" style="position: relative;left: 28px;"/> </a>
  				</s:if>
  				</td>
  				<td style="width: 33%">
  					<s:if test="#request.num >=5">
  					<img src="/MyBlog/../img/<%=session.getAttribute("username") %>/<%=urllist.get(4) %>"  id="img5" height="200" width="175"/>
  					<a href="javascirpt:;" id="copy_btn5" data='5' class="copyBtn"><input type="button" value="复制链接"  id="mg5"  /></a>
  					<a href="download?filename=<%=urllist.get(4) %>"> <input type="button" value="下载图片" style="position: relative;left: 28px;"/> </a>
  				</s:if>
  				</td>
  				<td style="width: 33%">
  					<s:if test="#request.num >=6">
  					<img src="/MyBlog/../img/<%=session.getAttribute("username") %>/<%=urllist.get(5) %>"  id="img6" height="200" width="175"/>
  					<a href="javascirpt:;" id="copy_btn6" data='6' class="copyBtn"><input type="button" value="复制链接"  id="mg6"  /></a>
  					<a href="download?filename=<%=urllist.get(5) %>"> <input type="button" value="下载图片" style="position: relative;left: 28px;"/> </a>
  				</s:if>
  				</td>
  			</tr>
  		</table>
  		
  		<span style="display:none;" id="becopyed"></span>
  		<input type="button"  id="copy_button" />
  		
  		<div style="text-align: center;">
  			<a href="picture?pagenum=<%=request.getAttribute("lastpage")%>"  class="mya"><span>上一页</span></a>
  			<%=request.getAttribute("nowpage") %>/<%=request.getAttribute("totalPage") %>
  			<a href="picture?pagenum=<%=request.getAttribute("nextpage")%>" class="mya"><span>下一页</span></a>
  		</div>
	</body>
	
	<script type="text/javascript" src="${JS_PATH}jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${JS_PATH}picture.js"></script>
	<script type="text/javascript" src="${JS_PATH}ZeroClipboard.js"></script>
	
	<script type="text/javascript" >
		$(".copyBtn").each(function(i){
		        var id = $(this).attr('data'); //alert(id);
		        var clip=null;
		        clip = new ZeroClipboard.Client();
		        ZeroClipboard.setMoviePath( '${JS_PATH}ZeroClipboard.swf' );  //和html不在同一目录需设置setMoviePath
//		        ZeroClipboard.setMoviePath( 'ZeroClipboard10.swf' );
		        clip.setHandCursor( true );
		        
		        var imgurl = $("#img"+id).attr("src");//alert(imgurl);
		        //clip.setText( $("#copy_txt"+id).val() );
		        clip.setText(imgurl);
		        clip.addEventListener('complete', function (client, text) {
		          alert( "恭喜复制成功" );
		        });
		        clip.glue( 'copy_btn'+id);
		  });
		</script>
</html>

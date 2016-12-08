$('#myfile').change( function() {
				var file = this.files[0];
				var reader = new FileReader();
				reader.onload = function() {
					var url = reader.result;setImageURL(url);
				};
					reader.readAsDataURL(file);
			});
			var image = $("#previewImg")[0];
			function setImageURL(url) {image.src = url;}
			
			var la = $("#large");
			la.hide();
			
			$("#previewImg").mousemove(function(e){
				console.log(e.pageY + "  " + e.pageX);
				la.css({
					top : e.pageY,
					left : e.pageX,
					display : "block"
				}).html('<img src = "' + this.src + '"'+ ' width="100" height="130" />').show();
			}).mouseout(function(){
				la.hide();
			});
			
		  //使用js实现文件上传图片的预览
		function showPreview(obj){
			var str = obj.value;
			document.getElementById("previewImg").innerHTML = 
				"<img src = '" + str + "' />";
		}
		
		
		var MAXSIZE = 1024*1024;//1M
		  var errMsg = "上传的附件文件不能超过2M！！！";
		  var tipMsg = "您的浏览器暂不支持计算上传文件的大小，确保上传文件不要超过2M，建议使用IE、FireFox、Chrome浏览器。";
		  var  browserCfg = {};
		  var ua = window.navigator.userAgent;
		  if (ua.indexOf("MSIE")>=1){
		   browserCfg.ie = true;
		  }else if(ua.indexOf("Firefox")>=1){
		   browserCfg.firefox = true;
		  }else if(ua.indexOf("Chrome")>=1){
		   browserCfg.chrome = true;
		  }


		 function submit_upload_picture(){
		     var file = $('#myfile').val();

		     var obj_file = document.getElementById("myfile");
		     var filesize = 0;
		     if(browserCfg.firefox || browserCfg.chrome ){
		      filesize = obj_file.files[0].size;
		     }
		     
		     else if(browserCfg.ie){
		      var obj_img = document.getElementById('tempimg');
		      obj_img.dynsrc=obj_file.value;
		      filesize = obj_img.fileSize;
		     }else{
		      alert(tipMsg);
		       return;
		     }
		     
		     if(file=="") {
		    	 alert("请选择图片！");
		     }
		     else if(!/.(jpg|jpeg|png|gif|GIF|JPG|JPEG|PNG)$/.test(file)){
		            alert("图片类型必须是jpeg,jpg,png中的一种");
		      }
		     else if(filesize>MAXSIZE) {
		    	 alert("文件大小必须不大于1M");
		    	 
		     }
		     else{
		        	//alert("成了 可以了 哈哈");
		     /* $('both_form').action="file!upload.action";
		      $('both_form').submit();
		      $('insert_img').sethtml('<img src="http://images.anjiwu.com/images/loading.gif"/>');
		      $('display_div').setstyle('display', 'block');
		      $('upload_div').setstyle('display', 'none');*/
		    	 alert("图片上传成功");
		    	 $('#myform').submit();
		     }
		     
		    }
		 
		 
		/* function mycopy(th) {
			 var url = "picture_copy";
			 var imgid="i"+th.id;
			 //alert(imgid);
			var imgurl = $("#"+imgid).attr("src");
			//alert(imgurl);
			var Myjson = {
				"pic_url": imgurl,
				timestamp : new Date().getTime()
			};
			
			$.post(url, Myjson, function(data) {
				var flag = data.flag;
				//var result = data.username;
				if(true==flag) {
					alert("链接复制成功！");
				}else {
					alert("链接复制出错！");
				}
			});
			
		 }*/

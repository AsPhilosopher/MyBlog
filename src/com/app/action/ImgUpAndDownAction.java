package app.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;

import app.ser_ifc.PictureService;
import app.util.PathUtil;
import app.util.SomeConstant;

public class ImgUpAndDownAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;
	private PictureService pictureService;
	
	public PictureService getPictureService() {
		return pictureService;
	}

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

		//取名myfile与前端页面一致
		private File myfile;
		//name值+ContentType，表示上传文件类型
		private String myfileContentType;
		//name值+FileName，表示上传的文件名 
		private String myfileFileName;
		
		private PathUtil pathUtil;
		
		private String inputPath;
		private String filename;
		
		private File file;
		
//		private String result;
		
		public String getInputPath() {
			return inputPath;
		}

		public String getFilename() {
			return filename;
		}

		public void setInputPath(String inputPath) {
			this.inputPath = inputPath;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public File getMyFile() {
			return myfile;
		}
		
		public PathUtil getPathUtil() {
			return pathUtil;
		}

		public void setPathUtil(PathUtil pathUtil) {
			this.pathUtil = pathUtil;
		}

		public void setMyfile(File myfile) {
			this.myfile = myfile;
		}

		public String getMyfileContentType() {
			return myfileContentType;
		}

		public void setMyfileContentType(String myfileContentType) {
			this.myfileContentType = myfileContentType;
		}

		public String getMyfileFileName() {
			return myfileFileName;
		}

		public void setMyfileFileName(String myfileFileName) {
			this.myfileFileName = myfileFileName;
		}

		/*public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}*/

		
		@Override
		public String execute() throws Exception {
						
			if(null == myfileFileName || "".equals(myfileFileName)) {
				pictureService.dopage(1, SomeConstant.EACHPAGE_IMGNUM, request, session);
				return "empty";
			}
			
			String path = pathUtil.getImgpath();
			path +="/"+ session.get("username");
			
//			System.out.println(path + "@@@###");
			File file = new File(path);
			if(!file.exists()){
				file.mkdir();
			}
			String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			System.out.println(timestamp);
			myfileFileName = timestamp+myfileFileName;
			
			pictureService.savePic(myfileFileName, session);
			
			
//			System.out.println(myfileFileName + "#####");
			FileUtils.copyFile(myfile, new File(file,myfileFileName));
			pictureService.dopage(1, SomeConstant.EACHPAGE_IMGNUM, request, session);
			
//			result="上传成功！";
			
			return SUCCESS;
		}
		
		public String download() {
			String path = pathUtil.getImgpath();
//			filename = URLEncoder.encode(filename,"ISO-8859-1");
//			filename = URLDecoder.decode(filename,"UTF-8");
//			filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
			String filePath = path +"/"+session.get("username")+ "/" +filename;
			file = new File(filePath);
			
			System.out.println(file);
			
			if(!file.exists()) {
				return "empty";
			}
			
			return SUCCESS;
		}
		
		public InputStream getInputStream() throws IOException {
//			System.out.println(file);
			
			return FileUtils.openInputStream(file);
//			return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
		}
		
		public String getDownloadFileName() throws UnsupportedEncodingException {
			String downloadFileName = filename;
			downloadFileName = URLEncoder.encode(downloadFileName,"UTF-8");
			System.out.println(downloadFileName + "@@@@@@@@@@@");
			return downloadFileName;
		}
		
}

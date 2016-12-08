package app.action;

import java.io.File;
import java.io.IOException;

import app.util.PathUtil;

public class MyDispatchAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;
	private final String LOGIN = "login";
	
	private MyAppAction myAppAction;
	public MyAppAction getMyAppAction() {
		return myAppAction;
	}
	public void setMyAppAction(MyAppAction myAppAction) {
		this.myAppAction = myAppAction;
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
	
//				private String result;
	
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
	
	public String register() {
		return "register";
	}
	
	public String modifyPsw() {
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		return "modifyPsw";
	}
	
	public String modifyMsg() {
		
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		
		myAppAction.modifyMsg(session, request);
		return "modifyMsg";
	}
	
	public String searchWord() {
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		
		myAppAction.searchWord(session, request);
		
		return "searchWord";
	}
	
	public String logout() {
		session.put("username", null);
		return this.LOGIN;
	}
	
	public String showHeadImg() {
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		myAppAction.showHeadImg(session,request);
		return "uploadImg";
	}
	
	public String uploadImg() {
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		try {
			myAppAction.uploadImg(session,myfileFileName,pathUtil,myfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "uploadImg";
	}
	
	public String showList() {
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		myAppAction.showList(session, request);
		return "showList";
	}
	
	public String modifyText() {
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		
		//是否存在这篇文章
		if(!myAppAction.havethisText(Integer.parseInt( request.getParameter("blogid") ))) {
			return NONE;
		}
		//用户权限管理
		if(!myAppAction.isRightUsername((String)session.get("username"), Integer.parseInt( request.getParameter("blogid") ) )) {
			return this.LOGIN;
		}
		
		myAppAction.modifyText(session, request);
		return "modifyText";
	}
	
	public String deleteText() {
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		
		//是否存在这篇文章
		if(!myAppAction.havethisText(Integer.parseInt( request.getParameter("blogid") ))) {
			return NONE;
		}
		//用户权限管理
		if(!myAppAction.isRightUsername((String)session.get("username"), Integer.parseInt( request.getParameter("blogid") ) )) {
			return this.LOGIN;
		}
		
		myAppAction.deleteText(session, request);
		
		return "deleteText";
	}
	
	//显示文章内容
	public String displayText() {
		if(null == session.get("username")) {
			return this.LOGIN;
		}
		//是否存在这篇文章
		if(!myAppAction.havethisText(Integer.parseInt( request.getParameter("blogid") ))) {
			return NONE;
		}
		//用户权限管理
		if(!myAppAction.isRightUsername((String)session.get("username"), Integer.parseInt( request.getParameter("blogid") ) )) {
			return this.LOGIN;
		}
		
		
		myAppAction.displayText(request, session);
		
		return "displayText";
	}

	/*public static void main(String[] args) {

	}*/

}

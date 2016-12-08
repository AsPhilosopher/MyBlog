package app.action;

import java.text.ParseException;

public class MyAjaxAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;
	private MyAppAction myAppAction;
	
	public void setMyAppAction(MyAppAction myAppAction) {
		this.myAppAction = myAppAction;
	}
	
	private String blogid;
	private boolean result;
//	private Map map;

	
	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getBlogid() {
		return blogid;
	}

	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}
	
	public String modifyPsw() {
		result = myAppAction.modifyPsw(session, request);
//		System.out.println(result + "^^^^^^");
		return "MODIFY_PSW_SUCCESS";
	}
	
	public String JmodifyMsg() {
		try {
			myAppAction.JmodifyMsg(session, request);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MODIFY_MSG_SUCCESS";
	}
	
	public String register() {
		try {
			this.result = myAppAction.register(request);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "REGISTER_SUCCESS";
	}
	
	public String saveBlogText() {
		this.blogid = myAppAction.saveBlogText(this.session, this.request);
		return "SAVE_BLOG_SUCCESS";
	}
	
	public String updateBlogText() {
		myAppAction.updateBlogText(session, request);
		return "MODIFY_SUCCESS";
	}

}

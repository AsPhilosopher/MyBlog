package app.action;

import app.domain.User;
import app.ser_ifc.UserService;

public class LoginAction extends StrutsBaseAction { //implements ModelDriven<User>  implements ModelDriven<Map>
	
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	private String errorString;
	
//	private User user = new User();
//	private Map map = new HashMap<String, Object>();

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}
	

	/*public Map getModel() {
		map.put("errorString", errorString);
		map.put("user", user);
		return map;
	}*/
	
	/*public UserService getUserService() {
		return userService;
	}*/

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String dologin() {
//		System.out.println(user.getPassword() + "@@@@" + user.getUsername());

		User myuser = new User();
//		System.out.println(request.getParameter("username") + "@@@@" + request.getParameter("password"));
		myuser.setUsername(request.getParameter("username"));
		myuser.setPassword(request.getParameter("password"));
		
		this.errorString="";
		boolean result = userService.login(myuser);
		if(!result) {
			this.errorString = "用户名或密码错误！！！";
		}
		session.put("username", myuser.getUsername());
		
		return "MYERROR";
	}
	
	public String douser() {
		return SUCCESS;
	}

}

package app.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsBaseAction  extends ActionSupport
	implements SessionAware,ServletResponseAware, ServletRequestAware  {
	
	private static final long serialVersionUID = 1L;
	protected Map session; // 系统中所用到的session，实现了sessionAware接口
	public HttpServletResponse response;// 系统响应
	public HttpServletRequest request;// 系统请求

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

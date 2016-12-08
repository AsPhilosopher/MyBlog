package app.action;

import app.ser_ifc.BlogTextService;

public class EditorAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;
	private BlogTextService blogTextService;
	
	public BlogTextService getBlogTextService() {
		return blogTextService;
	}


	public void setBlogTextService(BlogTextService blogTextService) {
		this.blogTextService = blogTextService;
	}


	@Override
	public String execute() throws Exception {
//		System.out.println(session.get("username") + "####");
		if(null==session.get("username")) {
			
			return "login";
		}
		blogTextService.doTextType(request);
		
		return SUCCESS;
		
	}

	
}


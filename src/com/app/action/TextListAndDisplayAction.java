package app.action;

public class TextListAndDisplayAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		if(null == session.get("username")) {
			return "login";
		}
		return SUCCESS;
	}
	
	public String titleList() {
		if(null == session.get("username")) {
			return "login";
		}
		return SUCCESS;
	}

	
}

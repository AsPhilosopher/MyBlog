package app.action;

import app.ser_ifc.PictureService;
import app.util.SomeConstant;

public class PictureAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;
	private PictureService pictureService;
	
	public PictureService getPictureService() {
		return pictureService;
	}


	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}


	public String execute() {
//		System.out.println(request.getParameter("pagenum"));
		String nowpageStr = request.getParameter("pagenum");
		int nowpage;
		if(null == nowpageStr)
			nowpage=1;
		else {
			nowpage = Integer.parseInt(nowpageStr);
		}
		
		
//		System.out.println("@@@@");
		if(null != session.get("username")) {
//			System.out.println(session.get("username") + "@@@@");
			pictureService.dopage(nowpage, SomeConstant.EACHPAGE_IMGNUM, request, session);
			return SUCCESS;
		}
		else {
			
			return "login";
		}
	}
}

package app.action;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MyEditorAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		
		/*HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();*/
		
		String text = request.getParameter("textArea");
		
//		System.out.println(text + "###@@");
		
		Document doc = Jsoup.parse(text);
//		session.setAttribute("txt", text);
		request.setAttribute("txt", text);
		
//		String json = " {\"name\":\"ZhangSan\", \"age\":18, \"sex\":\"male\"}";
		
		
		Elements eles = doc.select("iframe");
		
		if(null != eles) {
			
			String string="";
			
			for(Element ele : eles) {
				string +=ele.attr("src");
				string +="@@";
			}
//			string = string.substring(0, string.length()-3);
//			System.out.println(string + "我的值");
//			session.setAttribute("val", string);
			request.setAttribute("val", string);
		}
		
		return SUCCESS;
	}
	
}

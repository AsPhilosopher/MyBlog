package app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EditorTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String text = request.getParameter("textArea");
		
		System.out.println(text + "###@@");
		
		Document doc = Jsoup.parse(text);
		session.setAttribute("txt", text);
		
//		System.out.println(text);
		
//		String json = " {\"name\":\"ZhangSan\", \"age\":18, \"sex\":\"male\"}";
		
		
		Elements eles = doc.select("iframe");
		
		if(null != eles) {
			
			String string="";
			
			for(Element ele : eles) {
				string +=ele.attr("src");
				string +="@@";
			}
//			string = string.substring(0, string.length()-3);
			System.out.println(string + "我的值");
			session.setAttribute("val", string);
		}
		
		
		
		/*if(null != eles) {
			
			String json = "{\"val\":";
			int i=0;
			
			for(Element ele : eles) {
//				list.add(ele.attr("src"));
				json += "\"" + ele.attr("src") +"\"";
				if(i !=0) {
					json += ",";
				}
				++i;
			}
			
			json += "}";
			out.print(json);
		}*/
		
		//请求转发
		RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request,response);
		
//		out.print("Test");
//		System.out.println("@@@@@@@@@@");
		
		out.flush();
		out.close();
	}

}

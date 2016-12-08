package app.action;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.aspectj.apache.bcel.generic.NEW;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import freemarker.cache.StringTemplateLoader;

import app.dao.MyAppDAO;
import app.domain.Blogtext;
import app.domain.TextType;
import app.domain.TextTypeManager;
import app.domain.User;
import app.util.PathUtil;
import app.util.SomeConstant;


public class MyAppAction extends StrutsBaseAction {

	private static final long serialVersionUID = 1L;

	private MyAppDAO myAppDAO;

	public MyAppDAO getMyAppDAO() {
		return myAppDAO;
	}

	public void setMyAppDAO(MyAppDAO myAppDAO) {
		this.myAppDAO = myAppDAO;
	}
	
	
	public boolean modifyPsw(Map<String, Object> session, HttpServletRequest request) {
		String nowusername = (String) session.get("username");
		User user = (User) myAppDAO.findFirstOne("from User where username=?", nowusername);
		String psw = request.getParameter("oldpsw");
		if(!psw.equals(user.getPassword()))
			return false;
		
		user.setPassword(request.getParameter("psw"));
		myAppDAO.update(user);
		return true;
	}
	
	public boolean havethisText(int blogid) {
		Blogtext blogtext = (Blogtext) myAppDAO.
				findFirstOne("from Blogtext where btId = ?", blogid);
		return blogtext!=null;
	}
	
	public boolean isRightUsername(String username, int blogid) {
		Blogtext blogtext = (Blogtext) myAppDAO.
				findFirstOne("from Blogtext where btId = ?", blogid);
		return blogtext.getAuthorname().equals(username);
	}
	
	private int getNextPageNum(int nowpage, int maxpage) {
		if(nowpage==maxpage)
			return maxpage;
		return nowpage+1;
	}
	private int getLastPageNum(int nowpage) {
		if(nowpage==1)
			return 1;
		return nowpage-1;
	}
	
	private String doSearch(String text, String keyword) {
		StringBuffer stringBuffer = new StringBuffer(text);
		int first = text.toLowerCase().indexOf(keyword.toLowerCase());
//		int first = stringBuffer.indexOf(keyword);
//		System.out.println(first+"@@@@");
		/*if(first<0)
			first=0;*/
		stringBuffer.insert(first, "<span class='keyword'>");
//		first = stringBuffer.indexOf(keyword);
		
		text = stringBuffer.toString();
		first = text.toLowerCase().indexOf(keyword.toLowerCase());
		
		stringBuffer.insert(first+keyword.length(), "</span>");
		return stringBuffer.toString();
	}
	
	private String getRightBirth(String string) {
		if("一月".equals(string)) {
			return "1";
		}
		if("二月".equals(string)) {
			return "2";
		}
		if("三月".equals(string)) {
			return "3";
		}
		if("四月".equals(string)) {
			return "4";
		}
		if("五月".equals(string)) {
			return "5";
		}
		if("六月".equals(string)) {
			return "6";
		}
		if("七月".equals(string)) {
			return "7";
		}
		if("八月".equals(string)) {
			return "8";
		}
		if("九月".equals(string)) {
			return "9";
		}
		if("十月".equals(string)) {
			return "10";
		}
		if("十一月".equals(string)) {
			return "11";
		}
		if("十二月".equals(string)) {
			return "12";
		}
		if("1".equals(string) || "01".equals(string) ) {
			return "一月";
		}
		if("2".equals(string) || "02".equals(string)) {
			return "二月";
		}
		if("3".equals(string) || "03".equals(string)) {
			return "三月";
		}
		if("4".equals(string) || "04".equals(string)) {
			return "四月";
		}
		if("5".equals(string) || "05".equals(string)) {
			return "五月";
		}
		if("6".equals(string) || "06".equals(string)) {
			return "六月";
		}
		if("7".equals(string) || "07".equals(string)) {
			return "七月";
		}
		if("8".equals(string) || "08".equals(string)) {
			return "八月";
		}
		if("9".equals(string) || "09".equals(string)) {
			return "九月";
		}
		if("10".equals(string)) {
			return "十月";
		}if("11".equals(string)) {
			return "十一月";
		}return "十二月";
	}
	
	private String getNotNull(String string) {
		return (string==null)?"":string;
	}
	
	public void JmodifyMsg(Map<String, Object> session, HttpServletRequest request) throws ParseException {
		String nowusername = (String) session.get("username");
		User user = (User) myAppDAO.
				findFirstOne("from User where username=?", nowusername);
		user.setTruename(request.getParameter("truename"));
		user.setEmail(request.getParameter("email"));
		user.setSex(Short.parseShort(request.getParameter("sex")));
		
		String birthday = request.getParameter("birthday");
		
		if(birthday != "" && null !=birthday) {
			String[] mybirthday = birthday.split(" ");
			
			String month = this.getRightBirth(mybirthday[1]);
			birthday = mybirthday[2]+" "+month+" "+mybirthday[0];
			SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy MM dd" );
			Date birthDate = sdf.parse(birthday);
			user.setBirthday(birthDate);
		}
		myAppDAO.update(user);
	}
	
	public void modifyMsg(Map<String, Object> session, HttpServletRequest request) {
		String nowusername = (String) session.get("username");
		User user = (User) myAppDAO.findFirstOne("from User where username=?", nowusername);
		request.setAttribute("truename", this.getNotNull(user.getTruename()));
		request.setAttribute("email", this.getNotNull(user.getEmail()));
		request.setAttribute("sex", user.getSex());
		Date birthDate = user.getBirthday();
		String birthString;
		if(null != birthDate) {
			birthString = new SimpleDateFormat("yyyy MM dd").format(birthDate);
			
//			System.out.println(birthString+"@@@@");////
			
			String [] splitbirth = birthString.split(" ");
			System.out.println(splitbirth[1]+"$$$$");
			String month = this.getRightBirth(splitbirth[1]);
			birthString = splitbirth[2] + " " +month +" " +splitbirth[0];
			
			System.out.println(birthString + "####");////
		}else {
			birthString="";
		}
		request.setAttribute("birth", birthString);
	}
	
	public void showHeadImg(Map<String, Object> session, HttpServletRequest request) {
		String nowusername = (String) session.get("username");
		String imgurl = (String)myAppDAO.
				findFirstOne("select exp2 from User where username=?", nowusername);
		request.setAttribute("imgurl", imgurl);
	}
	
	public void uploadImg(Map<String, Object> session, String myfileFileName, PathUtil pathUtil, File myfile) throws IOException {
		String nowusername = (String) session.get("username");
		if(null == myfileFileName || "".equals(myfileFileName)) {
			/*String imgurl = (String)myAppDAO.
					findFirstOne("select exp2 from User where username=?", nowusername);
			request.setAttribute("imgurl", imgurl);*/
			
		}else {
			String path = pathUtil.getImgpath();
			path +="/"+ session.get("username");
			
			File file = new File(path);
			if(!file.exists()){
				file.mkdir();
			}
			String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			System.out.println(timestamp);
			myfileFileName = timestamp+myfileFileName;
			
			FileUtils.copyFile(myfile, new File(file,myfileFileName));
			
			System.out.println(nowusername+"@@@@@");
			
			User user = (User) myAppDAO.
					findFirstOne("from User where username =?", nowusername);
			user.setExp2(myfileFileName);
			myAppDAO.update(user);
			
//			request.setAttribute("imgurl", myfileFileName);
		}
	}
	
	public boolean register(HttpServletRequest request) throws ParseException {
		
		String username = request.getParameter("username"); //获取用户名
		if(null != myAppDAO.findFirstOne("from User where username=?", username)) {
			return false;
		}
		
		/*
		 * 获取注册参数
		 */
		String psw = request.getParameter("psw");
		String truename = request.getParameter("truename");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		
		/*
		 * 参数类型调整
		 */
		User user = new User();
		if(null == sex || "".equals(sex)) {
			sex="1";
		}
		short mysex = Short.parseShort(sex);
		
		if(birthday != "" && null !=birthday) {
			String[] mybirthday = birthday.split(" ");
			
			String month = this.getRightBirth(mybirthday[1]);
			birthday = mybirthday[2]+" "+month+" "+mybirthday[0];
			SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy MM dd" );
			Date birthDate = sdf.parse(birthday);
			user.setBirthday(birthDate);
		}
		
		/*
		 * 设置实体类参数
		 */
		
		user.setUsername(username);
		user.setPassword(psw);
		user.setTruename(truename);
		user.setEmail(email);
		user.setSex(mysex);
//		user.setBirthday(birthDate);
		user.setCreatetime(new Date());
		user.setBlognum(0);
		user.setAccesstimes(1);
		
		TextTypeManager textTypeManager = new TextTypeManager();
		textTypeManager.setUsername(username);
		
		user.setTextTypeManager(textTypeManager);
		textTypeManager.setUser(user);
		
		textTypeManager.setCodelanguage(0);
		textTypeManager.setAlgorithm(0);
		textTypeManager.setFront(0);
		textTypeManager.setBack(0);
		textTypeManager.setMobile(0);
		textTypeManager.setBigdata(0);
		textTypeManager.setMachinelearning(0);
		textTypeManager.setCloud(0);
		textTypeManager.setAi(0);
		textTypeManager.setOthertype(0);
		
		List list = myAppDAO.findAll("from TextTypeManager order by typeId DESC");
		int id;
		if(null != list && list.size()>0) {
			id=list.size()+1;
		}else {
			id=1;
		}
		textTypeManager.setTypeId(id);
		
		list = myAppDAO.findAll("from User order by userId DESC");
		if(null != list && list.size()>0) {
			id=list.size()+1;
		}else {
			id=1;
		}
		user.setUserId(id);
		
		/*
		 * 保存数据
		 */
		myAppDAO.save(textTypeManager);
		myAppDAO.save(user);
		
		
		return true;
	}
	
	public void searchWord(Map<String, Object> session, HttpServletRequest request) {
		/*
		 * 获取前端相关参数
		 */
		String nowusername = (String) session.get("username");
		String pageString = request.getParameter("pagenum");
		String searchword = request.getParameter("search");
		
		/*
		 * 矫正关键字
		 */
		if(null == searchword || searchword.trim().equals("")) {
			searchword="";
		}
		
		/*
		 * 获取当前页码
		 */
		int pagenum;
		if(null == pageString || pageString.trim().equals("")) {
			pagenum=1;
		}else {
			pagenum=Integer.parseInt(pageString);
			if(pagenum <= 1) {
				pagenum=1;
			}
		}
		
		String counthql = "select count(id)  from Blogtext where authorname = '"+nowusername+"' and title like '%"+searchword+"%'";;
		String hql = "from Blogtext where authorname = '"+nowusername+"' and title like '%"+searchword+"%'";
		
		//获得文章总量
		long countSizeL = (long) myAppDAO.findFirstByHQL(counthql);
		int countSize=(int) (countSizeL/1);
		
		//获得最大页数
		int maxpage = countSize/SomeConstant.EACHPAGE_TEXTNUM;
		if(countSize%SomeConstant.EACHPAGE_TEXTNUM != 0) {
			maxpage++;
		}
		if(maxpage<=0)
			maxpage=1;
		//最后矫正当前页码
		if(pagenum>maxpage) {
			pagenum=maxpage;
		}
		//获得上一页  下一页
		int nextpage = this.getNextPageNum(pagenum, maxpage);
		int lastpage = this.getLastPageNum(pagenum);
		//获取从第几个开始取
		int firstresult = SomeConstant.EACHPAGE_TEXTNUM*(pagenum-1);
		
		//获取相关类
		List<Blogtext> textList = myAppDAO.
				page(hql, firstresult, SomeConstant.EACHPAGE_TEXTNUM);
		//获得用户类
		User user = (User) myAppDAO.
				findFirstOne("from User where username=?", nowusername);
		//获得文章分类管理类
		TextTypeManager textTypeManager = (TextTypeManager) myAppDAO.findFirstOne("from TextTypeManager where username=?", nowusername);
		//获得文章分类类
		List<TextType> textTypesList = myAppDAO.findAll("from TextType");
		
		//封装数据模块
		List myList = new ArrayList();
		for (Blogtext text : textList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("blogtext", text);
			
			map.put("title",  this.doSearch(text.getTitle(), searchword));
			
			map.put("time", new SimpleDateFormat("YYYY-MM-dd").format(text.getLastmodify()));
			myList.add(map);
		}
		
		//设置相关参数
		request.setAttribute("user", user);
//				request.setAttribute("blogtext", textList);
		request.setAttribute("myList", myList);
		request.setAttribute("typeManager", textTypeManager);
		request.setAttribute("textTypeName", textTypesList);
		
		request.setAttribute("pagenum", pagenum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("nextpage", nextpage);
		request.setAttribute("lastpage", lastpage);
		
		request.setAttribute("flag", 1);
		request.setAttribute("kewword", searchword);
	}
	
	public void showList(Map<String, Object> session, HttpServletRequest request) {
		/*
		 * 获取前端相关参数
		 */
		String nowusername = (String) session.get("username");
		String pageString = request.getParameter("pagenum");
		String dir = request.getParameter("dir");
		
		
//		System.out.println(dir+"@@@@@");
		/*
		 * 获取当前页码
		 */
		int pagenum;
		if(null == pageString || pageString.trim().equals("")) {
			pagenum=1;
		}else {
			pagenum=Integer.parseInt(pageString);
			if(pagenum <= 1) {
				pagenum=1;
			}
		}
		//获得文章总量
		long countSizeL;
		if(null!=dir && !dir.trim().equals("")) {
			countSizeL = (long) myAppDAO.
					findFirstOne("select count(id)  from Blogtext where authorname=? and btType =?", nowusername, dir);
			
		}else {
			countSizeL = (long) myAppDAO.
					findFirstOne("select count(id)  from Blogtext where authorname=?", nowusername);
			dir="";
		}
		int countSize=(int) (countSizeL/1);
		//获得最大页数
		int maxpage = countSize/SomeConstant.EACHPAGE_TEXTNUM;
		if(countSize%SomeConstant.EACHPAGE_TEXTNUM != 0) {
			maxpage++;
		}
		if(maxpage<=0)
			maxpage=1;
		//最后矫正当前页码
		if(pagenum>maxpage) {
			pagenum=maxpage;
		}
		//获得上一页  下一页
		int nextpage = this.getNextPageNum(pagenum, maxpage);
		int lastpage = this.getLastPageNum(pagenum);
		//获取从第几个开始取
		int firstresult = SomeConstant.EACHPAGE_TEXTNUM*(pagenum-1);
		
		//设置hql
		String hql;
		if(null!=dir && !dir.trim().equals("")) {
			hql = "from Blogtext where authorname='"+nowusername+"'  and btType = '"+dir+"'  order by lastmodify DESC";
		} else {
			hql = "from Blogtext where authorname='"+nowusername+"'  order by lastmodify DESC";
		}
		
		//获取相关类
		List<Blogtext> textList = myAppDAO.
				page(hql, firstresult, SomeConstant.EACHPAGE_TEXTNUM);
		//获得用户类
		User user = (User) myAppDAO.
				findFirstOne("from User where username=?", nowusername);
		//获得文章分类管理类
		TextTypeManager textTypeManager = (TextTypeManager) myAppDAO.findFirstOne("from TextTypeManager where username=?", nowusername);
		//获得文章分类类
		List<TextType> textTypesList = myAppDAO.findAll("from TextType");
		
		//封装数据模块
		List myList = new ArrayList();
		for (Blogtext text : textList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("blogtext", text);
			map.put("title", text.getTitle());
			map.put("time", new SimpleDateFormat("YYYY-MM-dd").format(text.getLastmodify()));
			myList.add(map);
		}
		
		//设置相关参数
		request.setAttribute("user", user);
//		request.setAttribute("blogtext", textList);
		request.setAttribute("myList", myList);
		request.setAttribute("typeManager", textTypeManager);
		request.setAttribute("textTypeName", textTypesList);
		
		request.setAttribute("pagenum", pagenum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("nextpage", nextpage);
		request.setAttribute("lastpage", lastpage);
		
		request.setAttribute("dir", dir);
	}
	
	public void updateBlogText(Map<String, Object> session, HttpServletRequest request) {
		/*
		 * 获取前端参数
		 */
		String title = request.getParameter("title");
		String blogtextcontent = request.getParameter("textArea");
		String texttype = request.getParameter("type");
		int blogid = Integer.parseInt(request.getParameter("blogid"));
		
		String typeName = (String) myAppDAO.
				findFirstOne("select ttName from TextType where ttfName=?", texttype);//获取当前文章类型名
		
		/*
		 * 获得相应类
		 */
		String nowusername = (String) session.get("username");
		User user = (User) myAppDAO.findFirstOne("from User where username =?", nowusername);
		Blogtext blogtext = (Blogtext) myAppDAO.findFirstOne("from Blogtext where btId = ?", blogid);
		
		/*
		 * 修改相应属性
		 */
		blogtext.setTitle(title);
		blogtext.setBlogtext(blogtextcontent);
		if(!blogtext.getBtType().equals(typeName)) { //类型名变了
			TextTypeManager textTypeManager = (TextTypeManager) myAppDAO.
					findFirstOne("from TextTypeManager where username=?", nowusername);
			String oldTypeName = blogtext.getBtType();
			String oldTypeCode = (String) myAppDAO.
					findFirstOne("select ttfName from TextType where ttName=?", oldTypeName); //获得老的类型名和类型编码
			
			blogtext.setBtType(typeName);//更新文章类型名
			
//			System.out.println(textTypeManager + "@@@@@@");
			
			this.dotexttypeTimes(textTypeManager, oldTypeCode, -1);
			this.dotexttypeTimes(textTypeManager, texttype, 1);
			
			myAppDAO.update(textTypeManager); //根新文章管理类
		}
		/*user.setAccesstimes(user.getAccesstimes()+1);
		blogtext.setReadtimes(blogtext.getReadtimes()+1);*/
		blogtext.setLastmodify(new Date());
		myAppDAO.update(blogtext);
		myAppDAO.update(user);
		
	}
	
	public void modifyText(Map<String, Object> session, HttpServletRequest request) {
		/*
		 * 获取必要参数
		 */
		String username = (String) session.get("username");
		int blogid = Integer.parseInt(request.getParameter("blogid"));
		
		/*
		 * 获取必要类
		 */
		Blogtext blogtext = (Blogtext) myAppDAO.findFirstOne("from Blogtext where btId=?", blogid);
		String type = blogtext.getBtType();
		int typeid = (int) myAppDAO.findFirstOne("select texttypeId from TextType where ttName=?", type);
		List<TextType> list = myAppDAO.findAll("from TextType");
		
		/*
		 * 设置参数
		 */
		request.setAttribute("title", blogtext.getTitle());
		request.setAttribute("blogtext", blogtext.getBlogtext());
		request.setAttribute("typeid", typeid);
		request.setAttribute("text_type", list);
	}
	
	public void deleteText(Map<String, Object> session, HttpServletRequest request) {
		/*
		 * 获取必要参数
		 */
		String username = (String) session.get("username");
		Integer blogid = Integer.parseInt(request.getParameter("blogid"));
		
		/*
		 * 获取相关类
		 */
		Blogtext blogtext = (Blogtext) myAppDAO.
				findFirstOne("from Blogtext where btId = ?", blogid);
		User user = (User) myAppDAO.
				findFirstOne("from User where username=?", username);
		String type = blogtext.getBtType();
		
		type = (String) myAppDAO.
				findFirstOne("select ttfName from TextType where ttName=?", type);     //获取类型的字段名
		
		TextTypeManager textTypeManager = (TextTypeManager) myAppDAO.
				findFirstOne("from TextTypeManager where username=?", username);
		//修改相应参数
		this.dotexttypeTimes(textTypeManager, type, -1);
		user.setBlognum(user.getBlognum()-1);
		
		//执行
		myAppDAO.update(textTypeManager);
		myAppDAO.update(user);
		myAppDAO.delete(blogtext);
	}
	
	private void dotexttypeTimes(TextTypeManager textTypeManager, String texttype, int add) {
		switch (texttype) {
		case "CODELANGUAGE":
			textTypeManager.setCodelanguage(textTypeManager.getCodelanguage()+add);
			break;
		case "ALGORITHM":
			textTypeManager.setAlgorithm(textTypeManager.getAlgorithm()+add);
			break;
		case "FRONT":
			textTypeManager.setFront(textTypeManager.getFront()+add);
			break;
		case "BACK":
			textTypeManager.setBack(textTypeManager.getBack()+add);
			break;
		case "MOBILE":
			textTypeManager.setMobile(textTypeManager.getMobile()+add);
			break;
		case "BIGDATA":
			textTypeManager.setBigdata(textTypeManager.getBigdata()+add);
			break;
		case "MACHINELEARNING":
			textTypeManager.setMachinelearning(textTypeManager.getMachinelearning()+add);
			break;
		case "CLOUD":
			textTypeManager.setCloud(textTypeManager.getCloud()+add);
			break;
		case "AI":
			textTypeManager.setAi(textTypeManager.getAi()+add);
			break;
		case "OTHERTYPE":
			textTypeManager.setOthertype(textTypeManager.getOthertype()+add);
			break;
		default:
			break;
		}
	}
	
	private void getTypeNumList(List list, TextTypeManager textTypeManager) {
		list.add(textTypeManager.getCodelanguage());
		list.add(textTypeManager.getAlgorithm());
		list.add(textTypeManager.getFront());
		list.add(textTypeManager.getBack());
		list.add(textTypeManager.getMobile());
		list.add(textTypeManager.getBigdata());
		list.add(textTypeManager.getMachinelearning());
		list.add(textTypeManager.getCloud());
		list.add(textTypeManager.getAi());
		list.add(textTypeManager.getOthertype());
	}
	
	public String saveBlogText(Map<String, Object> session, HttpServletRequest request) {
		/*
		 * 获取前端参数
		 */
		String title = request.getParameter("title");
		String blogtextcontent = request.getParameter("textArea");
		String texttype = request.getParameter("type");
		
		Blogtext blogtext = new Blogtext();
		String nowusername = (String) session.get("username");
		//获得用户类
		User user = (User) myAppDAO.findFirstOne("from User where username =?", nowusername);
		
		//获得文章分类管理类
		TextTypeManager textTypeManager = (TextTypeManager) myAppDAO.findFirstOne("from TextTypeManager where username=?", user.getUsername());
		
		//获得文章分类类
		List<TextType> textTypesList = myAppDAO.findAll("from TextType");
		
		this.dotexttypeTimes(textTypeManager, texttype, 1);//文章分类的对应类型的文章数量加一
		texttype = (String) myAppDAO.findFirstOne("select ttName from TextType where ttfName=?", texttype);
//		user.setAccesstimes(user.getAccesstimes()+1);//博客访问次数加一
		user.setBlognum(user.getBlognum()+1);//博文数量加一
		
		/*
		 * 博客相关参数设置
		 */
		blogtext.setTitle(title);
		blogtext.setBlogtext(blogtextcontent);
		blogtext.setBtType(texttype);
		blogtext.setAuthorname(user.getUsername());
		blogtext.setReadtimes(0);
		Date date = new Date();
		blogtext.setPublishtime(date);
		blogtext.setLastmodify(date);
		
		/*
		 * 博文 用户 分类管理保存
		 */
		myAppDAO.save(blogtext);
		myAppDAO.update(user);
		myAppDAO.update(textTypeManager);
		
		String blogid = (int) myAppDAO.
				findFirstOne("select btId from Blogtext where title=? and authorname=? order by btId DESC", title, nowusername)+"";
		
		return blogid;
	}
	
	public void displayText(HttpServletRequest request,  Map<String, Object> session) {
		/*
		 * 获取博客
		 */
		int blogid = Integer.parseInt(request.getParameter("blogid"));
		Blogtext blogtext = (Blogtext) myAppDAO.findFirstOne("from Blogtext where btId=?", blogid);
		String title = blogtext.getTitle();
		String blogtextcontent = blogtext.getBlogtext();
		String texttype = blogtext.getBtType();
		
		/*
		 * DOM处理模块
		 */
		Document doc = Jsoup.parse(blogtextcontent);
		request.setAttribute("txt", blogtextcontent);
		
		Elements eles = doc.select("iframe");
		
		if(null != eles) {
			
			String string="";
			
			for(Element ele : eles) {
				string +=ele.attr("src");
				string +="@@";
			}

			request.setAttribute("val", string);
		}
		
		
//		Blogtext blogtext = new Blogtext();
		String nowusername = (String) session.get("username");
		//获得用户类
		User user = (User) myAppDAO.findFirstOne("from User where username =?", nowusername);
		
		//获得文章分类管理类
		TextTypeManager textTypeManager = (TextTypeManager) myAppDAO.findFirstOne("from TextTypeManager where username=?", user.getUsername());
		
		//获得文章分类类
		List<TextType> textTypesList = myAppDAO.findAll("from TextType");
		
		//用户访问量模块
		if(null == session.get("readtext") ) {
			session.put("readtext", new HashMap<Integer, String>());
		}
		Map readMap = (Map) session.get("readtext");
		if(null == readMap.get(blogid)) {
			readMap.put(blogid, title);
			user.setAccesstimes(user.getAccesstimes()+1);
			blogtext.setReadtimes(blogtext.getReadtimes()+1);
			myAppDAO.update(user);
			myAppDAO.update(blogtext);
		}
		
		/*
		 * 页面博文相关参数设置
		 */
		request.setAttribute("blogid", blogid);
		request.setAttribute("title", title);
		request.setAttribute("textcontent", blogtextcontent);
		request.setAttribute("texttype", texttype);
		request.setAttribute("time", new SimpleDateFormat("YYYY-MM-dd").format(blogtext.getLastmodify()));
		request.setAttribute("readtimes", blogtext.getReadtimes());
		/*
		 * 页面用户相关参数设置
		 */
		request.setAttribute("imgurl", user.getExp2());
		request.setAttribute("accessTimes", user.getAccesstimes());
		request.setAttribute("blognum", user.getBlognum());
		/*
		 * 文章类型相关参数设置
		 */
		request.setAttribute("textTypeName", textTypesList);
		List<Integer> typenumList = new ArrayList<Integer>(10);
		this.getTypeNumList(typenumList, textTypeManager);
		request.setAttribute("typenum", typenumList);
	}
	
	/*public static void main(String[] args) {

	}*/

}

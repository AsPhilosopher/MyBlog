package app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import app.dao_ifc.BlogTextDao;
import app.domain.TextType;
import app.ser_ifc.BlogTextService;

public class BlogTextServiceImpl implements BlogTextService {

	BlogTextDao blogTextDao;
	
	
	public BlogTextDao getBlogTextDao() {
		return blogTextDao;
	}

	public void setBlogTextDao(BlogTextDao blogTextDao) {
		this.blogTextDao = blogTextDao;
	}


	public void doTextType(HttpServletRequest request) {
		List<TextType> list = blogTextDao.getTextType();
		request.setAttribute("text_type", list);
	}

}

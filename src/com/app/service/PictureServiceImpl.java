package app.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import app.dao_ifc.PictureDao;
import app.ser_ifc.PictureService;

public class PictureServiceImpl implements PictureService {

	private PictureDao pictureDao;
	
	public PictureDao getPictureDao() {
		return pictureDao;
	}


	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}


	public void dopage(int nowpage, int eachrecord, HttpServletRequest request,
			Map<String, Object> session) {
		if(nowpage<1)
			nowpage=1;

		Map map = pictureDao.doPage(nowpage, eachrecord, session);
		List list = (List) map.get("picurl");
		request.setAttribute("totalPage", map.get("totalPage"));
		request.setAttribute("picurl", list);
		request.setAttribute("num", list.size()); 
		
		nowpage = (Integer) map.get("nowpage");
		request.setAttribute("nowpage", nowpage);
		
		int lastpage,nextpage;
		lastpage = nowpage-1;
		if(lastpage<1)
			lastpage=1;
		nextpage = nowpage+1;
//		System.out.println(map.get("totalPage")+"#####");
		if(nextpage>(Integer)map.get("totalPage"))
			nextpage=(Integer) map.get("totalPage");
		
		request.setAttribute("lastpage", lastpage);
		request.setAttribute("nextpage", nextpage);
		
//		System.out.println(request.getAttribute("nextpage") + "@@@@");
	}


	public void savePic(String picname, Map<String, Object> session) {
		pictureDao.savePic(picname, session);
	}

}

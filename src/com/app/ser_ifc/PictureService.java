package app.ser_ifc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PictureService {
	public void dopage(int nowpage,int eachrecord, HttpServletRequest request, Map<String, Object> session);
	public void savePic(String picname, Map<String, Object> session);
}

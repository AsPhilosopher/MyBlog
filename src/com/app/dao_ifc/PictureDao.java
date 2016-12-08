package app.dao_ifc;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface PictureDao {
	public Map doPage(int nowpage,int eachrecord, Map<String, Object> session);
	public void savePic(String picname, Map<String, Object> session);
}

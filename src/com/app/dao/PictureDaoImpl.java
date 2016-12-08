package app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao_ifc.PictureDao;
import app.domain.Picture;
import app.domain.User;
import app.util.SomeConstant;

@Transactional(propagation=Propagation.REQUIRED , isolation=Isolation.DEFAULT)
public class PictureDaoImpl extends HibernateDaoSupport implements PictureDao {

	public Map doPage(int nowpage, int eachrecord, Map<String, Object> session) {
		Map map = new HashMap<String, Object>(2);
		List list = new ArrayList<String>();
		
		StringBuilder hql = new StringBuilder(
				"select picurl from Picture where foruser='" + session.get("username") +"' order by pic_id DESC");
		StringBuilder countHql = new StringBuilder(
				"select count(id)  from Picture where foruser='" +session.get("username")+"'");
		
		//获得总记录数
		Long totalRecord =  (Long) this.getHibernateTemplate().find(countHql.toString()).get(0);
//		System.out.println("debug:@@@@" + "totalRecord:" + totalRecord);////
		
		Integer totalpage = (int) (totalRecord/SomeConstant.EACHPAGE_IMGNUM);
		if(totalRecord%SomeConstant.EACHPAGE_IMGNUM !=0) {
			++totalpage;
		}
		if (totalRecord==0) {
			totalpage=1;
		}
//		System.out.println("###"+totalpage +"@@@2");////
		map.put("totalPage", totalpage);
		if(nowpage>totalpage)
			nowpage=totalpage;
		map.put("nowpage", nowpage);
		//起始位置
		int fromIndex	= (int) (SomeConstant.EACHPAGE_IMGNUM * (nowpage -1));    //System.out.println(fromIndex+"&&&&&");////
		
//		Session hbsession = this.getSessionFactory().openSession();
		Session hbsession = this.getSessionFactory().getCurrentSession();
		Query hqlQuery = hbsession.createQuery(hql.toString());
		hqlQuery.setFirstResult(fromIndex);
		int totaltemp = (int) (totalRecord/1);
		
		if(nowpage==totalpage) {
			totaltemp=(int) (totalRecord%SomeConstant.EACHPAGE_IMGNUM);
		}
		hqlQuery.setMaxResults(totaltemp);
		list = hqlQuery.list();
		
//		System.out.println(list+"@@@@@");////
		
		map.put("picurl", list);
		
		return map;
	}

	public void savePic(String picname,Map<String, Object> session) {
		Picture picture = new Picture();
		String username = (String) session.get("username");
		
		picture.setPicurl(picname);
		
		String hql = "from User  where username = ?";
		User user = (User) this.getHibernateTemplate().find(hql, username).get(0);
		
		picture.setForuser(username);
		picture.setUser(user);
		picture.setUploadtime(new Date());
		
		this.getHibernateTemplate().save(picture);
//		Session session2 = this.getSessionFactory().openSession();
//		session2 = this.getSessionFactory().getCurrentSession();
//		System.out.println("hahahahahah哈哈哈哈");
//		session2.save(picture);
		
	}

}

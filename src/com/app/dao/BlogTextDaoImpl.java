package app.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import app.dao_ifc.BlogTextDao;
import app.domain.TextType;

public class BlogTextDaoImpl extends HibernateDaoSupport implements BlogTextDao {

	public List getTextType() {
		String hql = "from TextType";
		List<TextType> list = (List<TextType>) this.getHibernateTemplate().find(hql);
		return list;
	}

}

package app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED , isolation=Isolation.DEFAULT)
public class MyAppDAO extends HibernateDaoSupport {

	/*public static void main(String[] args) {
		
	}*/
	
	/*public MyAppDAO() {
		this.getSessionFactory().openSession();
	}
	
	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}*/
	
	public List findAllByHQL(String hql) {
		Session session = this.getSessionFactory().getCurrentSession();//maybe error
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	public Object findFirstByHQL(String hql) {
		List list = this.findAllByHQL(hql);
		if(null != list && list.size()>0)
			return list.get(0);
		return null;
	}
	
	public List page(String hql, int firstresult, int maxresults) {
		Session session = this.getSessionFactory().getCurrentSession();//maybe error
		Query query = session.createQuery(hql);
		query.setFirstResult(firstresult);
		query.setMaxResults(maxresults);
		return query.list();
	}
	
	public void delete(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}
	
	public void save(Object obj) {
		this.getHibernateTemplate().save(obj);
	}
	
	public List findAll(String hql, Object... values) {
		return this.getHibernateTemplate().find(hql, values);
	}
	
	public Object findFirstOne(String hql, Object... values) {
		List list = this.getHibernateTemplate().find(hql, values);
		if(null != list && list.size()>0)
			return list.get(0);
		return null;
	}
	
	public void update(Object obj) {
		this.getHibernateTemplate().update(obj);
	}

}

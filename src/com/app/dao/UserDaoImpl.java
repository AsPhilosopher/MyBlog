package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import app.dao_ifc.UserDao;
import app.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public User findByNameAndPassword(User user) {
		String hql = "from User where username =? and password = ?";
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}

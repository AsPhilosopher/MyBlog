package app.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao_ifc.UserDao;
import app.domain.User;
import app.ser_ifc.UserService;

@Transactional(propagation=Propagation.REQUIRED , isolation=Isolation.DEFAULT)
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean login(User user) {
		user = userDao.findByNameAndPassword(user);
		return (user==null) ? false:true;
	}

}

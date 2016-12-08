package app.dao_ifc;

import app.domain.User;

public interface UserDao {
	public User findByNameAndPassword(User user);
}

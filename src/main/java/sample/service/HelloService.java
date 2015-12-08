package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.dao.UserDao;
import sample.entity.User;

@Service
public class HelloService {

	@Autowired
	UserDao userDao;

	public String hello() {

		return "Hello, Spring DI !!";
	}

	public boolean login(int id, String password) {
		User user = userDao.selectById(id);
		if (user == null) {
			return false;
		}

		return password.equals(user.getPassword());

	}
}

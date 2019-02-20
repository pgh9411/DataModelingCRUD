package cafe.data.datamodeling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.data.datamodeling.mapper.UserMapper;
import cafe.data.datamodeling.vo.User;

@Service
public class StockService {
	@Autowired
	private UserMapper usermapper;

	public User login(User user) {
		User resultUser= usermapper.login(user);
		System.out.println("resultUser  login-> " + resultUser);
		return resultUser;
	}
	
	public int userAdd(User user) {
		int resultUser= usermapper.userAdd(user);
		System.out.println("resultUser  userAdd-> " + resultUser);
		return resultUser;
	}
}

package cafe.data.datamodeling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.data.datamodeling.mapper.AccountMapper;
import cafe.data.datamodeling.mapper.UserMapper;
import cafe.data.datamodeling.vo.Account;
import cafe.data.datamodeling.vo.Agency;
import cafe.data.datamodeling.vo.User;

@Service
public class StockService {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private AccountMapper accountmapper;

	public User login(User user) {
		User resultUser= usermapper.login(user);
		System.out.println("resultUser  login-> " + resultUser);
		return resultUser;
	}
	public Agency agencyCode(String user) {
		Agency resultAgencyCode = usermapper.agencyCode(user);
		return resultAgencyCode;
	}
	
	public int userAdd(User user) {
		int resultUser= usermapper.userAdd(user);
		System.out.println("resultUser  userAdd-> " + resultUser);
		return resultUser;
	}
	public int accountAdd(Account account) {
		int resultAccount = accountmapper.accountAdd(account);
		System.out.println("resultAccount  accountAdd-> " + resultAccount);
		return 0;
	}
}

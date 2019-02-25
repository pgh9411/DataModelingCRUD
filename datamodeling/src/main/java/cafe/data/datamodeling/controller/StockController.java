package cafe.data.datamodeling.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.data.datamodeling.service.StockService;
import cafe.data.datamodeling.vo.Account;
import cafe.data.datamodeling.vo.Agency;
import cafe.data.datamodeling.vo.User;

@Controller
public class StockController {
	@Autowired
	private StockService stockservice;
	@GetMapping("index")
	public String index() {
		return "index";
	}
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(HttpSession session,Model model,User user) {
		User resultUser = stockservice.login(user);
		System.out.println("resultUser 확인용-> " + resultUser);
		model.addAttribute("user", resultUser);
		session.setAttribute("userId", user.getUserId());
		System.out.println("getAgencyCode() 확인용"+resultUser.getAgencyCode());
		
		Agency resultAgencyCode = stockservice.agencyCode(resultUser.getAgencyCode());
		System.out.println("getAgencyName 확인용"+resultAgencyCode.getAgencyName());
		System.out.println("getAgencyUser 확인용"+resultAgencyCode.getAgencyUser());
		session.setAttribute("agencyName 화인용", resultAgencyCode.getAgencyName());
		session.setAttribute("agencyUser 확인용", resultAgencyCode.getAgencyUser());

		return "/index";
		
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("session 초기화 완료");
		return "/index";
	}
	//get으로 입력받은 userAdd(입력 폼) 실행한다
	@GetMapping("/userAdd")
	public String userAdd() {
		System.out.println("userAdd 폼 요청");
		return "/user/userAdd";
		//userAdd로 리턴한다
	}
	@PostMapping("/userAdd")
	public String userAdd(User user) {
		stockservice.userAdd(user);
		return "redirect:/userList";
	}
	//get으로 입력받은 accountADD(입력 폼) 실행한다
	@GetMapping("/accountAdd")
	public String accountAdd() {
		System.out.println("accountAdd 폼 요청");
		return "/account/accountAdd";
		//accountAdd로 리턴한다.
	}
	@PostMapping("/accountAdd")
	public String accountAdd(Account account) {
		System.out.println("accountAdd 액션 요청");
		stockservice.accountAdd(account);
		return "redirect:/userAdd";
	}
}

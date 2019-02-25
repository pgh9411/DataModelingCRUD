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
import cafe.data.datamodeling.vo.Order;
import cafe.data.datamodeling.vo.User;

@Controller
public class StockController {
	@Autowired
	private StockService stockservice;
	@GetMapping("index")
	//index화면 출력
	public String index() {
		return "index";
	}
	//login화면 출력(테스트용)
	@GetMapping("login")
	public String login() {
		return "login";
	}
	//login입력처리
	@PostMapping("login")
	//로그인기능 agencyCode확인기능 구현
	public String login(HttpSession session,Model model,User user) {
		//로그인성공시 받아오는 값을 resultUser객체에 담아준다. 
		User resultUser = stockservice.login(user);
		System.out.println("resultUser 확인용-> " + resultUser);
		//resultUser객체에 받아온 값을 model영역에 user객체에 담는다.
		model.addAttribute("user", resultUser);
		//user객체내에 담겨있는 UserId값을 가져와 session영역에 userId에 담는다.
		session.setAttribute("userId", user.getUserId());
		System.out.println("getAgencyCode() 확인용"+resultUser.getAgencyCode());
		//로그인 성공시 받아오는 resultUser.getAgencyCode()값을 resultAgencyCode에 담아준다.
		Agency resultAgencyCode = stockservice.agencyCode(resultUser.getAgencyCode());
		System.out.println("getAgencyName 확인용"+resultAgencyCode.getAgencyName());
		System.out.println("getAgencyUser 확인용"+resultAgencyCode.getAgencyUser());
		//위와 동일하게 세션영역에 담아준다.
		session.setAttribute("agencyName", resultAgencyCode.getAgencyName());
		session.setAttribute("agencyUser", resultAgencyCode.getAgencyUser());
		//로그인 성공시 index화면을 출력한다.
		return "/index";
		
	}
	//로그아웃해준다.
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
	@GetMapping("/orderAdd")
	public String orderAdd() {
		System.out.println("orderAdd 폼 요청");
		return "/order/orderAdd";
	}
	@PostMapping("/orderAdd")
	public String orderAdd(Order order) {
		System.out.println("orderAdd 액숀 요청");
		stockservice.orderAdd(order);
		
		return "redirect:/orderAdd";
	}
}

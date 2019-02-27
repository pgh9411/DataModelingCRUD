package cafe.data.datamodeling.controller;

import java.util.List;

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
		return "index";
	}
	//login입력처리
	@PostMapping("login")
	//로그인기능 agencyCode확인기능 구현
	public String login(HttpSession session,User user) {
		//로그인성공시 받아오는 값을 resultUser객체에 담아준다. 
		User resultUser = stockservice.login(user);
		System.out.println("resultUser 확인용-> " + resultUser);
		//resultUser객체에 받아온 값을 session영역에 user객체에 담는다.
		session.setAttribute("user", resultUser);
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
	//get으로 입력받은 userAdd(입력 폼) 실행한다(화면 테스트용)
	@GetMapping("/userAdd")
	public String userAdd() {
		System.out.println("userAdd 폼 요청");
		return "/user/userAdd";
		//userAdd로 리턴한다
	}
	//post로 입력받은 userAdd를 실행하면 입력처리를 실행한다
	@PostMapping("/userAdd")
	public String userAdd(User user) {
		//userAdd 메서드에 user정보를 입력 후 메서드를 실행한다
		//index로 이동한다
		stockservice.userAdd(user);
		return "redirect:/index";
	}
	//get으로 입력받은 accountADD(입력 폼) 실행한다 (화면 테스트용)
	@GetMapping("/accountAdd")
	public String accountAdd() {
		System.out.println("accountAdd 폼 요청");
		return "/account/accountAdd";
		//accountAdd로 리턴한다.
	}
	//post로 입력받은 accountAdd(입력처리)를 실행한다
	@PostMapping("/accountAdd")
	public String accountAdd(Account account) {
		System.out.println("accountAdd 액션 요청");
		stockservice.accountAdd(account);
		//accountAdd메서드에 계좌정보를 입력 후 추가가 되면 계좌리스트로 이동한다
		return "redirect:/accountList";
	}
	//get으로 입력받은 orderAdd(입력 폼)실행한다
	@GetMapping("/orderAdd")
	public String orderAdd(Account account,HttpSession session) {
		System.out.println("orderAdd 폼 요청");
		//orderAdd 폼이 클릭될때
		//session 객체 accountNumber에 account의 계좌번호를 세팅한다 
		//orderAdd 폼에 계좌번호를 자동으로 가져오기 위해 세션 이용한다
		session.setAttribute("accountNumber", account.getAccountNumber());
		System.out.println("accountNumber 확인");
		return "/order/orderAdd";
	}
	//post로 입력받은 orderAdd(입력처리)실행한다
	@PostMapping("/orderAdd")
	public String orderAdd(Order order) {
		System.out.println("orderAdd 액숀 요청");
		//orderAdd 메서드에 order(주문정보)를 입력 메서드 실행후 orderList로 이동한다
		stockservice.orderAdd(order);
		return "redirect:/orderList";
	}
	//get으로 입력받은 accountList(계좌리스트) 실행한다
	@GetMapping("/accountList")
	public String accountList(HttpSession session,Model model) {
		//userID에 세션에서 가져온 userId값을 담는다
		String userID = (String)session.getAttribute("userId");
		System.out.println("실행확인.....accountList");
		//List타입으로 accuntList에 accountList메서드에 userID입력하여 리턴된 계좌리스트값을 담는다
		List<Account> accountList = stockservice.accountList(userID);
		System.out.println("accountList -> " + accountList);
		//modelAccountList에 리스트 accountList값을 담는다
		model.addAttribute("modelAccountList",accountList);
		//accountList로 이동한다
		return "/account/accountList";
	}
	//get으로 입력받은 orderList(주문리스트)를 실행한다
	@GetMapping("/orderList")
	public String orderList(HttpSession session,Model model) {
		//userID에 세션에서 가져온 usreId값을 담는다
		String userID = (String)session.getAttribute("userId");
		System.out.println("실행확인.....accountList");
		//List타입으로 orderList에 orderList메서드에 userID입력 리턴된 주문리스트값을 담는다
		List<Order> orderList = stockservice.orderList(userID);
		System.out.println("orderList -> " + orderList);
		//modelOrderList에 리스트orderList 값을 담는다
		model.addAttribute("modelOrderList",orderList);
		//orderList로 이동한다
		return "/order/orderList";
}
}

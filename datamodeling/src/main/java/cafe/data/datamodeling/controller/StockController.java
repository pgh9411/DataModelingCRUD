package cafe.data.datamodeling.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.data.datamodeling.service.StockService;
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
	public String login(Model model,User user, HttpSession session) {
		User resultUser = stockservice.login(user);
		System.out.println("resultUser -> " + resultUser);
		session.setAttribute("userId", user.getUserId());
		model.addAttribute("user", resultUser);
		return "/index";
		
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("session 초기화 완료");
		return "/index";
	}
}

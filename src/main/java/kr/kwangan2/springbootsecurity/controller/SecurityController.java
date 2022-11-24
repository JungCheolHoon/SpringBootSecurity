package kr.kwangan2.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

		@GetMapping("/")
		public String index() {
			System.out.println("index 요청입니다.");
			return "/index";
		}

		@GetMapping("/member")
		public String Member() {
			System.out.println("Member 요청입니다.");
			return "/member";
		}

		@GetMapping("/manager")
		public String Manager() {
			System.out.println("Manager 요청입니다.");
			return "/manager";
		}

		@GetMapping("/admin")
		public String Admin() {
			System.out.println("Admin 요청입니다.");
			return "/admin";
		}

		@GetMapping("/login")
		public String login() {
			return "/login";
		}

		@GetMapping("/loginSuccess")
		public String loginSuccess() {
			return "/loginSuccess";
		}
		
		@GetMapping("/accessDenied")
		public String accessDenied(){
			return "/accessDenied";
		}
		
}

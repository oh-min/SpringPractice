
package org.ohm.controller;

import javax.servlet.http.HttpSession;

import org.ohm.model.LoginVO;
import org.ohm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	LoginService ls;
	
	// 회원가입
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member () {
		return "member/memberin";
	}
	
	// 회원가입서버
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String memberPost (LoginVO member) {
		System.out.println(member);
		return "board/list";
	}
	
	
	
	
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login () {
		System.out.println("aaaa");
		return "member/login";
	}
	
	// 로그인 서버
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost (HttpSession session, LoginVO member) {
		
/*		System.out.println("contorller="+member);
		System.out.println(ls.login(member));*/
		
		session.setAttribute("login", ls.login(member));
		
		if (ls.login(member)==null) {
			return "member/login";
			} else {	
				return "redirect:/list";	
			}
		
		
		}
	
	// 회원관리페이지
	// 회원정보수정 및 삭제
	
}

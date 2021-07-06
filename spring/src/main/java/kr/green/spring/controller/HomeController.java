package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;

@Controller
public class HomeController {
	 @Autowired
	    MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("home"); // home.jsp를 찾음
		mv.addObject("name", "홍길동");
//		System.out.println(memberService.getMember("abc123"));
		return mv;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv) {
		mv.setViewName("signin");
		return mv;
	}
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv, MemberVO user) {
		System.out.println(user);
		// 서비스에게 아이디와 비밀번호를 전달하면, 해당 정보가 DB에 있으면 회원 정보를 없으면 null을 반환
		MemberVO dbUser = memberService.signin(user);
		if(dbUser != null) {			
			// 작업이 다 끝난 후 URI가 /인 곳으로 넘어감
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signin");
		}
		return mv;
	}
	
}
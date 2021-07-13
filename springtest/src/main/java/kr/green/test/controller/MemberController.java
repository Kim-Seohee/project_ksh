package kr.green.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/test")
	public String test(Model model) {
		System.out.println(memberService.getEmail("abc123"));
		return "home";
	}
	
	// @RequestMapping (...method=RequestMethod.GET과 동일
	@GetMapping(value="/member/signin")
	public ModelAndView signinGet(ModelAndView mv) {
		mv.setViewName("member/signin");
		return mv;
	}
	
	// @RequestMapping (...method=RequestMethod.POST와 동일
	@PostMapping(value="/member/signin")
	public ModelAndView signinPost(ModelAndView mv, MemberVO user) {
		MemberVO dbUser = memberService.signin(user);
		if(dbUser != null) {
			mv.setViewName("redirect:/");			
		}else {
			mv.setViewName("redirect:/member/signin");
		}
		mv.addObject("user", dbUser);
		return mv;
	}
	
	@GetMapping(value="/member/signup")
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("member/signup");
		return mv;
	}
	/* 스프링 프레임워크에서 매개변수 user를 넣으면 객체가 생성된 후 화면에서 전달한 name과 일치하는 변수명을 가진
	 * 멤버변수의 setter를 이용하여 값을 재설정
	 * 일반적으로 매개변수가 객체를 자동으로 생성하는 것은 아님!!
	 * */
	@PostMapping(value="/member/signup")
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		boolean isSignup = memberService.signup(user);
		if(isSignup) {
			mv.setViewName("redirect:/");			
		}else {
			mv.setViewName("redirect:/member/signup");		
		}
		return mv;
	}
}

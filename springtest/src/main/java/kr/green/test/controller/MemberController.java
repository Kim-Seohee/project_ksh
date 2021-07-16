package kr.green.test.controller;

import javax.servlet.http.HttpServletRequest;

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
		mv.setViewName("/template/member/signin");
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
		mv.setViewName("/template/member/signup");
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
	
	@GetMapping(value="/member/mypage")
	public ModelAndView mypageGet(ModelAndView mv) {
		mv.setViewName("/template/member/mypage");
		return mv;
	}
	
	@PostMapping(value="/member/mypage")
	public ModelAndView mypagePost(ModelAndView mv, MemberVO user, HttpServletRequest request) {
		// user: 화면에서 보낸 회원 정보, 정상적이라면 바로 수정해도 되지만 개발자 도구를 이용하여 잘못된 정보를 보낼 수 있기 때문에 바로 수정하면 안된다.
		MemberVO sessionUser = memberService.getMember(request);
		MemberVO updatedUser = memberService.updateMember(user, sessionUser);
		// sessionUser는 현재 로그인된 회원 정보
		// updatedUser는 업데이트된 회원 정보로 user의 아이디와 sessionUser의 아이디가 일치하지 않으면 null, 일치하면 업데이트된 회원 정보 반환
		
		if(updatedUser != null) {
			request.getSession().setAttribute("user", updatedUser);
		}
		
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
	
	@GetMapping(value="/member/signout")
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		mv.setViewName("redirect:/");
		return mv;
	}
}

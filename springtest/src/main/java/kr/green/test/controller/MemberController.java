package kr.green.test.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	private JavaMailSender mailSender;
	
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
//		System.out.println(user);
		MemberVO dbUser = memberService.signin(user);
		if(dbUser != null) {
			mv.setViewName("redirect:/");			
		}else {
			mv.setViewName("redirect:/member/signin");
		}
		mv.addObject("user", dbUser);
//		System.out.println(dbUser);
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
		//request에 있는 세션 안에 있는 로그인한 회원 정보를 가져옴
		MemberVO sessionUser = memberService.getMember(request);
		//세션에 로그인한 회원 정보가 있고, 세션에 있는 아이디와 수정할 아이디가 같으면 회원 정보 수정함
		if(sessionUser != null && sessionUser.getId().equals(user.getId())) {
			MemberVO updatedUser = memberService.updateMember(user);
			if(updatedUser != null) {
				request.getSession().setAttribute("user", updatedUser);
			}
		}
		mv.setViewName("redirect:/member/mypage");
		return mv;
	}
	
	@GetMapping(value="/member/signout")
	public ModelAndView signoutGet(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(user != null) {
			request.getSession().removeAttribute("user");
			request.getSession().invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				memberService.keepLogin(user.getId(), "none", new Date());
			}
		}
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@ResponseBody
	@GetMapping(value = "/member/idcheck/{id}")
	public String memberIdcheckGet(@PathVariable("id") String id) {
		MemberVO user = memberService.getMember(id);
		String res = user != null? "IMPOSSIBLE" : "POSSIBLE";  
		return res;
	}
	
	@GetMapping("/find/pw")
	public ModelAndView findPwGet(ModelAndView mv) {
		mv.setViewName("/template/main/findpw");
		return mv;
	}
	@ResponseBody // ajax
	@GetMapping("/find/pw/{id}")
	public String findPwIdGet(@PathVariable("id") String id) {
		MemberVO user = memberService.getMember(id);
		if(user == null)
			return "FAIL";
		try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");
	        //임시 비밀번호 발급
	        String newPw = newPw();
	        //새 비밀번호를 DB에 저장
	        user.setPw(newPw);
	        memberService.updateMember(user);
	        
	        messageHelper.setFrom("suhee9305@gmail.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(user.getEmail());     // 받는사람 이메일
	        messageHelper.setSubject("새 비밀번호를 발급합니다."); // 메일제목은 생략이 가능하다
	        messageHelper.setText("","발급된 새 비밀번호는 <h3>" + newPw + "</h3>입니다.");  // 메일 내용

	        mailSender.send(message);
	        return "SUCCESS";
	    } catch(Exception e){
	        System.out.println(e);
	    }
		return "FAIL";
	}
	@GetMapping("/find/id")
	public ModelAndView findIdGet(ModelAndView mv) {
		mv.setViewName("/template/main/findid");
		return mv;
	}
	@ResponseBody
	@PostMapping("/find/id")
	public String findIdPost(String email) {
		
		ArrayList<MemberVO> userList = memberService.getMemberByEmail(email);
		
		if(userList == null || userList.size() == 0)
			return "FAIL";
		try {
			ArrayList<String> idList = new ArrayList<String>();
			for(MemberVO user : userList) {
				idList.add(user.getId());
			}
			System.out.println(idList);
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");
	        
	        messageHelper.setFrom("stajun@gmail.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(email);     // 받는사람 이메일
	        messageHelper.setSubject("가입된 아이디입니다."); // 메일제목은 생략이 가능하다
	        messageHelper.setText("","가입된 아이디는 <b>" + idList.toString().replaceAll("[\\[\\]]","") + "</b>입니다.");  // 메일 내용

	        mailSender.send(message);
	        return "SUCCESS";
	    } catch(Exception e){
	        System.out.println(e);
	    }
		return "FAIL";
	}
	//8자리의 숫자 or 영어대소문자로 된 비밀번호
	private String newPw() {
		//랜덤숫자 : 0~9 => 문자열 : 0~9
		//랜덤숫자 : 10~35 => 문자열 : a~z
		//랜덤숫자 : 36~61 => 문자열 : A~Z
		//12 =>c
		String pw="";
		int max = 61, min = 0;
		for(int i=0; i<8; i++) {
			int r = (int)(Math.random()*(max-min+1)) + min;
			//int r = (int)(Math.random()*62);
			if(r <= 9) {
				pw += r;
			}else if(r<=35) {
				pw += (char)('a'+(r-10));
			}else {
				pw += (char)('A'+(r-36));
			}
		}
		return pw;
	}
}

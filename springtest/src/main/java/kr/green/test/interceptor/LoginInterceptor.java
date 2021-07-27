package kr.green.test.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;


public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	MemberService memberService;
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
//	    System.out.println(user);
	    if(user != null) {
	        HttpSession session = request.getSession();
	        
	        if(user.getUseCookie() != null) {
	        	Cookie loginCookie = new Cookie("loginCookie", session.getId());
	        	loginCookie.setPath("/");
	        	int day = 7;
	        	int amount = 60 * 60 * 24 * day;
	        	loginCookie.setMaxAge(amount);
	        	response.addCookie(loginCookie);
	        	Date session_limit = new Date(System.currentTimeMillis() + (1000 * amount));
	        	memberService.keepLogin(user.getId(), session.getId(), session_limit);
	        }
	        session.setAttribute("user", user);
	    }
	}
}

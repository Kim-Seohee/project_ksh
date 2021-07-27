package kr.green.test.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	MemberService memberService;
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
//		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(user == null) {
//			MemberVO user = memberService.checkLoginBefore(loginCookie.getValue());
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				user = memberService.checkLoginBefore(loginCookie.getValue());
//				session.setAttribute("user", user);
				if(user != null) {
					session.setAttribute("user", user);
				}
			}
		}
		return true; // 원래 가려던 url로 감
	}
}

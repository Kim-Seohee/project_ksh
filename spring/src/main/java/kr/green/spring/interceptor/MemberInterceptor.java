package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user"); // 유저 정보가 있는지만 확인하면 됨
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/signin"); // 유저 정보가 없으면 로그인 페이지로 보냄
			return false; // 원래 가려던 url로 가지 않음
		}
		return true; // 원래 가려던 url로 감
	}
}
package kr.green.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.green.study.service.MemberService;
import kr.green.study.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		// 세션에 회원 정보가 있으면 자동 로그인 기능을 활용할 필요가 없고, 없으면 자동 로그인을 해야하는지 확인
		if(user == null) {
			// loginCookie 정보를 가져와서 있으면 자동 로그인을 시도하고 없으면 안한다.
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			// 자동 로그인 쿠키 정보가 있으면 자동 로그인을 해야 함
			if(loginCookie != null) {
				user = memberService.getMemberByCookie(loginCookie.getValue());
				if(user != null)
					session.setAttribute("user", user);
			}
		}
		return true; // 작업 후 원래 가려던 컨트롤러로 간다, false이면 원래 가려던 컨트롤러로 가지 않는다.
	}
}

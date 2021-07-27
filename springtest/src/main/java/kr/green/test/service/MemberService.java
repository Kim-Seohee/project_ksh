package kr.green.test.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.vo.MemberVO;

public interface MemberService {
    public String getEmail(String id);

	public MemberVO signin(MemberVO user);

	public boolean signup(MemberVO user);

	public MemberVO getMember(HttpServletRequest r);

	public MemberVO updateMember(MemberVO user, MemberVO sessionUser);

	public MemberVO getMember(String id);

	public void keepLogin(String id, String session_id, Date session_limit);

	public MemberVO checkLoginBefore(String session_id);

}

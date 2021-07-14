package kr.green.test.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.vo.MemberVO;

public interface MemberService {
    public String getEmail(String id);

	public MemberVO signin(MemberVO user);

	public boolean signup(MemberVO user);

	public MemberVO getMember(HttpServletRequest r);

	public MemberVO updateMember(MemberVO user, MemberVO sessionUser);
}

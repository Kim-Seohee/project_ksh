package kr.green.test.service;

import kr.green.test.vo.MemberVO;

public interface MemberService {
    public String getEmail(String id);

	public MemberVO signin(MemberVO user);

	public boolean signup(MemberVO user);
}

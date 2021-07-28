package kr.green.study.dao;

import kr.green.study.vo.MemberVO;

public interface MemberDAO {

	void insertMember(MemberVO user); // 매개변수가 하나일 때는 param을 생략할 것임

}

package kr.green.study.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.study.dao.MemberDAO;
import kr.green.study.vo.MemberVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImp implements MemberService {

	MemberDAO memberDao;
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO user) {
		if(user == null)
			return false;
		// 아이디 유효성 검사
		
		// 비밀번호 유효성 검사
		
		// 이메일 유효성 검사
		
		// 이름 유효성 검사
		
		// 성별 유효성 검사
		
		// 비밀번호 암호화
		String encPw = passwordEncoder.encode(user.getPw());
		user.setPw(encPw);
		memberDao.insertMember(user);
		return true;
	}
}

package kr.green.test.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;
@Service
public class MemberServiceImp implements MemberService {
	@Autowired
    MemberDAO memberDao;
	@Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Override
    public String getEmail(String id) {
        return memberDao.getEmail(id);
    }

	@Override
	public MemberVO signin(MemberVO user) {
		if(user == null || user.getId() == null || user.getId().trim().length() == 0
			|| user.getPw() == null || user.getPw().trim().length() == 0) {
			return null;			
		}
		MemberVO dbUser = memberDao.getMember(user.getId());
		if(dbUser == null || !passwordEncoder.matches(user.getPw(), dbUser.getPw())) {
			return null;
		}
		return dbUser;
	}

	@Override
	public boolean signup(MemberVO user) {
		// 필수 항목 체크
		if( user.getId() == null || user.getId().trim().length() == 0 || // null체크는 nullpointerexception 방지를 위해서 하는것임, 조건문에서 or연산자 앞의 조건이 참인 경우 뒤의 조건은 체크하지 않음
			user.getPw() == null ||user.getPw().trim().length() == 0 ||
			user.getName() == null ||user.getName().trim().length() == 0 ||
			user.getEmail() == null ||user.getEmail().trim().length() == 0)
				return false;
		// 정규표현식 체크(나중에)
		
		
		if(user == null || memberDao.getMember(user.getId()) != null) {
			return false;
		}
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);
		memberDao.signup(user);
		return true;
	}

	@Override
	public MemberVO getMember(HttpServletRequest r) {
		if(r == null || r.getSession() == null)
			return null;
		return (MemberVO) r.getSession().getAttribute("user");
	}

	@Override
	public MemberVO updateMember(MemberVO user, MemberVO sessionUser) {
		if(user == null || sessionUser == null || user.getId() == null || !user.getId().equals(sessionUser.getId())) {
			return null;
		}
		if(user.getPw() != null && user.getPw().trim().length() != 0) {
			String encodePw = passwordEncoder.encode(user.getPw());
			sessionUser.setPw(encodePw);
		}
		sessionUser.setEmail(user.getEmail());
		sessionUser.setGender(user.getGender());
		sessionUser.setName(user.getName());
		memberDao.updateMember(sessionUser);
		return sessionUser;
	}
	
	@Override
	public MemberVO getMember(String id) {
		// 다오에게 아이디를 주면서 회원 정보를 가져오라고 시킴
		// 가져온 회원 정보를 전달
//		if(id == null) {
//			return null;
//		} 굳이 필요 없는 코드
		return memberDao.getMember(id);
	}
}

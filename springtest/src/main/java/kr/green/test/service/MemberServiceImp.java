package kr.green.test.service;

import java.util.ArrayList;
import java.util.Date;

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
		dbUser.setUseCookie(user.getUseCookie());
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
	public MemberVO updateMember(MemberVO user) {
		//user : 화면에서 입력한 회원 정보
		//dbUser : DB에서 가져온 회원 정보
		//다오에게 아이디를 주면서 기존 회원 정보를 가져오라고 시킴
		if(user == null) {
			return null;
		}
		MemberVO dbUser = memberDao.getMember(user.getId());
		//일치하는 회원 정보가 없으면 0을 반환
		if(dbUser == null) {
			return null;
		}
		//기존 회원 정보 중 성별, 이메일을 수정할 회원 정보의 성별, 이메일로 변경
		dbUser.setGender(user.getGender());
		dbUser.setEmail(user.getEmail());
		
		//수정할 회원 정보에 비밀 번호가 있으면, 기존 회원 정보의 비밀번호를 변경
		if(user.getPw() != null && !user.getPw().equals("")) {
			String encodePw = passwordEncoder.encode(user.getPw());
			dbUser.setPw(encodePw);
		}
		
		//다오에게 수정할 회원 정보를 주면서 변경하라고 시킴
		if(memberDao.updateMember(dbUser) == 0)
			return null;
		return dbUser;
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

	@Override
	public void keepLogin(String id, String session_id, Date session_limit) {
		if(id == null || session_limit == null) {
			return;
		}
		memberDao.keepLogin(id, session_id, session_limit);
		
	}

	@Override
	public MemberVO checkLoginBefore(String session_id) {
		if(session_id == null)
			return null;
		return memberDao.getMemberBySessionId(session_id);
	}

	@Override
	public ArrayList<MemberVO> getMemberByEmail(String email) {
		if(email == null)
			return null;
		return memberDao.gemMemberByEmail(email);
	}
}

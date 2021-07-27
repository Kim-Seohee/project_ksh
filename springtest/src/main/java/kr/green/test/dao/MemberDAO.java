package kr.green.test.dao;
 
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.test.vo.MemberVO;
 
public interface MemberDAO {
    public String getEmail(@Param("id")String id);

	public MemberVO getMember(@Param("id")String id);

	public void signup(@Param("user")MemberVO user);

	public int updateMember(@Param("member")MemberVO sessionUser);

	public void keepLogin(@Param("id")String id, @Param("session_id")String session_id, @Param("session_limit")Date session_limit);

	public MemberVO getMemberBySessionId(@Param("session_id")String session_id);

	public ArrayList<MemberVO> gemMemberByEmail(@Param("email")String email);
}
package kr.green.test.service;

import java.util.ArrayList;

import org.springframework.stereotype.*;

import kr.green.test.dao.ReplyDAO;
import kr.green.test.pagination.Criteria;
import kr.green.test.vo.MemberVO;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService{
	private ReplyDAO replyDao;
	
	@Override
	public int insertReply(ReplyVO reply) {
		if(reply.getRp_me_id() == null || reply.getRp_me_id().length() == 0) {
			return 0;
		}
		replyDao.insertReply(reply);
		return 1;
	}

	@Override
	public ArrayList<ReplyVO> getReplyList(Integer num, Criteria cri) {
		if(num == null) {
			return null;
		}
		return replyDao.getReplyList(num, cri);
	}

	@Override
	public int getTotalCount(Integer num) {
		return replyDao.getTotalCount(num);
	}

	@Override
	public String updateReply(ReplyVO reply, MemberVO user) {
		if(reply == null || reply.getRp_num() <= 0) {
			return "NO_REPLY_FAIL";
		}
		if(user == null || user.getId() == null) {
			return "NO_USER_FAIL";
		}
		ReplyVO rvo = replyDao.getReply(reply.getRp_num());
		if(rvo == null) {
			return "NO_REPLY_FAIL";
		}
		if(!rvo.getRp_me_id().equals(user.getId())) {
			return "NO_REPLYER_FAIL";
		}
		rvo.setRp_content(reply.getRp_content());
		replyDao.updateReply(rvo);
		return "MODIFY_SUCCESS";
	}

}

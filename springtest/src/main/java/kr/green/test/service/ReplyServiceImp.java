package kr.green.test.service;

import org.springframework.stereotype.*;

import kr.green.test.dao.ReplyDAO;
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

}

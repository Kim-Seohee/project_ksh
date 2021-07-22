package kr.green.test.service;

import org.springframework.stereotype.Service;

import kr.green.test.dao.ReplyDAO;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService{
	private ReplyDAO replyDao;
	
	@Override
	public void insertReply(ReplyVO reply) {
		replyDao.insertReply(reply);
	}

}

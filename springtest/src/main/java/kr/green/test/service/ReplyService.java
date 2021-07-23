package kr.green.test.service;

import java.util.ArrayList;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.MemberVO;
import kr.green.test.vo.ReplyVO;

public interface ReplyService {

	int insertReply(ReplyVO reply);

	ArrayList<ReplyVO> getReplyList(Integer num, Criteria cri);

	int getTotalCount(Integer num);

	String updateReply(ReplyVO reply, MemberVO user);

}

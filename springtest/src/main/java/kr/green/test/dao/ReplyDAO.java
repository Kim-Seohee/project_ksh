package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(@Param("reply")ReplyVO reply);

	ArrayList<ReplyVO> getReplyList(@Param("num")Integer num, @Param("cri")Criteria cri);

	int getTotalCount(@Param("num")Integer num);

	ReplyVO getReply(@Param("num")int rp_num);

	void updateReply(@Param("reply")ReplyVO rvo);

}

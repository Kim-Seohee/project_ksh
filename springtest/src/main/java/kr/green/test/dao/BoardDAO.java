package kr.green.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.RecommendVO;

public interface BoardDAO {

	ArrayList<BoardVO> getBoardList(@Param("cri")Criteria cri);

	BoardVO getBoard(@Param("num")Integer num);

	int updateBoard(@Param("board")BoardVO board);

	void insertBoard(@Param("board")BoardVO board);

	int getTotalCount(@Param("cri")Criteria cri);

	void insertFile(@Param("file")FileVO fileVo);

	ArrayList<FileVO> getFileVOList(@Param("num")Integer num);

	void deleteFileVO(@Param("num")int num);

	RecommendVO getRecommend(@Param("id")String id, @Param("board")int board);

	void insertRecommend(@Param("id")String id, @Param("board")int board, @Param("state")int state);

	void updateRecommend(@Param("rvo")RecommendVO rvo);
}

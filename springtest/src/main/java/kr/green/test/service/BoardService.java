
package kr.green.test.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.FileVO;
import kr.green.test.vo.MemberVO;
import kr.green.test.vo.RecommendVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer num);

	int updateViews(Integer num);

	void insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) ;

	int deleteBoard(Integer num, MemberVO user);

	int updateBoard(BoardVO board, MemberVO user, MultipartFile[] files, Integer[] filenums);

	int getTotalCount(Criteria cri);

	ArrayList<FileVO> getFileVOList(Integer num);

	ResponseEntity<byte[]> downloadFile(String fileName) throws IOException;

	int updateRecommend(MemberVO user, int board, int state);

	RecommendVO getRecommend(Integer num, MemberVO user);

}
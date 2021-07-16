package kr.green.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.service.MemberService;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/list")
	public ModelAndView boardList(ModelAndView mv, String msg, Criteria cri) {
		cri.setPerPageNum(3);
		// 현재 페이지 정보(검색타입, 검색어)에 대한 총 게시글 수를 가져와야 함
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 2, cri);

		// 서비스에게 모든 게시글을 가져오라고 시킴
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		// 화면에 모든 게시글을 전송
		mv.addObject("list", list);
		mv.addObject("msg", msg);
		mv.addObject("pm", pm);
		mv.setViewName("/template/board/list");
		return mv;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num, String msg) {
//		log.info("test");
//		log.info(num);
		boardService.updateViews(num);
		// 서비스에게 게시글 번호를 주고 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(num);
		// log.info(board);
		// 화면에 게시글을 출력
		mv.addObject("board", board);
		mv.addObject("msg", msg);
		mv.setViewName("/template/board/detail");
		return mv;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/template/board/register");
		return mv;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest r, MultipartFile[] files) {
		MemberVO user = memberService.getMember(r);
		boardService.insertBoard(board, user, files);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num) {
		BoardVO board = boardService.getBoard(num);
		mv.addObject("board", board);
		mv.setViewName("/template/board/modify");
		return mv;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board, HttpServletRequest r) {
		MemberVO user = memberService.getMember(r);
		int res = boardService.updateBoard(board, user);
		String msg = "";
		mv.setViewName("redirect:/board/detail");
		if(res == 1) {
			msg = board.getNum() + "번 게시글이 수정되었습니다.";
		}else if(res == 0) {
			msg = "없는 게시글입니다.";
		}else if(res == -1) {
			msg = "잘못된 접근입니다.";
			mv.setViewName("redirect:/board/list");
		}
		mv.addObject("msg", msg);
		mv.addObject("num", board.getNum());
		return mv;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView boardDeletePost(ModelAndView mv, Integer num, HttpServletRequest r) {
		MemberVO user = memberService.getMember(r);
		int res = boardService.deleteBoard(num, user);
		if(res == 1) {
			mv.addObject("msg", num + "번 게시글을 삭제했습니다.");
		}else if(res == 0) {
			mv.addObject("msg", "게시글이 없거나 이미 삭제되었습니다.");
		}else if(res == -1) {
			mv.addObject("msg", "잘못된 접근입니다.");
		}
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		ResponseEntity<byte[]> entity = boardService.downloadFile(fileName);
	    return entity;
	}
}

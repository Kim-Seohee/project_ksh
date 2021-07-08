package kr.green.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.BoardService;
import kr.green.test.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list")
	public ModelAndView boardList(ModelAndView mv) {
		// 서비스에게 모든 게시글을 가져오라고 시킴
		ArrayList<BoardVO> list = boardService.getBoardList();
		// 화면에 모든 게시글을 전송
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) {
//		log.info("test");
//		log.info(num);
		boardService.updateViews(num);
		// 서비스에게 게시글 번호를 주고 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(num);
		log.info(board);
		// 화면에 게시글을 출력
		mv.addObject("board", board);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("board/register");
		return mv;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board) {
		boardService.insertBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}

}

package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	@RequestMapping(value="/board/list")
	public ModelAndView boardList(ModelAndView mv) {
		//서비스에게 모든 게시글을 가져오라고 시킴
		ArrayList<BoardVO> list = boardService.getBoardList();
		//화면에 모든 게시글을 전송
		mv.addObject("list",list);
		if(list != null) {
			for(BoardVO tmp : list) {
				System.out.println(tmp);
			}
		}
		mv.setViewName("board/list");
		return mv;
	}
	@RequestMapping(value="/board/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer num) { // int는 null값을 다루지 못하기 때문에 Integer를 쓴다.
		// 서비스에게 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(num);
		// 가져온 게시글을 화면에 전달, 화면으로 보낼 이름은 board로
		mv.addObject("board", board); // 괄호 안은 화면에서 쓸 이름, 오른쪽은 실제 데이터
		mv.setViewName("board/detail");
		return mv;
	}
}
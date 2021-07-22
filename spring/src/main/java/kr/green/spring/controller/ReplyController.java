package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.MemberService;
import kr.green.spring.service.ReplyService;
import kr.green.spring.vo.MemberVO;
import kr.green.spring.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController // 모든 댓글은 ajax로 처리
@AllArgsConstructor // 얘를 쓰면 autowired 안 써도 됨
public class ReplyController {

	private ReplyService replyService;
	private MemberService memberService;
	
	@PostMapping(value="reply/ins")
	public String replyInsPost(@RequestBody ReplyVO reply) {
//		System.out.println(reply);
		replyService.insertReply(reply);
		return "ok";
	}
	@GetMapping(value="reply/list/{num}/{page}")
	public HashMap<String, Object> replyListGet(@PathVariable("num") Integer num, @PathVariable("page") Integer page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(2);
		ArrayList<ReplyVO> list = replyService.getReplyList(num, cri);
		// 페이지메이커 만들기
		PageMaker pm = new PageMaker();
		pm.setDisplayPageNum(2);
		pm.setCriteria(cri);
		int totalCount = replyService.getTotalCount(num);
		pm.setTotalCount(totalCount);
		pm.calcData();
		map.put("pm", pm);
		System.out.println(pm);
		map.put("list", list);
		return map;
	}
	@PostMapping(value="reply/del")
	public String replyDelPost(@RequestBody ReplyVO reply, HttpServletRequest r) {
		MemberVO user = memberService.getMember(r);
//		System.out.println(reply);
		return replyService.deleteReply(reply, user);
	}
	@PostMapping(value="reply/mod")
	public String replyModPost(@RequestBody ReplyVO reply, HttpServletRequest r) {
		MemberVO user = memberService.getMember(r);
		return replyService.updateReply(reply, user);
	}
}

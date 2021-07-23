package kr.green.test.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.ReplyService;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController // 모든 댓글은 ajax로 처리(실제 데이터를 리턴)
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService replyService;
	
	@PostMapping(value="reply/ins")
	public String replyInsPost(@RequestBody ReplyVO reply) {
		return replyService.insertReply(reply) == 0 ? "FAIL" : "OK";
	}
	
	@GetMapping(value="reply/list/{num}/{page}")
	public HashMap<String, Object> replyListGet(@PathVariable("num") Integer num, @PathVariable("page") Integer page){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(3);
		ArrayList<ReplyVO> list = replyService.getReplyList(num, cri);
		PageMaker pm = new PageMaker();
		pm.setDisplayPageNum(3);
		pm.setCriteria(cri);
		int totalCount = replyService.getTotalCount(num);
		pm.setTotalCount(totalCount);
		pm.calcData();
		map.put("pm", pm);
		map.put("replyList", list);
		return map;
	}
}

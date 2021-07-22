package kr.green.test.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.green.test.service.ReplyService;
import kr.green.test.vo.ReplyVO;
import lombok.AllArgsConstructor;

@RestController // 모든 댓글은 ajax로 처리
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService replyService;
	
	@PostMapping(value="reply/ins")
	public String replyInsPost(@RequestBody ReplyVO reply) {
		System.out.println(reply);
		replyService.insertReply(reply);
		return "ok";
	}
}

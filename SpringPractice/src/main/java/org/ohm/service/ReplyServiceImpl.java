package org.ohm.service;

import java.util.ArrayList;

import org.ohm.mapper.ReplyMapper;
import org.ohm.model.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyMapper rm;
	
	// 댓글 쓰기를 위한 구현
	public int rewrite(ReplyVO reply) {
		return rm.rewrite(reply);
	}
	// 댓글 목록 리스트를 위한 구현
	public ArrayList<ReplyVO> list(int bno){
		return rm.list(bno);
	}
}

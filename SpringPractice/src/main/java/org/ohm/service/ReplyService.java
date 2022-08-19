package org.ohm.service;

import java.util.ArrayList;

import org.ohm.model.ReplyVO;

// 댓글 관련 서비스
public interface ReplyService {
	// 댓글 쓰기를 위한 설계
	public int rewrite(ReplyVO reply);
	// 댓글 목록 리스트를 위한 설계
	public ArrayList<ReplyVO> list(int bno);
}

package org.ohm.service;

import java.util.ArrayList;

import org.ohm.model.AttachFileVO;
import org.ohm.model.BoardVO;
import org.ohm.model.CriteriaVO;

public interface BoardService {

	// 글쓰기 설계		 (BoadVO : 게시판정보+파일업로드정보)
	public void write(BoardVO board);
	
	// 글 목록 리스트 설계
	public ArrayList<BoardVO> list(CriteriaVO cri);
	
	// 글 상세 내용 보기 설계
	public BoardVO detail(BoardVO board);
	
	// 글 수정 설계
	public void modify(BoardVO board);
	
	// 글 삭제 설계
	public void remove(BoardVO board);
	
	// board테이블 전체건수 설계
	public int total(CriteriaVO cri);
	
	// 첨부파일 조회 설계
	public ArrayList<AttachFileVO> attachlist(int bno);
}

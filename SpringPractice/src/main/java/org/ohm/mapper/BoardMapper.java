package org.ohm.mapper;

import java.util.ArrayList;

import org.ohm.model.BoardVO;

public interface BoardMapper<CriteriaVO> {

	// 글쓰기에 해당되는 DB작업 설계
	public void write(BoardVO board);
	
	// 게시글 목록 리스트에 해당되는 DB작업 설계
	public ArrayList<BoardVO> list(CriteriaVO cri);
	
	// 목록리스트에서 제목을 클릭한 후 상세내용을 조회하는 DB작업 설계
	public BoardVO detail(BoardVO board);
	
	// 목록리스트에서 제목을 클릭한 후 상세내용을 조회할 때 조회수도 같이 update하는 DB작업 설계
	public void cntup(BoardVO board);
	
	// 상세내용에 해당되는 내용을 수정하는 DB설계 작업
	public void modify (BoardVO board);
	
	// 상세내용에 해당되는 내용을 삭제하는 DB설계 작업
	public void remove (BoardVO board);
	
	// 전체건수 해당되는 내용을 삭제하는 DB설계 작업
	public int total(CriteriaVO cri);
}

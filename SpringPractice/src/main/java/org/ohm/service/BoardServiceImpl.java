package org.ohm.service;

import java.util.ArrayList;

import org.ohm.mapper.BoardMapper;
import org.ohm.model.BoardVO;
import org.ohm.model.CriteriaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

	@Service
	public class BoardServiceImpl implements BoardService {
		
		@Autowired
		BoardMapper<CriteriaVO> bm;
		
		// BoardService 에서 설계되어진 write 추상메서드를 구현
		public void write(BoardVO board) {
			// BoardMapper에 있는 write메서드를 호출
			// 메서드의 매개변수를 통해 BoardVO 값을
			// BoardMapper의 write 메서드로 전달
			bm.write(board);
		}
		
	
		// BoardService에서 설계되어진 list추상메서드를 구현
		public ArrayList<BoardVO> list(CriteriaVO cri) {
			return bm.list(cri);
		}
	
		// BoardService에서 설계되어진 detail추상메서드를 구현
		@Transactional
		public BoardVO detail(BoardVO board) {
			// 상세페이지 조회 할 때
			// 조회수 + 1 update
			bm.cntup(board);
			return bm.detail(board);
		}
	
		
		// BoardService에서 설계되어진 modify 추상메서드를 구현
		public void modify(BoardVO board) {
			bm.modify(board);
		}
		
		
		// BoardService에서 설계되어진 remove 추상메서드를 구현
		public void remove(BoardVO board) {
			bm.remove(board);
		}
		
		// BoardService에서 설계되어진 total 추상메서드를 구현
		public int total(CriteriaVO cri) {
			return bm.total(cri);
		}
		
	
}

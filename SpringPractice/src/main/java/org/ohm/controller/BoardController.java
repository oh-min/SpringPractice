package org.ohm.controller;

import org.ohm.model.BoardVO;
import org.ohm.model.CriteriaVO;
import org.ohm.model.PageVO;
import org.ohm.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {
	
	// 비즈니스 모델을 컨트롤러에 연결하기
	@Autowired
	BoardService bs;

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	// 게시판 목록 리스트
	public String list (Model model, CriteriaVO cri) {
		// list.jsp 실행 할 때 select 된 결과를 가져와라
		model.addAttribute("list", bs.list(cri));
		// list.jsp 실행 할 때 PageVO에 저장되어 이쓴 데이터를 가져와라
		//                 생성자 호출(매개변수가 2개인 생성자)
		// board테이블(게시판테이블)에 전체 건수(select해서)를 아래에 190 대신 삽입
		int total = bs.total(cri);
		model.addAttribute("paging", new PageVO(cri, total));
		return "/board/list";
	}
	

	// 게시판 상세 페이지
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	// public String detail(int bno){
	public String detail (BoardVO board, Model model) {
		System.out.println(board);
		// bs.detail(bno);
		model.addAttribute("detail", bs.detail(board));
		return "board/detail";
	}
	
	// 게시판 수정
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public String modify (BoardVO board, RedirectAttributes rttr) {
		bs.modify(board);
		rttr.addAttribute("bno", board.getBno());
		// 수정하고 난 뒤 확인을 위해 상세페이지로 화면이동
		return "redirect:/detail";
	}
	
	// 게시판 삭제
	@RequestMapping(value = "/board/remove", method = RequestMethod.POST)
	public String remove (BoardVO board) {
		bs.remove(board);
		return "redirect:/list";
	}
	
	// 게시판 글쓰기 페이지 (화면)
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write () {
		return "board/write";
	}
	
	// 게시판 글쓰기 페이지 (insert 이루어짐)
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost (BoardVO board) {
		// 비즈니스 영역 연결한 후 BoardService
		bs.write(board);
		return "redirect:/board/list";
	}	
	
}

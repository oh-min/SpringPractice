package org.ohm.mapper;

import java.util.ArrayList;

import org.ohm.model.AttachFileVO;

public interface BoardAttachMapper {
	// 글쓰기할 당시에 첨부파일DB작업 설계
	public void insert(AttachFileVO attach);
	// 해당게시물의 첨부파일 조회
	public ArrayList<AttachFileVO> attachlist(int bno);
}

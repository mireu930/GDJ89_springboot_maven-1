package com.mireu.app.board;

import java.util.List;

import com.mireu.app.board.qna.QnaVO;

public interface BoardService {

	public List<BoardVO> getList() throws Exception;
	public QnaVO getDetail(QnaVO qnaVO) throws Exception;
	public int add(QnaVO qnaVO) throws Exception;
}

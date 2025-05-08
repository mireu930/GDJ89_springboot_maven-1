package com.mireu.app.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mireu.app.board.qna.QnaVO;

public interface BoardDAO {

	public List<BoardVO> getList() throws Exception;
	public QnaVO getDetail(QnaVO qnaVO) throws Exception;
	public int add(QnaVO qnaVO) throws Exception;
}

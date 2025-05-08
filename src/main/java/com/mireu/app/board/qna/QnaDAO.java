package com.mireu.app.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.mireu.app.board.BoardDAO;
import com.mireu.app.board.BoardVO;

@Mapper
public interface QnaDAO extends BoardDAO {
	
	public int reply(QnaVO qnaVO) throws Exception;
	public int updateStep(QnaVO qnaVO) throws Exception;
	public int refUpdate(QnaVO qnaVO) throws Exception;
}

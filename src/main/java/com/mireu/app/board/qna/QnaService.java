package com.mireu.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mireu.app.board.BoardService;
import com.mireu.app.board.BoardVO;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	

	@Override
	public List<BoardVO> getList() throws Exception {
		List<BoardVO> ar = qnaDAO.getList();
		return ar;
	}
	
	@Override
	public QnaVO getDetail(QnaVO qnaVO) throws Exception {
		qnaVO = qnaDAO.getDetail(qnaVO);
		return qnaVO;
	}
	
	@Override
	public int add(QnaVO qnaVO) throws Exception {
		int result = qnaDAO.add(qnaVO);
		result = qnaDAO.refUpdate(qnaVO);
		return result;
	}
	
	public int reply(QnaVO qnaVO) throws Exception {
		
		QnaVO parent = qnaDAO.getDetail(qnaVO);
		
		qnaVO.setBoardRef(parent.getBoardRef());
		qnaVO.setBoardStep(parent.getBoardStep()+1);
		qnaVO.setBoardDepth(parent.getBoardDepth()+1);
		
		int result =qnaDAO.updateStep(parent);
		
		 result = qnaDAO.reply(qnaVO);
		return result;
	}
}

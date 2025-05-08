package com.mireu.app.board.qna;

import com.mireu.app.board.BoardVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaVO extends BoardVO {

	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
}

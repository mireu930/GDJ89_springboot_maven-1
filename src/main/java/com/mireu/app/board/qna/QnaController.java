package com.mireu.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mireu.app.board.BoardVO;



@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;

	@GetMapping("list")
	public String getList(Model model) throws Exception {
		List<BoardVO> ar = qnaService.getList();
		model.addAttribute("list", ar);
		return "qna/list";
	}
	
	@GetMapping("detail")
	public String getDetail(QnaVO qnaVO, Model model) throws Exception {
		qnaVO = qnaService.getDetail(qnaVO);
		model.addAttribute("vo", qnaVO);
		return "qna/detail";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		return "qna/add";
	}
	
	@PostMapping("add")
	public String add(QnaVO qnaVO) throws Exception {
		int result = qnaService.add(qnaVO);
		return "redirect:./list";
	}
	
	@GetMapping("reply")
	public String reply(QnaVO qnaVO, Model model) throws Exception {
		qnaVO = qnaService.getDetail(qnaVO);
		model.addAttribute("vo", qnaVO);
		return "qna/reply";
	}
	
	@PostMapping("reply")
	public String reply(QnaVO qnaVO) throws Exception {
		
		int result = qnaService.reply(qnaVO);
		return "redirect:./list";
	}
}

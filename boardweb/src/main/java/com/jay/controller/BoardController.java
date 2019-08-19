package com.jay.controller;

import com.jay.domain.Board;
import com.jay.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @RequestMapping("/getBoardList")
    public String getBoardList(Model model, Board board){
        Page<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList",boardList); // model에 검색한 글 목록을 저장
        return "board/getBoardList";
    }



}

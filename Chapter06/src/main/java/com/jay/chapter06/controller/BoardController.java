package com.jay.chapter06.controller;


import com.jay.chapter06.domain.Board;
import com.jay.chapter06.domain.Member;
import com.jay.chapter06.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes("member")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @ModelAttribute("member")
    public Member setMember() {
        return new Member();
    }

    @RequestMapping("/getBoardList")
    public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {
        if (member.getId() == null) {
            return "redirect:login";
        }
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member) {
        if(member.getId() == null){
            return "redirect:login";
        }
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member, Board board) {
        if(member.getId() == null){
            return "redirect:login";
        }
        boardService.insertBoard(board);
        return "redirect:getBoardList"; // 이전 요청을 유효하지 않게 하기위해 리다이렉트로
    }

    @GetMapping("/getBoard")
    public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
        if(member.getId() == null){
            return "redirect:login";
        }
        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("member") Member member, Board board) {
        if(member.getId() == null){
            return "redirect:login";
        }
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
        if(member.getId() == null){
            return "redirect:login";
        }
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("greeting", "Thymeleaf");
    }

}
 /*List<Board> boardList = new ArrayList<Board>();

        for (int i = 1; i <= 10; i++) {
            Board board = new Board();
            board.setSeq((long) i);
            board.setTitle("게시판 프로그램 테스트");
            board.setWriter("도우너");
            board.setContent("게시판 프로그램 테스트 입니다...");
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardList.add(board);
        }*/
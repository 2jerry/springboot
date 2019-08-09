package com.jay.chapter06.service;


import com.jay.chapter06.domain.Board;
import com.jay.chapter06.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 리포지토리를 이용하여 실질적인 비즈니스 로직을 제공할 비즈니스 클래스
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepo;

    @Override
    public List<Board> getBoardList(Board board){
        return (List<Board>) boardRepo.findAll();
    }

    @Override
    public void insertBoard(Board board){
        boardRepo.save(board);
    }

    @Override
    public Board getBoard(Board board){
        return boardRepo.findById(board.getSeq()).get();
    }

    @Override
    public void updateBoard(Board board){
        Board findBoard = boardRepo.findById(board.getSeq()).get();

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepo.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board){
        boardRepo.deleteById(board.getSeq());
    }

}

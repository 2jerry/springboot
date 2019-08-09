package com.jay.chapter06.service;

import com.jay.chapter06.domain.Board;

import java.util.List;

// Service interface
public interface BoardService {
    List<Board> getBoardList(Board boar);

    void insertBoard(Board board);

    Board getBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Board board);
}

package com.jay.demo;

import com.jay.demo.domain.Board;
import com.jay.demo.persistence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void testInsertBoard() {
        Board board = new Board();
        board.setTitle("첫 번째 게시글");
        board.setWriter("테스터");
        board.setContent("잘 등록되나요?");
        board.setCreateDate(new Date());
        board.setCnt(0L);

        boardRepo.save(board);
    }

    @Test
    public void testGetBoard(){
        Board board = boardRepo.findById(1L).get();

        System.out.println(board.toString());
    }

   /* @Test
    public void testUpdateBoard(){
        System.out.println("=== 1번 게시글 조회 ===");

        Board board = boardRepo.findById(1L).get();

        System.out.println("=== 1번 게시글 제목 수정 ===");
        board.setTitle("제목을 수정");
        boardRepo.save(board);
    }*/

   @Test
    public void testDeleteBoard(){
       boardRepo.deleteById(1L);
   }
}
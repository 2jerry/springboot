package com.jay.demo;


import com.jay.demo.domain.Board;
import com.jay.demo.persistence.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private BoardRepository boardRepo;

    @Before
    public void dataPrepare() {
        for (int i = 1; i <= 200; i++) {
            Board board = new Board();
            board.setTitle("테스트 제목 " + i);
            //board.setWriter("테스터");
            board.setContent("테스트 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardRepo.save(board);
        }
    }

    @Test
    public void testFindByTitle() {
        List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");

        System.out.println("검색 결과");
        for (Board board : boardList){
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testByContentContaining(){
        List<Board> boardList = boardRepo.findByContentContaining("17");

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("---> "+ board.toString());
        }
    }


    @Test
    public void findByTitleContainingOrContentContaining() {
        List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17","17");

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("---> "+ board.toString());
        }

    }

    @Test
    public void findByTitleContainingOrOrderBySeqDesc() {
        List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testFindByTitleContaining() {
        //Pageable paging = PageRequest.of(0, 5); // 1번부터 다섯개의 데이터만 조회
        Pageable paging  = PageRequest.of(0,5, Sort.Direction.DESC,"seq");

        //List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
        Page<Board> pageInfo  = boardRepo.findByTitleContaining("제목",paging);

        System.out.println("PAGE SIZE : " + pageInfo.getSize());
        System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
        System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
        System.out.println("NEXT : " + pageInfo.nextPageable());

        List<Board> boardList = pageInfo.getContent();

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("---> " + board.toString());
        }
    }
}

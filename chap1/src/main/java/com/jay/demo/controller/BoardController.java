package com.jay.demo.controller;

import com.jay.demo.domain.BoardVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/* @RestController : REST 방식을 퍼리하는 컨트롤러 구현 가능
 *  @Controller 사용시 hello() 메소드의 리턴 타입으로 문자열을 사용했을 때,
 *  그 문자열에 해당하는 view를 생성해야함
 * */

@RestController
public class BoardController {

    public BoardController() {
        System.out.println("===> BoardController 생성");
    }

    // GET 방식으로 '/hello' 요청이 들어왔을 때 실행될 메소드
    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello : " + name;
    }


    // 객체리턴하는 경우 ==> JSON Format으로
    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        BoardVO board = new BoardVO();
        board.setSeq(1);
        board.setTitle("테스트 제목");
        board.setWriter("테스터");
        board.setContent("테스트 내용입니다......");
        board.setCreateDate(new Date());
        board.setCnt(0);

        return board;
    }


    // 컬렉션을 리턴하는 경우 ==> JSON Format\
    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        for (int i = 0; i <=10; i++) {
            BoardVO board = new BoardVO();
            board.setSeq(i);
            board.setTitle("제목" + i);
            board.setWriter("테스터");
            board.setContent(i + "번 내용입니다.");
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }
        return boardList;
    }


}

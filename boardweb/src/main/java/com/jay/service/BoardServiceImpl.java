package com.jay.service;

import com.jay.domain.QBoard;
import com.jay.domain.Board;
import com.jay.domain.Search;
import com.jay.persistence.BoardRepository;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

// BoardRepository를 이용해 실질적인 데이터베이스 연동 처리
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepo;

    @Override
    public void insertBoard(Board board) {
        boardRepo.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        Board findBoard = boardRepo.findById(board.getSeq()).get();

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());

        boardRepo.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepo.deleteById(board.getSeq());
    }

    @Override
    public Board getBoard(Board board) {
        return boardRepo.findById(board.getSeq()).get();
    }

    @Override
    public Page<Board> getBoardList(Search search) {
        // 가변적인 파라미터 값에 따라 동적으로 AND나 OR에 해당하는 조건을 추가할 수 있다.
        BooleanBuilder builder = new BooleanBuilder();

        QBoard qboard = QBoard.board;
        if(search.getSearchCondition().equals("TITLE")){
            builder.and(qboard.title.like("%"+search.getSearchKeyword()+"%"));
        } else if(search.getSearchCondition().equals("CONTENT")) {
            builder.and(qboard.content.like("%" + search.getSearchKeyword()+"%"));
        }

        Pageable pageable = PageRequest.of(0,10, Sort.Direction.DESC, "seq");
        return boardRepo.findAll(builder,pageable);
    }
}

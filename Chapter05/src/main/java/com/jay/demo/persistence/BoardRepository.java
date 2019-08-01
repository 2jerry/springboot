package com.jay.demo.persistence;

import com.jay.demo.domain.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findByTitle(String searchKeyword); // 게시글 제목으로 목록 조회
    List<Board> findByContentContaining(String searchKeyword);
    List<Board> findByTitleContainingOrContentContaining(String title, String content);
}
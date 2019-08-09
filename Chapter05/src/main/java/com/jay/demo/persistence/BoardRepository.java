package com.jay.demo.persistence;

import com.jay.demo.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findByTitle(String searchKeyword); // 게시글 제목으로 목록 조회

    List<Board> findByContentContaining(String searchKeyword);

    //List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);

    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    /*@Query("SELECT b FROM Board b WHERE b.title LIKE %?1% ORDER BY b.seq DESC") // JPQL 등록 위치 기반 파라미터
    List<Board> queryAnnotationTest1(String searchKeyword);*/
//    @Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword%  ORDER BY b.seq DESC")
//    // 이름 기반 파라미터
//    List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
//
//    @Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %?1%  ORDER BY b.seq DESC")
//        // 이름 기반 파라미터
//    List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword); // 여러 변수 값들을 조회할 때 Object[] 리턴타입으로 사용한다.
//
//    @Query(value = "SELECT seq, title, writer, create_date FROM board WHERE title like '%'||?1||'%' ORDER BY seq DESC",nativeQuery=true)
//    List<Object[]> queryAnnotationTest3(String searchKeyword);
//
//    @Query(value = "SELECT b FROM Board b ORDER BY b.seq DESC ")
//    List<Board> queryAnnotationTest4(Pageable paging);


}
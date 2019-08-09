package com.jay.demo.persistence;

import com.jay.demo.domain.Board;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DynamicBoardRepository extends CrudRepository<Board, Long>,
        QuerydslPredicateExecutor<Board> {
}

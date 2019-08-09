package com.jay.chapter06.persistence;

import com.jay.chapter06.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}

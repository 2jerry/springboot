package com.jay.chapter06.persistence;

import com.jay.chapter06.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,String> {
}

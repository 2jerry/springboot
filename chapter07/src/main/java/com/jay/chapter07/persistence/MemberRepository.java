package com.jay.chapter07.persistence;

import com.jay.chapter07.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}

package com.jay.demo.persistence;

import com.jay.demo.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,String>{
}

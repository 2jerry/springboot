package com.jay.chapter07.config;

import com.jay.chapter07.domain.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.security.Security;

// User를 상속한 클래스
public class SecurityUser extends User {

    private static final long serialVersionID = 1L;

    public SecurityUser(Member member){
        super(member.getId(), member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));
    }
}

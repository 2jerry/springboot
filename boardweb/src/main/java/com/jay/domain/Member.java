package com.jay.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "boardList") // 순환참조 문제해결
@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled; // 사용자 사용 여부 제어

    // Member : Board = 1 : N 관계
    // Member가 조회될 때 관련된 Board 목록도 같이 조회되도록 fetch를 즉시 로딩으로 설정(EAGER)
    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER)
    private List<Board> boardList = new ArrayList<Board>();
}

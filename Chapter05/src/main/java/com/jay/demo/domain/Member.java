package com.jay.demo.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "boardList")
@Entity
public class Member {

    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String password;
    private String name;
    private String role;


    // ALL : 회원 객체가 영속화 되거나 수정, 삭제될 때 회원과 관련된 게시판도 같이 변경된다.

    @OneToMany(mappedBy = "member" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<Board>();

}

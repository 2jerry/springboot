package com.jay.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = "member")
@Entity
public class Board { // 게시판 DB table

    @Id
    @GeneratedValue
    private Long seq;

    private String title;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false) // JPA 수정작업을 처리할 때 하이버네이트가 수정 SQL에 해당 칼럼을 포함하지 않도록
    private Date createDate = new Date();

    @Column(updatable = false)
    private Long cnt = 0L;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID",nullable = false, updatable = false) // 외래키 매핑, 내부조인,
    private Member member;

    public void setMember(Member member){
        this.member = member;
        member.getBoardList().add(this);
    }

}

package com.jay.domain;

import lombok.Data;

// 검색 전용 클래스 , 검색관련 정보만 저장
@Data // getter,setter,tostring 포함 어노테이션
public class Search {
    private String searchCondition;
    private String searchKeyword;
}

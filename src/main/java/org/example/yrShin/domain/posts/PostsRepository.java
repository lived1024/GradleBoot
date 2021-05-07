package org.example.yrShin.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    // jpa를 이용하기 어려운 경우에는 Querydsl, jooq, MyBatis를 이용
    // 이 책의 저자는 Querydsl을 추천
    // 1. 타입 안정성 보장 - 오타나 존재하지 않는 컬럼명을 명시할 경우 IDE에서 자동으로 검출 - MyBatis는 지원 X
    // 2. 쿠팡, 배민 등 JPA를 적극적으로 사용하는 회사에서 Querydsl을 적극적으로 사용중
    // 3. 레퍼런스가 많음 - 국내 자료가 많음
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

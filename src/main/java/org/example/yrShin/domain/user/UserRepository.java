package org.example.yrShin.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 소셜 로그인으로 반환되는 값 중 email을 통해 사용자 체크
    Optional<User> findByEmail(String email);
}

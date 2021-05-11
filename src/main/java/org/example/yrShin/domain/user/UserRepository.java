package org.example.yrShin.domain.user;

import java.util.Optional;

public interface UserRepository {

    // 소셜 로그인으로 반환되는 값 중 email을 통해 사용자 체크
    Optional<User> findByEmail(String email);
}

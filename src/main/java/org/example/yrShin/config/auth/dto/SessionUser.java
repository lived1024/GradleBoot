package org.example.yrShin.config.auth.dto;

import lombok.Getter;
import org.example.yrShin.domain.user.User;

import java.io.Serializable;

/* SessionUser : 세션용 DTO 클래스 - 인증된 사용자 정보만 필요 - 직렬화 기능을 가진 세션용 Dto
 * User 클래스와 별도로 사용하는 이유
 * 1. 동일하게 사용 시 직렬화를 구현하지 않았다는 에러 발성
 *     -> User 클래스에 직렬화 구현 시 다른 엔티티를 자식 엔티티로 가진다면 자식 엔티티도 직렬화 대상이 된다.
 *     -> 성능 이슈, 부수 효과가 발생할 확률이 높음
 */
@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

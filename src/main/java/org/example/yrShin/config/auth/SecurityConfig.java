package org.example.yrShin.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.yrShin.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity          // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // h2-console 화면을 사용하기 위해 해당 옵션 disable
        http.csrf().disable().headers().frameOptions().disable()

                .and()

                /* url별 권한관리 옵션 시작 -----------------------------------------------------------------------
                 * antMatchers : 권한관리 대상 지정 - URL, HTTP 메소드별 관리 가능
                 * antMatchers 첫번째 줄 : 지정된 URL은 전체 열람 권한 부여
                 * antMatchers 두번째 줄 : USER권한을 가진 사람만 권한 부여
                 * anyRequest : 지정된 URL 이외의 URL 들 - 인증된 사용자들에게만 허용(로그인한 사용자)
                 */
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()

                .and()

                //로그아웃 기능에 대한 여러 설정의 진입점
                .logout().logoutSuccessUrl("/")

                .and()

                /* oauth2Login : OAuth2 로그인 기능에 대한 여러 설정의 진입점
                 * userInfoEndpoint : 로그인 성공 이후 사용자 정보를 가져올때 설정들 담당
                 * userService : 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체 등록
                 *               리소스 서버(ex-소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시 할 수 있음
                 */
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}

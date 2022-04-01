package com.root.whattodotoday.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // SpringSecurityFilterChain 포함시키기
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginIdPwValidator loginIdPwValidator;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/chk").permitAll()    // 로그인 없이 접근 가능해야 하는 URI
//                .antMatchers("/manage").hasAuthority("ROLE_ADMIN") // 해당 사용자의 권한이 admin인 경우 /manage 이하의 uri에 접근 가능
                .anyRequest().authenticated() // 어떤 URI로 접근하든 인증된 사용자만 접근 가능
                // anyRequest() 대신 .antMatchers("url")을 사용하면 로그인이 필요한 uri 지정 가능
            .and()
                .formLogin() // 폼 방식 로그인을 사용하겠다
                .loginPage("/member/login") // 커스텀 페이지로 로그인 페이지를 변경
                .loginProcessingUrl("/loginProc") // form 태그의 action 주소 (로그인을 시도하면 넘겨받을 주소 지정 -> 자동으로 스프링 시큐리티쪽으로 id와 pw를 보냄)
                .usernameParameter("id") // 유저 아이디에 해당하는 form 내부 input의 name (생략 가능)
                .passwordParameter("pw") // 유저 비밀번호에 해당하는 form 내부 input의 name (생략 가능)
                .defaultSuccessUrl("/", true) // 로그인 성공 시 이동할 url 작성
                .permitAll()
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logoutProc")); // /logoutProc를 호출하면 로그아웃이 되고 다시 로그인 페이지로 자동 이동 (생략 가능, 생략 시 /logout을 호출하면 로그아웃 가능
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // css, js 등 인증이 되지 않아도 확인할 수 있어야 하는 경로들이 존재하는데 이 부분들은 다음과 같이 예외처리한다
        web.ignoring().antMatchers("/static/js/**","/static/css/**","/static/images/**","/static/fonts/**","/static/vendor/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginIdPwValidator); // 비밀번호 비교
    }
}

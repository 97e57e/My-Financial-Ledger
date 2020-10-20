package lee.garden.FinancialLedger.config;

import lee.garden.FinancialLedger.common.filter.JwtAuthenticationFilter;
import lee.garden.FinancialLedger.module.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtProvider jwtTokenProvider;
    private static final String API_VERSION = "/api/v1";

    /**
     * 로그인 페이지를 제외한 모든 페이지는 권한이 필요.
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers(API_VERSION + "/login", API_VERSION + "/signup").permitAll()
                    .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);
    }
}

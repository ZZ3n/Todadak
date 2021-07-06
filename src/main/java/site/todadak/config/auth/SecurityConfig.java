package site.todadak.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import site.todadak.domain.user.Role;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                /*
                 * === Authorize ===
                 */
                .authorizeRequests()
                // PUBLIC
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**")
                .permitAll()
                //USER
                .antMatchers("/api/v1/**")
                .hasRole(Role.USER.name())
                //ANY
                .anyRequest()
                .authenticated()
                .and()
                /*
                 * === Logout ===
                 */
                .logout()
                .logoutSuccessUrl("/")
                /*
                 * === OAuth2 ===
                 */
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}

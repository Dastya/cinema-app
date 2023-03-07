package cinema.config;

import cinema.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String USER = Role.RoleName.USER.name();
    private static final String ADMIN = Role.RoleName.ADMIN.name();
    private static final String ROOT = Role.RoleName.ROOT.name();
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers(HttpMethod.POST, "/cinema-halls", "/movies", "/movie-sessions")
                .hasAnyRole(ADMIN, ROOT)
                .antMatchers(HttpMethod.GET, "/cinema-halls", "/movies", "/movie-sessions")
                .hasAnyRole(ADMIN, USER, ROOT)
                .antMatchers("/movie-sessions/*", "/users/by-email").hasAnyRole(ADMIN, ROOT)
                .antMatchers("/orders/**", "/shopping-carts/**").hasAnyRole(USER, ROOT)
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}

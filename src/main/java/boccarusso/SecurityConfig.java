package boccarusso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  private static final String[] AUTH_WHITELIST = {
      "/project"
  };

  private static final String[] AUTH_BLACKLIST = {
      "/"
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            // .requestMatchers(AUTH_BLACKLIST).authenticated()
            .requestMatchers(AUTH_WHITELIST).permitAll());
    // .formLogin();
    return http.build();
  }
}

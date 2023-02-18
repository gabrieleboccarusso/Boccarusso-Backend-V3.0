package boccarusso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

 @Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  http.authorizeHttpRequests(authorize -> authorize
    .requestMatchers(HttpMethod.GET, "/**").permitAll()
    .anyRequest().authenticated())
    .formLogin()
    .and()
    .httpBasic()
    .and()
    .csrf().disable();
  return http.build();
 }
}

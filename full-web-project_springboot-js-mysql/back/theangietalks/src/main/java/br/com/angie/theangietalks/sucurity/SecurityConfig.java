package br.com.angie.theangietalks.sucurity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig  {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .authorizeHttpRequests()
////                .requestMatchers(HttpMethod.POST, "/users/login").permitAll()
////                .anyRequest().authenticated().and().cors();
//        http
//                .authorizeRequests()
//                .requestMatchers("/users/login")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .cors();
//        return http.build();
//        //http.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return null;
//    }
//
//}

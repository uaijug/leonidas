package br.com.uaijug.leonidas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static PasswordEncoder encoder;

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/css/**").permitAll().antMatchers("/api/**").permitAll()
                .antMatchers("/health/**").permitAll().antMatchers("/env/**").permitAll().antMatchers("/metrics/**")
                .permitAll().antMatchers("/dump/**").permitAll().antMatchers("/trace/**").permitAll()
                .antMatchers("/console/**").permitAll().antMatchers("/").permitAll().anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/admin").failureUrl("/login").and()
                .logout().permitAll();
        http.httpBasic();
        http.headers().frameOptions().disable();
        /*
         * .formLogin().failureUrl("/login?error") .defaultSuccessUrl("/")
         * .loginPage("/login") .permitAll() .and()
         * .logout().logoutRequestMatcher(new
         * AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
         * .permitAll();
         */
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("user").password("admin").roles("USER");
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/img/**", "/css/**", "/js/**", "/site/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        if (encoder == null) {
            encoder = new BCryptPasswordEncoder();
        }

        return encoder;
    }

}
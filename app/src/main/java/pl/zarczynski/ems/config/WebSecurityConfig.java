package pl.zarczynski.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.zarczynski.ems.security.AuthenticationFilter;
import pl.zarczynski.ems.security.MyAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers("/api/login/**","/api/logout/**").permitAll()
                .antMatchers("/api/employees/**").authenticated()
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationFilter authenticationFilter() throws Exception {
        return new AuthenticationFilter(new AntPathRequestMatcher("/api/login","POST"),authenticationManager());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}

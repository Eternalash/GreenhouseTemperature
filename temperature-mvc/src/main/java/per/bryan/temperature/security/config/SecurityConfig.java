package per.bryan.temperature.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@SuppressWarnings("all")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.authorizeRequests().antMatchers("/", "/js/**", "/css/**", "/img/**", "/webjars/**").permitAll()
         .antMatchers("/user/**").hasRole("USER").anyRequest().authenticated().and().formLogin().loginPage("/login")
         .permitAll().and().logout().invalidateHttpSession(true)
         .clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         .logoutSuccessUrl("/login?logout").permitAll().and().exceptionHandling();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
            User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }

}
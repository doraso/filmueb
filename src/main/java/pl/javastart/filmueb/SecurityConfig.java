package pl.javastart.filmueb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
               // .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery(
                        "select username,password, enabled from user where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_role where username=?");
    }



        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/moderator").hasRole("MODERATOR")
                    .antMatchers("/moderator").hasRole("ADMIN")
                    .antMatchers("/user").hasRole("ADMIN")
                    .antMatchers("/user").hasRole("USER")
                    .antMatchers("/changeRoles").hasRole("ADMIN")

                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login");

        }
    }
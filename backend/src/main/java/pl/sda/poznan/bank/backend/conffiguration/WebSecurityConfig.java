package pl.sda.poznan.bank.backend.conffiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private RestLoginSuccessHandler restLoginSuccessHandler;
    private RestLoginFailureHandler restLoginFailureHandler;
    private RestLogoutSuccessHandler restLogoutSuccessHandler;
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    public WebSecurityConfig(RestLoginSuccessHandler restLoginSuccessHandler,
                             RestLoginFailureHandler restLoginFailureHandler,
                             RestLogoutSuccessHandler restLogoutSuccessHandler,
                             RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.restLoginSuccessHandler = restLoginSuccessHandler;
        this.restLoginFailureHandler = restLoginFailureHandler;
        this.restLogoutSuccessHandler = restLogoutSuccessHandler;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/admin", "/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .formLogin()
                .successHandler(restLoginSuccessHandler)
                .failureHandler(restLoginFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(restLogoutSuccessHandler)
                .permitAll();


        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
//                .userDetailsService()
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
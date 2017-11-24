package pl.sda.poznan.bank.backend.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.poznan.bank.backend.service.BankUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final RestLoginSuccessHandler restLoginSuccessHandler;
    private final RestLoginFailureHandler restLoginFailureHandler;
    private final RestLogoutSuccessHandler restLogoutSuccessHandler;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final BankUserDetailsService userDetailsService;

    public WebSecurityConfig(RestLoginSuccessHandler restLoginSuccessHandler,
                             RestLoginFailureHandler restLoginFailureHandler,
                             RestLogoutSuccessHandler restLogoutSuccessHandler,
                             RestAuthenticationEntryPoint restAuthenticationEntryPoint,
                             BankUserDetailsService userDetailsService) {
        this.restLoginSuccessHandler = restLoginSuccessHandler;
        this.restLoginFailureHandler = restLoginFailureHandler;
        this.restLogoutSuccessHandler = restLogoutSuccessHandler;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/admin", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/register").permitAll()
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


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
}
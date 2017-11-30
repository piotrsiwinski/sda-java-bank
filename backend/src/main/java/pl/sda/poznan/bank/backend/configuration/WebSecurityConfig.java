package pl.sda.poznan.bank.backend.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.sda.poznan.bank.backend.service.impl.BankUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final RestLoginSuccessHandler restLoginSuccessHandler;
    private final RestLoginFailureHandler restLoginFailureHandler;
    private final RestLogoutSuccessHandler restLogoutSuccessHandler;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final BankUserDetailsServiceImpl userDetailsService;
    @Autowired
    private Filter filter;

    public WebSecurityConfig(RestLoginSuccessHandler restLoginSuccessHandler,
                             RestLoginFailureHandler restLoginFailureHandler,
                             RestLogoutSuccessHandler restLogoutSuccessHandler,
                             RestAuthenticationEntryPoint restAuthenticationEntryPoint,
                             BankUserDetailsServiceImpl userDetailsService) {
        this.restLoginSuccessHandler = restLoginSuccessHandler;
        this.restLoginFailureHandler = restLoginFailureHandler;
        this.restLogoutSuccessHandler = restLogoutSuccessHandler;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
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
                .permitAll()
        .and()
        .addFilterBefore(filter, CsrfFilter.class);


        http.csrf().disable();
        http.headers().frameOptions().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

//    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")
//                        .exposedHeaders("header1", "header2")
                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                        .allowCredentials(true)
                        .allowCredentials(false).maxAge(3600);
            }
        };
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

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");
    }
}
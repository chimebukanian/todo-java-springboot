// package ebuks.app.configuration;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
// import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
// import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

// import jakarta.servlet.http.HttpServletRequest;

// @Configuration
// public class WebSecurityConfiguration extends WebSecurityConfigureAdapter{
    
//     @Autowired
//     private  LoginSuccessHandler loginSuccessHandler;

//     @Autowired
//     private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception{
//         http
//             .authorizeRequets().antMatchers("/api/*").authenticated()
//             .and()
//             .httpBasic()
//             .and()
//             .exceptionHandling()
//                 .authenticationEntryPoint(restAuthenticationEntryPoint)
//             .and()
//             .formLogin()
//                     .loginProcessingUrl("/api/login")
//                 .successHandler(loginSuccessHandler)
//                 .failureHandler(new SimpleUrlAuthentcationFailureHandler());
//             http.csrf().ignoringAntMatchers("/api/login").csrfTOkenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

//     }
    
// }

// @Component("loginSuccessHandler")
// public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
//     private RequestCache requestCache = new HttpSessionRequestCache();

//     @Override
//     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//         SsvedReuqest savedRequest = requestCache.getRequest(request, response);
//         if (savedRequest == null){
//             clearAuthenticationAttributes(request);  
//             return;
//         }
//         String targetUrlParam = getTargetUrlParameter();
//         if (isAlwaysUseDefaultTargetUrl() || (targetUrlParam != null && StringUtils.hasText(request.getParameter(targetUrlParam)))){
//             requestCache.removeRequest(request, response);
//             clearAuthenticationAttributes(request);
//             return;
//         }
//         clearAuthenticationAttributes(request);
//     }

//     public void setRequestCache(requestCache requestCache){
//         this.requestCache = requestCache;
//     }

//     @Bean
   
//    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//         String encodedPassword = passwordEncoder().encode(password);
//         manager.createUser(User.withUsername(username).password(encodedPassword).roles("USER").build());
// del         return manager;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder(){
//         return new BcryptPasswordEncoder();
//     }
// }
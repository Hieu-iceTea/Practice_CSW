package Hieu_iceTea.Practice_CSW.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //region - Authentication | JDBC-
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }

    //region - Authorization | Configure -
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                // API:
                .antMatchers(HttpMethod.POST, "/api/products/buy/**").hasAnyRole("Customer")

                .antMatchers(HttpMethod.GET, "/api/products/**").hasAnyRole("Staff", "Customer")
                .antMatchers(HttpMethod.POST, "/api/products/**").hasAnyRole("Staff")
                .antMatchers(HttpMethod.PUT, "/api/products/**").hasAnyRole("Staff")
                .antMatchers(HttpMethod.DELETE, "/api/products/**").hasAnyRole("Staff")


                /*.antMatchers(HttpMethod.GET, "/api/customers").hasAnyRole("Employee")
                .antMatchers(HttpMethod.GET, "/api/customers/**").hasAnyRole("Employee")
                .antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole("Manager", "Admin")
                .antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole("Manager", "Admin")
                .antMatchers(HttpMethod.PUT, "/api/customers").hasAnyRole("Manager", "Admin")
                .antMatchers(HttpMethod.PUT, "/api/customers/**").hasAnyRole("Manager", "Admin")
                .antMatchers(HttpMethod.DELETE, "/api/customers/**").hasAnyRole("Admin")*/

                //.antMatchers("/").permitAll()
                .anyRequest().authenticated()
                //.anyRequest().denyAll()

                .and()
                .formLogin()
                //.loginPage("/account/login") //B??? d??ng n??y s??? d??ng trang login m???c ?????nh
                .permitAll()


                //Th??m 2 d??ng n??y n???u d??ng API (????ng nh???p ki???u Basic-Auth trong Postman)
                .and()
                .httpBasic()

                //Th??m ph???n n??y ????? h???y csrf, l??c ???? test trong Postman cho d???, ????? ph???i th??m th??m tr?????ng @csrf. AHIHI
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
    }
    //endregion

}
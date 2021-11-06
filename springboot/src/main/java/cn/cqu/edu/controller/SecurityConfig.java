package cn.cqu.edu.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /**
//         * 需要经过mayikt_admin
//         */
        auth.inMemoryAuthentication().withUser("mayikt_admin").password("mayikt_admin").authorities("addMember",
                "delMember", "updateMember", "showMember");
//        /**
//         * 当前 账户授权 可以访问哪些接口
//         */
        auth.inMemoryAuthentication().withUser("mayikt_add").password("mayikt_add").authorities("addMember");
        auth.inMemoryAuthentication().withUser("mayikt_update").password("mayikt_update").authorities("updateMember");
        auth.inMemoryAuthentication().withUser("mayikt_show").password("mayikt_admin").authorities("showMember");
        auth.inMemoryAuthentication().withUser("mayikt_del").password("mayikt_del").authorities("delMember");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置认证方式 token form 表单 设置为httpBasic模式
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
        //拦截 http 安全认证模式 设置为formLogin模式
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().formLogin();

        /**
         * /addMember  addMember
         * /updateMember  updateMember
         * /delMember  delMember
         * /showMember  showMember
         *
         * mayikt_add----（addMember）
         * mayikt_admin----（addMember，delMember,updateMember,showMember）
         */
        http.authorizeRequests().antMatchers("/addMember").hasAnyAuthority("addMember")
                .antMatchers("/delMember").hasAnyAuthority("delMember")
                .antMatchers("/updateMember").hasAnyAuthority("updateMember")
                .antMatchers("/showMember").hasAnyAuthority("showMember")
                .antMatchers("/**").fullyAuthenticated().and().formLogin();;
//                // 可以允许login 不被拦截
//                .antMatchers("/login").permitAll()
//                // 设置自定义登录页面
//                .antMatchers("/**").fullyAuthenticated().and().formLogin()
//                .loginPage("/login").and().csrf().disable();


    }

    /**
     * There is no PasswordEncoder mapped for the id "null"
     * 原因:升级为Security5.0以上密码支持多中加密方式，恢复以前模式
     *
     * @return
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}

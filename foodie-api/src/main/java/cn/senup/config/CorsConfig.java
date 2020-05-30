package cn.senup.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: 涛哥
 * @Description:
 * @Date: Created in 2020/5/30  12:11
 * @Modified By:
 */
@Configuration
public class CorsConfig {
    public CorsConfig() {
    }

    @Bean
    public CorsFilter corsFilter() {
        //添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        //使用*会产生安全隐患 因此不建议
        config.addAllowedOrigin("http://localhost:8080");
        //设置凭证 即携带的内容cookie等
        config.setAllowCredentials(true);
        //设置允许请求的方式
        config.addAllowedMethod("*");
        //设置允许的header
        config.addAllowedHeader("*");
        //为url添加映射路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**",config);

        return new CorsFilter(corsSource);
    }
}

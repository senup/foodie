package cn.senup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
/** 扫描mybatis通用mapper所在的包 */ 
@MapperScan(basePackages = "cn.senup.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("===========================程序启动中=====================================");
    }
}

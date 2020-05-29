package cn.senup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     *
     * @auther: 涛哥
     * @Description: 测试
     * @date: 2020/5/29 17:17
     * @param: []
     * @return: java.lang.Object
     *
     */
    @GetMapping("/hello")
    public Object hello() {
        return "hello world!";
    }
}

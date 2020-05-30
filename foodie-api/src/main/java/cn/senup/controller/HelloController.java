package cn.senup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @auther: 涛哥
 * @Description:
 * @date: 2020/5/30 11:14
 * @param:
 * @return:
 */

@ApiIgnore //当前类里的方法在接口文档中隐藏
@RestController
public class HelloController {

    /**
     * @auther: 涛哥
     * @Description: 测试
     * @date: 2020/5/29 17:17
     * @param: []
     * @return: java.lang.Object
     */
    @GetMapping("/hello")
    public Object hello() {
        return "hello world!";
    }
}

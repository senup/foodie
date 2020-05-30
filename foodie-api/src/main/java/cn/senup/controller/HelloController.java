package cn.senup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Administrator
 * @auther: 涛哥
 * @Description:
 * @date: 2020/5/30 11:14
 * @param:
 * @return:
 */
@ApiIgnore //当前类里的方法在接口文档中隐藏
@RestController
public class HelloController {
    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    /**
     * @auther: 涛哥
     * @Description: 测试
     * @date: 2020/5/29 17:17
     * @param: []
     * @return: java.lang.Object
     */
    @GetMapping("/hello")
    public Object hello() {
        logger.info("info:hello {}", "你好 世界~");
        return "hello world!";
    }
}

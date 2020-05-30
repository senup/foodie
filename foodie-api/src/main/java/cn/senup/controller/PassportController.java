package cn.senup.controller;

import cn.senup.pojo.Users;
import cn.senup.pojo.bo.UserBO;
import cn.senup.service.UserService;
import cn.senup.utils.XTJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 涛哥
 * @Description:
 * @Date: Created in 2020/5/30  9:19
 * @Modified By:
 */
@Api(value = "注册登录",tags = {"用于注册登录的接口"})
@RestController
@RequestMapping("passport")
public class PassportController {
    @Autowired
    private UserService userService;

    /**
     * @auther: 涛哥
     * @Description:
     * @date: 2020/5/30 9:48
     * @param: [username]
     * @return: cn.senup.utils.XTJSONResult
     */
    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public XTJSONResult usernameIsExist(@RequestParam String username) {
        //blank相较于empty可以多判断空字符串
        if (StringUtils.isBlank(username)) {
            return XTJSONResult.errorMsg("用户名不能为空！");
        }
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return XTJSONResult.errorMsg("用户名已存在！");
        }
        return XTJSONResult.ok();
    }

    /**
     * @auther: 涛哥
     * @Description: 用户注册
     * @date: 2020/5/30 10:24
     * @param: [userBO]
     * @return: cn.senup.utils.XTJSONResult
     */
    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod = "POST")
    @PostMapping("/regist")
    public XTJSONResult regist(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();
        //判断用户名、密码不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPassword)
        ) {
            return XTJSONResult.errorMsg("用户名或密码不能为空！");
        }
        //查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return XTJSONResult.errorMsg("用户名已存在！");
        }
        //密码长度不能少于6位
        if (password.length() < 6) {
            return XTJSONResult.errorMsg("密码长度不能小于6！");
        }
        //判断两次密码是否一致
        if (!password.equals(confirmPassword)) {
            return XTJSONResult.errorMsg("两次密码输入不一致！");
        }
        //实现注册
        Users user = userService.createUser(userBO);
        return XTJSONResult.ok(user);
    }

}

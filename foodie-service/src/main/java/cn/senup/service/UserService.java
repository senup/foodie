package cn.senup.service;

import cn.senup.pojo.Users;
import cn.senup.pojo.bo.UserBO;

/**
 * @Author: 涛哥
 * @Description:
 * @Date: Created in 2020/5/30  8:50
 * @Modified By:
 */
public interface UserService {
    /**
     *
     * @auther: 涛哥
     * @Description: 用户名是否存在
     * @date: 2020/5/30 9:48
     * @param: [username]
     * @return: boolean
     *
     */
    public boolean queryUsernameIsExist(String username);

    /**
     *
     * @auther: 涛哥
     * @Description: 创建用户
     * @date: 2020/5/30 9:52
     * @param: [UserBO]
     * @return: cn.senup.pojo.Users
     *
     */
    public Users createUser(UserBO userBO);

    /**
     *
     * @auther: 涛哥
     * @Description: 检索用户名密码是否匹配 用于登录
     * @date: 2020/5/30 17:33
     * @param: [username, password]
     * @return: cn.senup.pojo.Users
     *
     */
    public Users queryUserForLogin(String username, String password);
}

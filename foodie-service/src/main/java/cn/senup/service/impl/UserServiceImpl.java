package cn.senup.service.impl;

import cn.senup.enums.Sex;
import cn.senup.mapper.UsersMapper;
import cn.senup.pojo.Users;
import cn.senup.pojo.bo.UserBO;
import cn.senup.service.UserService;
import cn.senup.utils.DateUtil;
import cn.senup.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @Author: 涛哥
 * @Description:
 * @Date: Created in 2020/5/30  8:51
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private Sid sid;

    private static final String USER_FACE = "https://img.senup.cn/blog/20200530/shLY43atxdWE.png?imageslim";

    /**
     * @auther: 涛哥
     * @Description: 判断用户名是否存在
     * @date: 2020/5/30 9:09
     * @param: [username]
     * @return: boolean
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        Users result = usersMapper.selectOneByExample(userExample);
        return result != null;
    }

    /**
     *
     * @auther: 涛哥
     * @Description: 创建用户
     * @date: 2020/5/30 10:15
     * @param: [userBO]
     * @return: cn.senup.pojo.Users
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users createUser(UserBO userBO) {
        String userId = sid.nextShort();

        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setNickname(userBO.getUsername());
        user.setFace(USER_FACE);
        user.setBirthday(DateUtil.stringToDate("1990-01-01"));
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    /**
     *
     * @auther: 涛哥
     * @Description: 用于登录
     * @date: 2020/5/30 17:34
     * @param: [username, password]
     * @return: cn.senup.pojo.Users
     *
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Users queryUserForLogin(String username, String password) {

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username)
                .andEqualTo("password",password);
        Users result = usersMapper.selectOneByExample(userExample);
        return result;
    }
}

package cn.senup.enums;

/**
 * @Author: 涛哥
 * @Description: 性别 枚举类
 * @Date: Created in 2020/5/30  10:06
 * @Modified By:
 */
public enum Sex {
    /**
     *
     * @auther: 涛哥
     * @Description: 性别 枚举
     * @date: 2020/5/30 10:09
     * @param:
     * @return:
     *
     */
    woman(0, "女"),
    man(1,"男"),
    secret(2,"保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}

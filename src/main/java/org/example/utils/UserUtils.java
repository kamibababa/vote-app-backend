package org.example.utils;


import org.example.entity.UsersEntity;

/**
 *	存储/获取当前线程的用户信息工具类
 */
public class UserUtils {

    //线程变量，存放user实体类信息，即使是静态的与其他线程也是隔离的
    private static ThreadLocal<UsersEntity> userThreadLocal = new ThreadLocal<UsersEntity>();

    //从当前线程变量中获取用户信息
    public static UsersEntity getLoginUser() {
        System.out.println(Thread.currentThread().getId());
        UsersEntity user = userThreadLocal.get();
        return user;
    }

    /**
     * 获取当前登录用户的ID
     * 未登录返回null
     *
     * @return
     */
    public static Long getLoginUserId() {
        UsersEntity user = userThreadLocal.get();
        if (user != null && user.getId() != null) {
            return user.getId();
        }
        return null;
    }

    //为当前的线程变量赋值上用户信息
    public static void setLoginUser(UsersEntity user) {
        System.out.println(Thread.currentThread().getId());
        userThreadLocal.set(user);
    }

    //清除线程变量
    public static void removeUser() {
        System.out.println(Thread.currentThread().getId());
        userThreadLocal.remove();
    }
}


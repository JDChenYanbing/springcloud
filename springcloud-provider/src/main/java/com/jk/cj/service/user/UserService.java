/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: UserService
 * Author:   崔健
 * Date:     2019/5/1 16:19
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.service.user;

import com.jk.cj.model.user.UserBean;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
public interface UserService {

    UserBean queryUserByName(String userName);

    HashMap<String, Object> queryUser(Integer page, Integer rows, UserBean userBean);

    void addUser(UserBean userBean);
}
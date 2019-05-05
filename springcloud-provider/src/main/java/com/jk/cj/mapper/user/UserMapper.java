/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: UserMapper
 * Author:   崔健
 * Date:     2019/5/1 16:23
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.mapper.user;

import com.jk.cj.model.user.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {

    UserBean queryUserByName(String userName);

    int queryUserCount(HashMap<String, Object> params);

    List<UserBean> queryUser(HashMap<String, Object> params);

    void addUser(UserBean userBean);
}
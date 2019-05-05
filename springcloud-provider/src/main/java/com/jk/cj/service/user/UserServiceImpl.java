/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: UserServiceImpl
 * Author:   崔健
 * Date:     2019/5/1 16:19
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.service.user;

import com.jk.cj.mapper.user.UserMapper;
import com.jk.cj.model.user.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserBean queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }

    @Override
    public HashMap<String, Object> queryUser(Integer page, Integer rows, UserBean userBean) {

        HashMap<String,Object> result=new HashMap<>();

        HashMap<String, Object> params=new HashMap<>();
        params.put("userBean", userBean);
        //查询总条数
        int sum=userMapper.queryUserCount(params);
        result.put("total",sum);
        //开始条数
        Integer start=(page-1)*rows;
        params.put("start", start);
        params.put("rows", rows);
        List<UserBean> users=userMapper.queryUser(params);
        result.put("rows",users);
        return result;
    }

    @Override
    public void addUser(UserBean userBean) {
        userMapper.addUser(userBean);
    }
}
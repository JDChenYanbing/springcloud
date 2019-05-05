/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: TreeController
 * Author:   崔健
 * Date:     2019/5/1 14:03
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.controller;

import com.jk.cj.model.TreeBean;
import com.jk.cj.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
@RestController
public class TreeController {

    @Autowired
    private TreeService treeService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostMapping("getMyTree")
    public List<TreeBean> queryMyTree(HttpServletRequest request){
        List<TreeBean> treeList=new ArrayList<>();
        HttpSession session = request.getSession();
        // UserBean user = (UserBean) session.getAttribute(session.getId());
        //1、定义缓存key
        String key="powerTree"+1;
        //2、从缓存查看时候有当前用户的权限树
        if(!redisTemplate.hasKey(key)) {
            System.out.println("===走数据库===");
            //3、如果没有：a、从数据库查  b、把数据缓存到redis
            treeList=treeService.getMyTree(request);
            redisTemplate.opsForValue().set(key, treeList);
            //设置过期时间
            redisTemplate.expire(key, 30, TimeUnit.MINUTES);
        }else {
            System.out.println("===走缓存===");
            //4、如果有：从缓存获取数据，返回数据
            treeList=(List<TreeBean>) redisTemplate.opsForValue().get(key);
        }
        return treeList;
    }
}
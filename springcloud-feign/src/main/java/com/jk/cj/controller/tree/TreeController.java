/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: TreeController
 * Author:   崔健
 * Date:     2019/5/1 15:34
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.controller.tree;

import com.jk.cj.model.tree.TreeBean;
import com.jk.cj.model.user.UserBean;
import com.jk.cj.service.tree.TreeService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;

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
    private AmqpTemplate amqpTemplate;

    @PostMapping("/getMyTree")
    public List<TreeBean> getMyTree(){
        return treeService.getMyTree();
    }

    @PostMapping("queryUser")
    public HashMap<String,Object> queryUser(Integer page, Integer rows, UserBean userBean){
        return treeService.queryUser(page,rows,userBean);
    }

    @PostMapping("addUser")
    public void addUser(UserBean userBean){
        treeService.addUser(userBean);
        String jsonstr = JSONObject.toJSONString(userBean);
        amqpTemplate.convertAndSend("1809b-user",jsonstr);
    }


    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/demo/hi")
    public String qsw(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
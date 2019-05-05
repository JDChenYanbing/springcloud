/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: TreeService
 * Author:   崔健
 * Date:     2019/5/1 15:39
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.service.tree;

import com.jk.cj.model.tree.TreeBean;
import com.jk.cj.model.user.UserBean;
import com.jk.cj.utils.SchedualServiceTreeHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
@FeignClient(value = "SERVICE-PROVIDER",fallback = SchedualServiceTreeHystric.class)
public interface TreeService {

    @PostMapping(value = "getMyTree")
    List<TreeBean> getMyTree();

    @GetMapping(value = "queryUserByName")
    UserBean queryUserByName(@RequestParam("userCode") String userCode);

    @PostMapping(value = "queryUser")
    HashMap<String, Object> queryUser(@RequestParam("page") Integer page,@RequestParam("rows")  Integer rows, @RequestBody UserBean userBean);

    @PostMapping(value = "addUser")
    void addUser(@RequestBody UserBean userBean);
}
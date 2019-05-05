/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: SchedualServiceTreeHystric
 * Author:   崔健
 * Date:     2019/5/2 19:43
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.utils;

import com.jk.cj.model.tree.TreeBean;
import com.jk.cj.model.user.UserBean;
import com.jk.cj.service.tree.TreeService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/2
 * @since 1.0.0
 */
@Component
public class SchedualServiceTreeHystric implements TreeService {

    @Override
    public List<TreeBean> getMyTree() {
        TreeBean treeBean =new TreeBean();
        treeBean.setText("抱歉，工程师正在检修");
        List<TreeBean> list=new ArrayList<>();
        list.add(treeBean);
        return list;
    }

    @Override
    public UserBean queryUserByName(String userCode) {
        return null;
    }

    @Override
    public HashMap<String, Object> queryUser(Integer page, Integer rows, UserBean userBean) {
        return null;
    }

    @Override
    public void addUser(UserBean userBean) {

    }
}
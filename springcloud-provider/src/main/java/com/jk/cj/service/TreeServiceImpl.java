/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: TreeServiceImpl
 * Author:   崔健
 * Date:     2019/5/1 14:21
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.service;

import com.jk.cj.mapper.TreeMapper;
import com.jk.cj.model.TreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
@Service
public class TreeServiceImpl implements TreeService{

    @Autowired
    private TreeMapper treeMapper;
    //递归树
    @Override
    public List<TreeBean> getMyTree(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //UserBean user = (UserBean) session.getAttribute(session.getId());
        //Integer userId = user.getId();
        //System.out.println(userId);
        return getNode(0,1);
    }

    /** <pre>getNode(这里用一句话描述这个方法的作用)
     * 创建人：崔健
     * 创建时间：2019年1月26日 下午3:15:07
     * 修改人：崔健
     * 修改时间：2019年1月26日 下午3:15:07
     * 修改备注： </pre>
     */
    private List<TreeBean> getNode(Integer id,Integer userId) {
        List<TreeBean> trees=treeMapper.getMyTree(id,userId);
        for (TreeBean treeBean : trees) {
            Integer id2 = treeBean.getId();
            List<TreeBean> node = getNode(id2,userId);
            treeBean.setChildren(node);
        }
        return trees;
    }
}
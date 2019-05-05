/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: TreeService
 * Author:   崔健
 * Date:     2019/5/1 14:20
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.service;

import com.jk.cj.model.TreeBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
public interface TreeService {

    List<TreeBean> getMyTree(HttpServletRequest request);
}
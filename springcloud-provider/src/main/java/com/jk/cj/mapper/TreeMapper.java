/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: TreeMapper
 * Author:   崔健
 * Date:     2019/5/1 14:25
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.mapper;

import com.jk.cj.model.TreeBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
@Mapper
public interface TreeMapper {

    List<TreeBean> getMyTree(Integer id, Integer userId);
}
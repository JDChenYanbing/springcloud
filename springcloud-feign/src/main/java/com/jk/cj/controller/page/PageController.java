/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: PageController
 * Author:   崔健
 * Date:     2019/5/1 15:34
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
@Controller
public class PageController {

    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    //登陆页面
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    //403页面
    @RequestMapping("403")
    public String error() {
        return "403";
    }

    //用户展示页面
    @RequestMapping("toShowUser")
    public String toShowUsers(){
        return "showUser";
    }
}
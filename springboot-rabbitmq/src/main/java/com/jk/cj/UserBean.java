/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: UserBean
 * Author:   崔健
 * Date:     2019/5/3 19:37
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/3
 * @since 1.0.0
 */
public class UserBean implements Serializable {


    private static final long serialVersionUID = 1115017573381419439L;

    private Integer id;
    private String  userName;
    private String  password;
    private String  phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
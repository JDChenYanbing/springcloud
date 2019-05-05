/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: TreeBean
 * Author:   崔健
 * Date:     2019/5/1 14:05
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.model.tree;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
public class TreeBean implements Serializable {

    private static final long serialVersionUID = -2267255356420197093L;

    private Integer id;
    private String  text;
    private String  url;
    private Integer pid;
    private String  state;
    private List<TreeBean> children;
    private Boolean checked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<TreeBean> getChildren() {
        return children;
    }

    public void setChildren(List<TreeBean> children) {
        this.children = children;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "TreeBean{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", state='" + state + '\'' +
                ", children=" + children +
                ", checked=" + checked +
                '}';
    }
}
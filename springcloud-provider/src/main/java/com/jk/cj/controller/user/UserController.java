/**
 * Copyright (C), 2019, 崔氏集团
 * FileName: UserController
 * Author:   崔健
 * Date:     2019/5/1 16:16
 * History:
 * yqj          <time>          <version>          <desc>
 * 修改时间           版本号              描述
 */
package com.jk.cj.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.jk.cj.model.user.UserBean;
import com.jk.cj.service.user.UserService;
import com.jk.cj.utils.HttpClientUtil;
import com.jk.cj.utils.MD5Util;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 〈一句话功能简述〉<br> 
 * @author RupertCui
 * @create 2019/5/1
 * @since 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("queryUserByName")
    public UserBean queryUserByName(@RequestParam("userName")String userName){
        return userService.queryUserByName(userName);
    }

    @PostMapping("queryUser")
    public HashMap<String,Object> queryUser(@RequestParam("page") Integer page,@RequestParam("rows")  Integer rows, @RequestBody UserBean userBean){
        return userService.queryUser(page,rows,userBean);
    }

    @PostMapping("addUser")
    public void addUser(@RequestBody UserBean userBean){
        userService.addUser(userBean);
    }

    public static final String PHONEIP="https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
    @RabbitListener(queues = "1809b-user")
    public void receiveOrder(String mes) throws MessagingException {

        UserBean user = JSONObject.parseObject(mes, UserBean.class);
        //--------------------------发送短信-------------------------------
        HashMap<String, Object> params = new HashMap<String, Object>();


        params.put("accountSid", "a766df41026644c9b137c3a6ed51e363");
        params.put("templateid","1459487571");
        params.put("to", user.getPhone());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time =  sdf.format(new Date());
        params.put("timestamp", time);
        String i ="a766df41026644c9b137c3a6ed51e363"+"54a4dcd74f8d459596d0078724d74ea1"+time;
        String md532 = MD5Util.getMd532(i);
        params.put("sig", md532);
        String yzm="您购买的XXXX已成功提交订单";
        params.put("param",yzm);

        // session.setAttribute("phoneyzm", yzm);
        String post = HttpClientUtil.post(PHONEIP, params);
        System.out.println(post);

        //-------------------发送邮件-------------------------------------
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host","smtp.163.com");// smtp服务器地址

        Session session = Session.getInstance(props);
        session.setDebug(true);

        Message msg = new MimeMessage(session);
        msg.setSubject("test");
        msg.setText("您购买的XXXX已成功提交订单");
        msg.setFrom(new InternetAddress("2874055396qq.com"));//发件人邮箱
        msg.setRecipient(Message.RecipientType.TO,
                new InternetAddress(user.getEmail())); //收件人邮箱
        msg.saveChanges();

        Transport transport = session.getTransport();
        transport.connect("2874055396qq.com","1226711344sc");//发件人邮箱,授权码

        transport.sendMessage(msg, msg.getAllRecipients());

        System.out.println("邮件发送成功...");
        transport.close();
    }



}
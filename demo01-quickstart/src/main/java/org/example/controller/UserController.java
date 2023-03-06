package org.example.controller;

import org.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
// 类上方配置的RequestMapping与方法上面配置的RequestMapping连接在一起，形成完整的请求映射路径
@RequestMapping("/user")
public class UserController {

    // 设置映射路径 此时save方法的访问路径是：/user/save
    @RequestMapping("/save")
    // 设置当前操作返回结果为指定json数据（本质上是一个字符串信息）
    @ResponseBody
    public String save () {
        System.out.println("user save ...");
        return "{'info':'springmvc'}";
    }

    // 普通参数
    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age) {
        System.out.println("普通参数传递 name ==> "+name);
        System.out.println("普通参数传递 age ==> "+age);
        return "{'module':'common param'}";
    }

    // 请求参数名与形参变量名不同
    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    // @RequestParam绑定请求参数与处理器方法形参间的关系
    public String commonParamDifferentName(@RequestParam("name") String username, int age) {
        System.out.println("普通参数传递 userName ==> "+ username);
        System.out.println("普通参数传递 age ==> "+ age);
        return "{'module':'common param different name'}";
    }

    // POJO参数
    @RequestMapping("/pojoParam")
    @ResponseBody
    // 请求参数key的名称要和POJO中属性的名称一致，否则无法封装。
    public String pojoParam(User user) {
        System.out.println("pojo参数传递 user ==> "+ user);
        return "{'module':'pojo param'}";
    }

    // 嵌套POJO类型参数
    @RequestMapping("/containPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User user){
        System.out.println("pojo嵌套pojo参数传递 user ==> "+user);
        return "{'module':'pojo contain pojo param'}";
    }

    @RequestMapping("/listParamForJson")
    @ResponseBody
    // 1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    // 2.使用@RequestBody注解将外部传递的json数组数据映射到形参的集合对象中作为数据
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("list common(json)参数传递 list ==> "+likes);
        return "{'module':'list common for json param'}";
    }
    // 集合参数：json格式
    // 1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    // 2.使用@RequestBody注解将外部传递的json数组数据映射到形参的保存实体类对象的集合对象中，要求属性名称一一对应
    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> list){
        System.out.println("list pojo(json)参数传递 list ==> "+list);
        return "{'module':'list pojo for json param'}";
    }

    //响应页面/跳转页面
    //返回值为String类型，设置返回值为页面名称，即可实现页面跳转
    @RequestMapping("/toJumpPage")
    public String toJumpPage(){
        System.out.println("跳转页面");
        return "page.jsp";
    }

    // 响应POJO对象
    // 返回值为实体类对象，设置返回值为实体类类型，即可实现返回对应对象的json数据，
    // 需要依赖@ResponseBody注解和@EnableWebMvc注解
    @RequestMapping("/toJsonPOJO")
    @ResponseBody
    public User toJsonPOJO(){
        System.out.println("返回json对象数据");
        User user = new User();
        user.setName("周星驰");
        user.setAge(25);
        return user;
    }

    // 响应POJO集合对象
    // 返回值为集合对象，设置返回值为集合类型，即可实现返回对应集合的json数组数据，需要依赖@ResponseBody注解和@EnableWebMvc注解
    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList(){
        System.out.println("返回json集合数据");
        User user1 = new User();
        user1.setName("传智播客");
        user1.setAge(15);

        User user2 = new User();
        user2.setName("黑马程序员");
        user2.setAge(12);

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }

}

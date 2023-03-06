package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserRestFulController {

    @PostMapping
    @ResponseBody
    public String save(){
        System.out.println("user save...");
        return "{'module':'user save'}";
    }

    @PutMapping
    @ResponseBody
    public String update(){
        System.out.println("user update...");
        return "{'module':'user update'}";
    }

    @GetMapping
    @ResponseBody
    public String getAll(){
        System.out.println("user getAll...");
        return "{'module':'user getAll'}";
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    // @PathVariable注解用于设置路径变量（路径参数），要求路径上设置对应的占位符，并且占位符名称与方法形参名称相同
    // 如果不对应，那么需要在@PathVariable中指定占位符的名称 例如@PathVariable("id")
    public String delete(@PathVariable Integer id){
        System.out.println("user delete..." + id);
        return "{'module':'user delete'}";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getById(@PathVariable Integer id){
        System.out.println("user getById..."+id);
        return "{'module':'user getById'}";
    }

}

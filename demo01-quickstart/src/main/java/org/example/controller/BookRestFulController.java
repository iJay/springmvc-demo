package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
// 使用@RestController注解替换@Controller与@ResponseBody注解，简化书写
@RequestMapping("/books")
public class BookRestFulController {

    @PostMapping
    public String save(){
        System.out.println("book save...");
        return "{'module':'book save'}";
    }

    @PutMapping
    public String update(){
        System.out.println("book update...");
        return "{'module':'book update'}";
    }

    @GetMapping
    public String getAll(){
        System.out.println("book getAll...");
        return "{'module':'book getAll'}";
    }


    @DeleteMapping("/{id}")
    // @PathVariable注解用于设置路径变量（路径参数），要求路径上设置对应的占位符，并且占位符名称与方法形参名称相同
    // 如果不对应，那么需要在@PathVariable中指定占位符的名称 例如@PathVariable("id")
    public String delete(@PathVariable Integer id){
        System.out.println("book delete..." + id);
        return "{'module':'book delete'}";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("book getById..."+id);
        return "{'module':'book getById'}";
    }
}

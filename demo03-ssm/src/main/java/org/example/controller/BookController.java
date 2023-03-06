package org.example.controller;

import org.example.entity.Book;
import org.example.service.BookService;
import org.example.utils.BizCode;
import org.example.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseResult save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new ResponseResult(flag ? BizCode.SAVE_OK:BizCode.SAVE_ERR, flag);
    }

    @PutMapping
    public ResponseResult update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new ResponseResult(flag ? BizCode.UPDATE_OK:BizCode.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new ResponseResult(flag ? BizCode.DELETE_OK:BizCode.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        Integer code = book != null ? BizCode.GET_OK : BizCode.GET_ERR;
        String msg = book != null ? "" : "数据查询失败，请重试！";
        return new ResponseResult(code, book, msg);
    }

    @GetMapping
    public ResponseResult getAll() {
        List<Book> bookList = bookService.getAll();
        Integer code = bookList != null ? BizCode.GET_OK : BizCode.GET_ERR;
        String msg = bookList != null ? "" : "数据查询失败，请重试！";
        return new ResponseResult(code, bookList, msg);
    }
}

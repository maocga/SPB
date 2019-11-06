package com.skk.spb.controller;

import com.skk.spb.dao.BookDao;
import com.skk.spb.entity.Book;
import com.skk.spb.mapper.BookMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookDao bookDao;

    @Resource
    private BookMapper bookMapper;

    @Value("${t1.t2.t3}")
    private String title;

    @RequestMapping("/findAll")
    @ApiOperation(value = "查询所有的书籍信息",notes = "通过SpringDataJPA")
    @ApiImplicitParams({
            @ApiImplicitParam("返回至bookTable模板页面上"),
            @ApiImplicitParam(name = "booklist",value = "返回到模板的json数据"),
            @ApiImplicitParam(name = "t",value = "从配置文件获取的值")
    })
    public String findBook(Model model){
        List<Book> all = bookDao.findAll();
        model.addAttribute("booklist",all);
        model.addAttribute("t",title);
        return "bookTable";
    }

    @RequestMapping("/selectBook")
    @ResponseBody
    @ApiOperation(value = "查询所有的书籍信息",notes = "通过MyBatis")
    @ApiImplicitParams({
            @ApiImplicitParam("直接在页面打印")
    })
    public List<Book> findMBook(){
        List<Book> all = bookMapper.findAll();
        return all;
    }
}

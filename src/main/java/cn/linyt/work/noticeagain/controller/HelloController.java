package cn.linyt.work.noticeagain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/8 23:07
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class HelloController {

    @RequestMapping
    public String hello() {

        return "Hello, world!!!";
    }
}

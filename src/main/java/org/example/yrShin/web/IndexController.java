package org.example.yrShin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // mustache의 기본 경로 및 확장자는 자동으로 지정해준다.
    // 경로   : src/main/resources/templates
    // 확장자 : .mustache
    @GetMapping("/")
    public String index(){
        return "index";     // src/main/resources/templates/index.mustache      파일을 연결시켜준다
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}

package org.example.yrShin.web;

import lombok.RequiredArgsConstructor;
import org.example.yrShin.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    // mustache의 기본 경로 및 확장자는 자동으로 지정해준다.
    // 경로   : src/main/resources/templates
    // 확장자 : .mustache
//    @GetMapping("/")
//    public String index(){
//        return "index";     // src/main/resources/templates/index.mustache      파일을 연결시켜준다
//    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";     // src/main/resources/templates/index.mustache      파일을 연결시켜준다
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}

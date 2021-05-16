package org.example.yrShin.web;

import lombok.RequiredArgsConstructor;
import org.example.yrShin.config.auth.LoginUser;
import org.example.yrShin.config.auth.dto.SessionUser;
import org.example.yrShin.service.posts.PostsService;
import org.example.yrShin.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    // mustache의 기본 경로 및 확장자는 자동으로 지정해준다.
    // 경로   : src/main/resources/templates
    // 확장자 : .mustache
//    @GetMapping("/")
//    public String index(){
//        return "index";     // src/main/resources/templates/index.mustache      파일을 연결시켜준다
//    }
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

        //해당코드의 반복작업을 줄이기 위해 어노테이션으로 개선작업 진행 - 2021.05.16일 커밋
        //어느 컨트롤러든지 @LoginUser를 사용하면 세션정보를 가져올수 있음
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        return "index";     // src/main/resources/templates/index.mustache      파일을 연결시켜준다
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}

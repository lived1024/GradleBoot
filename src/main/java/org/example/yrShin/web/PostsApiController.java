package org.example.yrShin.web;

import lombok.RequiredArgsConstructor;
import org.example.yrShin.service.posts.PostsService;
import org.example.yrShin.web.dto.PostsResponseDto;
import org.example.yrShin.web.dto.PostsSaveRequestDto;
import org.example.yrShin.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PostMapping("/api/vi/posts/{id}")
    public Long update(@PathVariable Long id
                      , @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
package gdsc.edu.springstudy.web;

import gdsc.edu.springstudy.service.posts.PostsService;
import gdsc.edu.springstudy.web.dto.PostsResponseDto;
import gdsc.edu.springstudy.web.dto.PostsSaveRequestDto;
import gdsc.edu.springstudy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(
            @RequestBody PostsUpdateRequestDto requestDto,
            @PathVariable Long id) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}

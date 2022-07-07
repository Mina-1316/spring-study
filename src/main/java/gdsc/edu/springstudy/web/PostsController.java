package gdsc.edu.springstudy.web;

import gdsc.edu.springstudy.service.posts.PostsService;
import gdsc.edu.springstudy.web.dto.PostsResponseDto;
import gdsc.edu.springstudy.web.dto.PostsSaveRequestDto;
import gdsc.edu.springstudy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsController {
    private final PostsService postsService;

    // To Connect to H2 Database, you should find log that H2ConsoleAutoConfiguration emits.
    // That info log will say your H2 Database url.
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

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}

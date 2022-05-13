package gdsc.edu.springstudy.service.posts;

import gdsc.edu.springstudy.domain.posts.Posts;
import gdsc.edu.springstudy.domain.posts.PostsRepository;
import gdsc.edu.springstudy.web.dto.PostsResponseDto;
import gdsc.edu.springstudy.web.dto.PostsSaveRequestDto;
import gdsc.edu.springstudy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 서비스 메소드를 담아 두는 클래스
// 서비스 메소드는 트랙잭션과 도메인 간의 순서만 보장
// 비즈니스 로직은 도메인 레벨에서 처리
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto dto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(dto.getTitle(), dto.getContent());

        return id;
    }

    // Find by ID
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
}

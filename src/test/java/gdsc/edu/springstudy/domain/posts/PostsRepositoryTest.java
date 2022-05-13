package gdsc.edu.springstudy.domain.posts;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

//import assertj assertThat method
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    // Tests for Save/Gets post
    @Test @DisplayName("[Repository] 게시글 저장/불러오기")
    public void postSaveNGetTest() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("test")
                .build());

        //when
        List<Posts> posts = postsRepository.findAll();

        //then
        Posts posts1 = posts.get(0);
        assertThat(posts1.getTitle()).isEqualTo(title);
        assertThat(posts1.getContent()).isEqualTo(content);
    }

    // Tests for Timestamp
    @Test @DisplayName("[Repository] 게시글 게시/수정 시간 등록")
    public void postTimestampTest() {
        //given
        LocalDateTime now = LocalDateTime.now().minusSeconds(5);
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("test")
                .build());

        //when
        List<Posts> posts = postsRepository.findAll();

        //then
        Posts posts1 = posts.get(0);

        System.out.println("현재 시간: " + now);
        System.out.println("DB에 작성된 시간: " + posts1.getCreatedDate());
        System.out.println("DB에서 수정된 시간: " + posts1.getModifiedDate());

        assertThat(posts1.getCreatedDate()).isAfterOrEqualTo(now);
        assertThat(posts1.getModifiedDate()).isAfterOrEqualTo(now);
    }
}
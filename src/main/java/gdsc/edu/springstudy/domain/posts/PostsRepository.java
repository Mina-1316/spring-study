package gdsc.edu.springstudy.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    // Return list of Posts.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    public List<Posts> findAllDesc();

}

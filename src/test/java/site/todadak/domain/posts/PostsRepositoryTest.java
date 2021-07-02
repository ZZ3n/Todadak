package site.todadak.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {

    }

    @Test
    public void saveAndGetPost() {
        String title = "제목";
        String content = "content content content";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("ndsrhkd@naver.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.stream().findFirst().orElseThrow();
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo("ndsrhkd@naver.com");

    }

    @Test
    public void storeBaseTimeEntity() {
        //given
        LocalDateTime now = LocalDateTime.now().minusSeconds(1L);
        postsRepository.save(Posts.builder()
                .title("제목1")
                .content("내용 내용")
                .author("ndsrhkd@naver.com")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createdDate=" + posts.getCreatedDate() + ", modifiedDate" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getCreatedDate()).isAfter(now);
    }


}
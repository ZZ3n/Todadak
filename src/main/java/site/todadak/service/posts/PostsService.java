package site.todadak.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.todadak.domain.posts.Posts;
import site.todadak.domain.posts.PostsRepository;
import site.todadak.web.dto.PostsResponseDto;
import site.todadak.web.dto.PostsSaveRequestDto;
import site.todadak.web.dto.PostsUpdateRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts post = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
        );

        post.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
        );

        return new PostsResponseDto(post);
    }
}

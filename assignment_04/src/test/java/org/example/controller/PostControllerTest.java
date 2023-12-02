package org.example.controller;

import org.example.delete.back.controller.PostController;
import org.example.delete.back.dto.request.DeletePostRequest;
import org.example.delete.back.dto.request.SavePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostControllerTest {
    private PostController postController;

    @BeforeEach
    void setUp() {
        this.postController = new PostController();
    }

    @Test
    void 게시판_저장_테스트() {
        String title = "테스트 타이블 삽입";
        String content = "테스트 내용 삽입";
        Integer id = 8;
        SavePostRequest savePostRequest = SavePostRequest.builder()
                .title(title)
                .content(content)
                .memberId(id)
                .build();

        Boolean result = postController.savePost(savePostRequest);

        assertThat(result).isTrue();
    }

    @Test
    void 게시판_삭제_id() {
        Integer postId = 7;
        DeletePostRequest deletePostRequest = new DeletePostRequest(postId);

        Boolean result = postController.deletePostByPostId(deletePostRequest);

        assertThat(result).isTrue();
    }
}
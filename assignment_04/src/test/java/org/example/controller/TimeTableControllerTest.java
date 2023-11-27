package org.example.controller;

import org.example.back.constant.ImageUrl;
import org.example.back.controller.TimeTableController;
import org.example.back.dto.request.DeleteTimeTableRequest;
import org.example.back.dto.request.SaveTimeTableRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimeTableControllerTest {
    private TimeTableController timeTableController;

    @BeforeEach
    void setUp() {
        timeTableController = new TimeTableController();
    }

    @Test
    void 이미지_테이블_사진_추가() {
        String imagePath = ImageUrl.IMAGE_URL_ROOT.getUrl() + "/insert_test_image.png";
        SaveTimeTableRequest saveTimeTableRequest = SaveTimeTableRequest.builder()
                .memberId(1)
                .image(imagePath)
                .build();

        Boolean result = timeTableController.saveTimeTable(saveTimeTableRequest);

        assertThat(result).isTrue();
    }

    @Test
    void 이미지_테이블_사진_삭제() {
        Integer id = 2;
        DeleteTimeTableRequest deleteTimeTableRequest = new DeleteTimeTableRequest(id);

        Boolean result = timeTableController.deleteTimeTableById(deleteTimeTableRequest);

        assertThat(result).isTrue();
    }
}
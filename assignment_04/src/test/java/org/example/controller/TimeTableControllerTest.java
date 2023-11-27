package org.example.controller;

import org.example.constant.ImageUrl;
import org.example.dto.request.SaveTimeTableRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
                .id(1)
                .image(imagePath)
                .build();

        Boolean result = timeTableController.saveTimeTable(saveTimeTableRequest);

        assertThat(result).isTrue();
    }
}
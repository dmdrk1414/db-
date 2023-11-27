package org.example.back.constant;

import lombok.*;

@Getter
public enum ImageUrl {
    IMAGE_URL_ROOT("resources/image");

    private final String url;

    ImageUrl(String url) {
        this.url = url;
    }
}

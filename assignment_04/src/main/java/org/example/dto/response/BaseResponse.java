package org.example.dto.response;

public class BaseResponse {

    public static String applyOk() {
        return "가입 완료";
    }

    public String applyNo() {
        return "가입 실패";
    }
}

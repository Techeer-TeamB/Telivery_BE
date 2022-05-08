package com.telivery.common.exception;

import lombok.Getter;

@Getter
public enum ErrorStatus {

    /* 예시 */
    NO_DATA_IN_DB(-1, "데이터베이스에 값이 존재하지 않습니다."),
    OMISSION_REQUIRE_PARAM(-2, "request 파라미터가 누락되었습니다."),

    /* User */
    USER_NOT_FOUND(-100, "존재하지 않는 user 입니다");


    private final int code;
    private final String message;

    ErrorStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

}

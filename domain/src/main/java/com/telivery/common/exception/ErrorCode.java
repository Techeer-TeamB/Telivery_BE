package com.telivery.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /* 예시 */
    NO_DATA_IN_DB(-1, "데이터베이스에 값이 존재하지 않습니다."),
    OMISSION_REQUIRE_PARAM(-2, "request 파라미터가 누락되었습니다."),

    /* User */
    USER_NOT_FOUND(-100, "존재하지 않는 user 입니다"),

    /* Restaurant */
    RESTAURANT_ID_NOT_FOUND(-200, "존재하지 않는 restaurant 입니다."),

    /* Menu */
    MENU_ID_NOT_FOUND(-300, "존재하지 않는 메뉴 입니다."),
    NO_MENU_IN_RESTAURANT(-301, "요청 식당에 메뉴가 존재하지 않습니다."),

    /* Time */
    TIME_NOT_FOUND(-400, "가게에 영업시간 정보가 존재하지 않습니다.");


    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}

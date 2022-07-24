package com.telivery.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /* 예시 */
    NO_DATA_IN_DB(-1, "데이터베이스에 값이 존재하지 않습니다."),
    OMISSION_REQUIRE_PARAM(-2, "request 파라미터가 누락되었습니다."),

    /* User */
    USER_NOT_FOUND(-100, "존재하지 않는 user 입니다"),
    TOKEN_NOT_FOUND(-101, "토큰이 존재하지 않습니다."),
    EXPIRED_TOKEN(-102, "만료된 토큰입니다."),
    USER_ACCESS_DENIED(-103, "사용자에게 필요 권한이 존재하지 않습니다."),
    USERNAME_DUPLICATE(-104, "이미 존재하는 ID 입니다."),
    NAME_DUPLICATE(-105, "이미 존재하는 이름 입니다."),
    INPUT_PASSWORD_WRONG(-106, "비밀번호가 틀립니다."),
    INTERNAL_AUTHENTICATE_FAILED(-107, "내부 인증 관련 처리에 실패했습니다."),

    /* Restaurant */
    RESTAURANT_ID_NOT_FOUND(-200, "존재하지 않는 restaurant 입니다."),

    /* Menu */
    MENU_ID_NOT_FOUND(-300, "존재하지 않는 메뉴 입니다."),
    NO_MENU_IN_RESTAURANT(-301, "요청 식당에 메뉴가 존재하지 않습니다."),
    NO_OPTION_IN_MENU(-302, "요청 메뉴에 옵션이 존재하지 않습니다."),

    /* Time */
    TIME_NOT_FOUND(-400, "가게에 영업시간 정보가 존재하지 않습니다."),

    /* Order, Order_list, Order_menu */
    ORDER_ID_NOT_FOUND(-500, "존재하지 않는 주문 입니다."),
    IS_NOT_USER_ORDER(-501, "요청한 유저의 주문이 아닙니다."),

    /* Review */
    ORDER_REVIEW_ALREADY_EXISTS(-600, "요청 주문에 대한 리뷰가 이미 존재합니다.");


    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}

package com.pixellive.common.exception;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    INVALID_COORDINATE(HttpStatus.BAD_REQUEST, "C001", "캔버스 범위를 벗어난 좌표입니다."),
    INVALID_COLOR_CODE(HttpStatus.BAD_REQUEST, "C002", "유효하지 않은 색상 코드입니다. (0~15)"),
    COOLDOWN_ACTIVE(HttpStatus.TOO_MANY_REQUESTS, "C003", "아직 픽셀을 찍을 수 없습니다. 잠시 후 다시 시도해주세요."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "S001", "서버 내부 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
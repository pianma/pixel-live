package com.pixellive.common.constant;

/**
 * 캔버스 도메인 상수 — RGB 풀컬러 버전
 *
 * 저장 방식: Redis String (byte array)
 * 픽셀당 3바이트 (R, G, B)
 * 전체 용량: 1,000,000 픽셀 × 3byte = 3,000,000 byte ≈ 3MB
 *
 * Redis 연산:
 *  - 전체 읽기 : GET pixel:canvas
 *  - 픽셀 쓰기 : SETRANGE pixel:canvas {offset} {3byte}
 *  - 픽셀 읽기 : GETRANGE pixel:canvas {offset} {offset+2}
 */
public final class CanvasConstants {

    private CanvasConstants() {}

    // ── 캔버스 크기 ──────────────────────────────────────────
    public static final int CANVAS_WIDTH  = 1000;
    public static final int CANVAS_HEIGHT = 1000;
    public static final int TOTAL_PIXELS  = CANVAS_WIDTH * CANVAS_HEIGHT; // 1,000,000

    // ── RGB 색상 ─────────────────────────────────────────────
    /** 픽셀당 바이트 수 (R, G, B 각 1바이트) */
    public static final int BYTES_PER_PIXEL = 3;

    /** 전체 캔버스 바이트 크기 (3MB) */
    public static final int CANVAS_TOTAL_BYTES = TOTAL_PIXELS * BYTES_PER_PIXEL; // 3,000,000

    /** 색상 채널 범위 */
    public static final int COLOR_CHANNEL_MIN = 0;
    public static final int COLOR_CHANNEL_MAX = 255;

    /** 초기 캔버스 색상 — 흰색 (255, 255, 255) */
    public static final byte INITIAL_COLOR_VALUE = (byte) 0xFF;

    // ── Rate Limiting ─────────────────────────────────────────
    /** 유저당 픽셀 배치 쿨타임 (초) */
    public static final long COOLDOWN_SECONDS = 10L;

    // ── Redis Key ─────────────────────────────────────────────
    /** 캔버스 전체 데이터 (3MB byte array) */
    public static final String REDIS_KEY_CANVAS           = "pixel:canvas";

    /** 유저 쿨타임: pixel:cooldown:{userId} */
    public static final String REDIS_KEY_COOLDOWN_PREFIX  = "pixel:cooldown:";

    /** 픽셀 업데이트 브로드캐스트 채널 */
    public static final String REDIS_CHANNEL_UPDATES      = "pixel:updates";
}
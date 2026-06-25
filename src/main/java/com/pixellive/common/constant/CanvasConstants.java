package com.pixellive.common.constant;

public class CanvasConstants {
    public static final int CANVAS_WIDTH = 1000;
    public static final int CANVAS_HEIGHT = 1000;

    public static final int BIT_PER_PIXEL = 4; // 1픽셀당 4비트 (0~15 색상)
    public static final int MAX_COLOR_VALUE = 15;

    public static final String REDIS_CANVAS_KEY = "pixel:canvas";
    public static final String REDIS_PUBSUB_TOPIC = "pixel:updates";
}

package com.std.wlbdevelop.mediaplayer;

/**
 * Created by WLBDEVELOP on 2017/12/6.
 */

public class Options {
    public static String pushUrl = "rtmp://192.168.0.110/live/test1";
    public static String fetchUrl = "rtmp://192.168.0.110/live/test";
    public static int bufferTime = 300;
    public static int maxBufferTime = 1000;

    public static void setPushUrl(String str) {
        pushUrl = str;
    }

    public static void setFetchUrl(String str) {
        fetchUrl = str;
    }

    public static void setBufferTime(int buffer) {
        bufferTime = buffer;
    }

    public static void setMaxBufferTime(int buffer) {
        maxBufferTime = buffer;
    }
}

package com.tamerb.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public record ApiResponse(boolean success, String message) {

    public String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Istanbul"));
        return sdf.format(new Date());
    }
}

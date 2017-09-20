package com.kocomer.iot.entity;

/**
 * Created by kocomer on 2017/9/15.
 */

public class BlackEntity {
    public BlackDetail[] blackDetails;

    public void createBlackDetail(int length) {
        blackDetails = new BlackDetail[length];
        for (int i = 0; i < length; i++) {
            blackDetails[i] = new BlackDetail();
        }
    }

    public class BlackDetail {
        public String id;
        public String cm;
        public String date;
    }
}

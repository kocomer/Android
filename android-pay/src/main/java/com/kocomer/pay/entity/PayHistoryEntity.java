package com.kocomer.pay.entity;

/**
 * Created by kocomer on 2017/7/21.
 */

public class PayHistoryEntity {
    public PayHistory[] payHistories;

    public void createPayHistory(int length) {
        payHistories = new PayHistory[length];
        for (int i = 0; i < length; i++) {
            payHistories[i] = new PayHistory();
        }
    }

    public class PayHistory {
        public String paySource;
        public String money;
        public String desc;
        public String remark;
        public String extend;
        public String date;
    }
}

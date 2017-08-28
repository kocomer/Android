package com.kocomer.pay.entity;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kocomer on 2017/8/17.
 */

public class PayListEntity {
    public long results;
    public PayListItem[] payListItems;

    public void createPayListItems(int length) {
        payListItems = new PayListItem[length];
        for (int i = 0; i < length; i++) {
            payListItems[i] = new PayListItem();
        }
    }

    public class PayListItem {
        public String id;
        public String date;
        public String money;
        public String type;
        public String remark;
        public String status;
        public String refund;
        public String source;
    }
}

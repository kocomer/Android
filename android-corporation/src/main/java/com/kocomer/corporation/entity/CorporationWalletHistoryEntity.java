package com.kocomer.corporation.entity;

/**
 * Created by kocomer on 2017/7/20.
 */

public class CorporationWalletHistoryEntity {
    public CorporationWalletHistory[] corporationWalletHistories;

    public void createCorporationWalletHistory(int length) {
        corporationWalletHistories = new CorporationWalletHistory[length];
        for (int i = 0; i < length; i++) {
            corporationWalletHistories[i] = new CorporationWalletHistory();
        }
    }

    public class CorporationWalletHistory {
        public String date;
        public String money;
        public String desc;
        public String extend;
        public String remark;

    }
}

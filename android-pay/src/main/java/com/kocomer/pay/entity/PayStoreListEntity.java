package com.kocomer.pay.entity;

/**
 * Created by kocomer on 2017/9/22.
 */

public class PayStoreListEntity {
    public PayStore[] payStores;

    public void createPayStore(int length) {
        payStores = new PayStore[length];
        for (int i = 0; i < length; i++) {
            payStores[i] = new PayStore();
        }
    }

    public class PayStore {
        public String id;
        public String name;
        public String status;

    }
}

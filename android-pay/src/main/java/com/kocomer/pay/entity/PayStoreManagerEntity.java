package com.kocomer.pay.entity;

/**
 * Created by kocomer on 2017/10/13.
 */

public class PayStoreManagerEntity {
    public PayStore[] payStores;
    public PayRole[] payRoles;

    public void createPayRole(int length) {
        payRoles = new PayRole[length];
        for (int i = 0; i < length; i++) {
            payRoles[i] = new PayRole();
        }
    }

    public class PayRole {
        public long id;
        public String name;
    }

    public void createPayStore(int length) {
        payStores = new PayStore[length];
        for (int i = 0; i < length; i++) {
            payStores[i] = new PayStore();
        }
    }

    public class PayStore {
        public long id;
        public String name;
    }
}

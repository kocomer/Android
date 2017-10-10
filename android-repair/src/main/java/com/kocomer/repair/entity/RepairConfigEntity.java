package com.kocomer.repair.entity;

/**
 * Created by kocomer on 2017/9/20.
 */

public class RepairConfigEntity {
    public RepairConfig[] repairConfigs;

    public void createRepairConfig(int length) {
        repairConfigs = new RepairConfig[length];
        for (int i = 0; i < length; i++) {
            repairConfigs[i] = new RepairConfig();
        }
    }

    public class RepairConfig {
        public String id;
        public String img;//能力
        public String name;//名称

        public boolean available;//是否可用
    }
}

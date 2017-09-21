package com.kocomer.repair.entity;

/**
 * Created by kocomer on 2017/9/21.
 */

public class RepairTaskEntity {
    public Task[] tasks;

    public void crateTask(int length) {
        tasks = new Task[length];
        for (int i = 0; i < length; i++) {
            tasks[i] = new Task();
        }
    }

    public class Task {
        public String clazz;
        public String subclazz;
        public String describe;
        public String image;
        public String date;
        public String remark;
    }
}

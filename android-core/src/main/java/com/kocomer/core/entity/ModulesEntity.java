package com.kocomer.core.entity;

/**
 * Created by kocomer on 2017/3/24.
 */

public class ModulesEntity {
    public Module[] module;

    public class Module {
        public String code;
        public String name;
        public String text;
    }

    public void createModule(int length) {
        module = new Module[length];
        for (int i = 0; i < length; i++) {
            module[i] = new Module();
        }
    }
}

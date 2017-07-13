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
        public Cell[] cells;

        /**
         * 创建内容
         *
         * @param length
         */
        public void createCell(int length) {
            cells = new Cell[length];
            for (int i = 0; i < length; i++) {
                cells[i] = new Cell();
            }
        }

        public class Cell {
            public String code;
            public String name;
            public String text;
        }
    }


    /**
     * 创建模块
     *
     * @param length
     */
    public void createModule(int length) {
        module = new Module[length];
        for (int i = 0; i < length; i++) {
            module[i] = new Module();
        }
    }
}

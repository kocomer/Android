package com.kocomer.core.entity;

/**
 * Created by kocomer on 2017/3/28.
 */

public class CellsEntity {
    public Cell[] cell;

    public class Cell {

        public String name;

        public String url;

        public String code;

        public String background;

        public String color;

        public String icon;

        public String text;

        public String desc;
    }

    public void createCell(int length) {
        cell = new CellsEntity.Cell[length];
        for (int i = 0; i < length; i++) {
            cell[i] = new CellsEntity.Cell();
        }
    }
}

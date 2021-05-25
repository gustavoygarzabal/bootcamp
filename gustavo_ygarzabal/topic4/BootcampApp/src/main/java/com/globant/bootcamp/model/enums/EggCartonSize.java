package com.globant.bootcamp.model.enums;

public enum EggCartonSize {
    MAPLE(6, 5),
    DOZEN(2, 6),
    HALF_DOZEN(2,3);

    private final int lines;
    private final int columns;

    EggCartonSize(int lines, int columns) {
        this.lines= lines;
        this.columns= columns;

    }

    public int getLines (){
        return lines;
    }

    public int getColumns () {
        return columns;
    }

}

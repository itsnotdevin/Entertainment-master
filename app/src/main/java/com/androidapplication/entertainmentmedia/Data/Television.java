package com.androidapplication.entertainmentmedia.Data;

import java.io.Serializable;

/**
 * Created by ahmed on 11/7/2017.
 * fixed/updatted 11-28 Devin
 */

public class Television extends Movie implements Serializable {
    private int series_number;

    public Television(){}

    public int getSeries_number() {
        return series_number;
    }

    public void setSeries_number(int series_number) {
        this.series_number = series_number;
    }

}


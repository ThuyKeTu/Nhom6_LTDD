package com.example.ltdd.Model;

import java.sql.Array;

public class phantichthuchi {
    public int thanhtoan;
    public int dichuyen;
    public int doan;
    public int cuahang;

    public phantichthuchi(int thanhtoan, int dichuyen, int doan, int cuahang) {
        this.thanhtoan = thanhtoan;
        this.dichuyen = dichuyen;
        this.doan = doan;
        this.cuahang = cuahang;
    }

    public int[] datatoarray(){
        int[] array = new int[4];
        array[0] = this.thanhtoan;
        array[1] = this.dichuyen;
        array[2] = this.doan;
        array[3] = this.cuahang;

        int tg;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] < array[j]){
                    tg = array[i];
                    array[i] = array[j];
                    array[j] = tg;
                }
            }
        }

        return array;

    }
}

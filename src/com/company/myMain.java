package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class myMain {

    public static void main(String[] args) {

        Map testMap = new Map();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.println(Arrays.toString(testMap.getCell(i, j).getSimpleInfo()));

            }
        }
//        cell test=new cell();
//        System.out.println(Arrays.toString(test.getSimpleInfo()));

    }
}

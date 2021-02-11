package com.softeq.avizhen.main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class TrainingMain {

    public static void main(String[] args) {

        String string = "all zip files are zipped";
        System.out.println(findZip(string));


    }

    public static int findZip(String str) {
        int firstZipIndex = 0;
        int secondZipIndex = 0;
        int countZip = 0;
        int countStart = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.contains("zip")) {
                firstZipIndex = i;
                countZip++;
                if (countZip == 2) {
                    for (int j = firstZipIndex; j < str.length(); j++) {
                        if (str.contains("zip")) {
                            secondZipIndex = i;
                        }

                    }
                }

            }



        }
        return secondZipIndex;
    }
}


//    int k = 0;
//    String[] split = str.split(" ");
//    List<String> list = new ArrayList<>();
//list.addAll(Arrays.asList(split));
//        Collections.sort(list, new Comparator<String>() {
//@Override
//public int compare(String o1, String o2) {
//        return o1.length() - o2.length();
//        }
//        });
//        StringBuilder stringsBuilder = new StringBuilder();
//
//        for (String s : list) {
//        stringsBuilder.append(s);
//        stringsBuilder.append(" ");
//        }
//        stringsBuilder.deleteCharAt(stringsBuilder.length() - 1);
//        return stringsBuilder.toString();


//public static int findOdd(int[] arr) {
//        int minOdd = 0;
//        int count ;
//        if (arr.length < 2) {
//        return arr[0];
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//        count = 0;
//        for (int j = 0; j < arr.length; j++) {
//        if (arr[i] == arr[j]) {
//        count++;
//        if (count % 2 != 0) {
//        minOdd = arr[i];
//        }
//        minOdd = 0;
//
//        }
//        }
//        }
//        return minOdd;






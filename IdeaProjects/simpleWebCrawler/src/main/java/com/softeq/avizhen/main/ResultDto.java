package com.softeq.avizhen.main;

import java.util.Comparator;

/**
 * Created by Александр on 04.01.2021.
 */
public class ResultDto implements Comparable<ResultDto> {
    private String targetWord;
    private int count;

    public ResultDto(String targetWord, int count) {
        this.targetWord = targetWord;
        this.count = count;
    }

    public String getTargetWord() {
        return targetWord;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "targetWord='" + targetWord + '\'' +
                ", count=" + count +
                '}';
    }

    public int compareTo(ResultDto o) {
        return targetWord.compareTo(o.getTargetWord());
    }
}

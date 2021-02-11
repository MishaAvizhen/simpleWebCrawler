package com.softeq.avizhen.main;

public class SearchResult {

    private int leftResult;
    private int rightResult;

    public SearchResult(int leftResult, int rightResult) {

        this.leftResult = leftResult;
        this.rightResult = rightResult;
    }

    public int getLeftResult() {
        return leftResult;
    }

    public int getRightResult() {
        return rightResult;
    }


}

package com.softeq.avizhen.main;


public class Main {


    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 1, 2};
        Main main = new Main();
        int i = main.maxUp(nums1);
        System.out.println("SubArray length: " + i);
        SearchResult result = main.maxSubArr(nums1);
        for (int j = result.getLeftResult(); j < result.getRightResult(); j++) {
            System.out.print(nums1[j] + ", ");
        }
    }

    public SearchResult maxSubArr(int[] arrToCheck) {
        int localMax = 1;
        int globalMax = 0;
        int localLeft = 0;
        int globalLeft = 0;
        if (arrToCheck.length < 2) {
            return new SearchResult(0, arrToCheck.length);
        }
        for (int i = 1; i < arrToCheck.length; i++) {

            if (arrToCheck[i - 1] < arrToCheck[i]) {
                localMax++;
            } else {
                if (globalMax < localMax) {
                    globalMax = localMax;
                    globalLeft = localLeft;
                }
                localMax = 1;
                localLeft = i;
            }
        }
        if (globalMax < localMax) {
            globalMax = localMax;
            globalLeft = localLeft;
        }
        return new SearchResult(globalLeft, globalLeft + globalMax);
    }

    public int maxUp(int[] nums1) {
        int localMax = 1;
        int globalMax = 0;
        if (nums1.length < 2) {
            return nums1.length;
        }

        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i - 1] < nums1[i]) {
                localMax++;
            } else {
                if (globalMax < localMax) {
                    globalMax = localMax;
                }
                localMax = 1;
            }
        }
        if (globalMax < localMax) {
            globalMax = localMax;
        }
        return globalMax;
    }
}




















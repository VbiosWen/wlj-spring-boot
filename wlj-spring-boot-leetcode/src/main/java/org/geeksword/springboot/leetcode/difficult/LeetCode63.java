package org.geeksword.springboot.leetcode.difficult;

public class LeetCode63 {


    public static void main(String[] args){

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        return obstacleGrid[n-1][m-1];
    }
}

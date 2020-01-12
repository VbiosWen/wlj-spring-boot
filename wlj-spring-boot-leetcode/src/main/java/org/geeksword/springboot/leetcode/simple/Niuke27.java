package org.geeksword.springboot.leetcode.simple;

import java.util.ArrayList;
import java.util.Stack;

public class Niuke27 {

    public static void main(String[] args){

    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(matrix == null){
            return arrayList;
        }

        int start = 0;
        int xLength = matrix[0].length;
        int yLength = matrix.length;
        while (xLength > start * 2 && yLength > start * 2){
            this.apppendListMatrix(arrayList,matrix,xLength,yLength,start);
            start++;
        }
        return arrayList;
    }

    private void apppendListMatrix(ArrayList<Integer> arrayList, int[][] matrix, int xLength, int yLength, int start) {
        int endX = xLength - 1 -start;
        int endY = yLength - 1 - start;
        for(int i = start;i<=endX;i++){
            arrayList.add(matrix[start][i]);
        }
        if(start < endY){
            for(int i = start + 1; i <=endY;i++){
                arrayList.add(matrix[i][endX]);
            }
        }
        if(start < endX && start < endY){
            for(int i = endX -1 ; i>= start; i--){
                arrayList.add(matrix[endY][i]);
            }
        }

        if(start < endX && start < endY - 1){
            for(int i = endY - 1; i>=start + 1;i--){
                arrayList.add(matrix[i][start]);
            }
        }
    }
}

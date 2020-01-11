package org.geeksword.springboot.leetcode.simple;

public class Niuke20 {

    StringBuilder stringBuilder = new StringBuilder();
    int[] charCnt = new int[256];



    public void Insert(char ch)
    {
        stringBuilder.append(ch);
        charCnt[ch] ++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] chars = stringBuilder.toString().toCharArray();
        for (char aChar : chars) {
            if(charCnt[aChar] == 1){
                return aChar;
            }
        }
        return '#';
    }
}

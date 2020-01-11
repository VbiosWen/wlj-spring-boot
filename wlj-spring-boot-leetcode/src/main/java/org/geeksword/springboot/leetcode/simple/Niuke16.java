package org.geeksword.springboot.leetcode.simple;

public class Niuke16 {

    public static void main(String[] args){
        String s = new Niuke16().ReverseSentence(" ");
        System.out.println(s);
    }

    public String ReverseSentence(String str) {
        if(str == null || str.isEmpty()){
            return str;
        }

        String[] split = str.split(" ");
        if(split.length <= 1){
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int j = split.length - 1; j >= 0;j--){
            stringBuilder.append(split[j]);
            if(j != 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}

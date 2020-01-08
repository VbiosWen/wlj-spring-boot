package org.geeksword.springboot.leetcode.difficult;

public class ByteCode1 {

    public static void main(String[] args) {
        System.out.println(new ByteCode1().modify("wooooooooooooooooooooooooooooooow"));
    }

    public String modify(String word) {

        if (word == null || word.isEmpty()) {
            return word;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i< word.length(); i++){
            int len = stringBuilder.length();

            if(len < 2){
                stringBuilder.append(word.charAt(i));
                continue;
            }

            if(stringBuilder.charAt(len - 1) == word.charAt(i) && stringBuilder.charAt(len-2) == word.charAt(i)){
                continue;
            }
            if(len >=3){
                if(stringBuilder.charAt(len-1) == word.charAt(i) && stringBuilder.charAt(len -2) == stringBuilder.charAt(len -3)){
                    continue;
                }
            }
            stringBuilder.append(word.charAt(i));
        }

        return stringBuilder.toString();
    }
}

package org.geeksword.springboot.util;

public class Test {

    private static class KeyValue{
        int id;
        String value;
    }


    public static void main(String args){
        for(int i = 0 ; i < Integer.MAX_VALUE;i++){
            KeyValue keyValue = new KeyValue();
            keyValue.id = i;
            keyValue.value = String.valueOf(i);
        }
    }
}

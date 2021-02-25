package org.geeksword.springboot.util;

public class Test {

    private static class KeyValue{
        int id;
        String value;
    }


    public static void main(String[] args){
        int a = 16;
        int b = 7;
        System.out.println((a-1) & b);

        Integer intA = new Integer(10);
        final int i = intA.hashCode() ^ (intA.hashCode() >>> 16);
        System.out.println(intA.hashCode() >>> 16);
    }


}

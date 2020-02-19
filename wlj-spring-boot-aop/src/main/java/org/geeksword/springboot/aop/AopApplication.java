package org.geeksword.springboot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @wenliujie
 */
@SpringBootApplication
public class AopApplication<T> {

    public static void main(String[] args){

       Integer[][] integers = new Integer[][]{{1,2,3,4,5,6},{1,2}};
       Integer[][] integers1 = new Integer[][]{{1,2,3,4,5,6},{1,2}};
        boolean equals = isEquals(integers1, integers);
        String[] str1 = new String[100];
        Object[] obj = str1;

        System.out.println(equals);
        System.out.println(str1.getClass().getSuperclass());
    }


    /**
     * 判断两个数组是否相同
     * @param array1 第一个数组
     * @param array2 第二个数组
     * @param <T> 第一个数组的类型
     * @param <E> 第二个数组的类型
     * @return true，表示两个数组相同，false表示两个数组不同
     */
    public static <T,E> boolean isEquals(T[] array1, E[] array2){
        // 如果两个数组均为null，则返回true
        if(array1 == null && array2 == null){
            return true;
        }

        // 如果只有一个数组为null，则返回false
        if(array1 == null || array2 == null){
            return false;
        }

        // 如果两个数组的类不相同，则返回false
        if(!array1.getClass().equals(array2.getClass())){
            return false;
        }

        if(array1.equals(array2)){
            return true;
        }

        // 如果两个数组不相同，则返回false
        if(array1.length == 0 && array2.length !=0 || array1.length !=0 && array2.length ==0){
            return false;
        }
        // 进行值比较
        for(int i = 0 ; i< array1.length;i++){
            Object arr1 = array1[i];
            Object arr2= array2[i];
            if(arr1 instanceof Object[]){
                Object[] object1 = (Object[]) arr1;
                Object[] object2 = (Object[]) arr2;
                return isEquals(object1,object2);
            }

            if(!arr1.equals(arr2)){
                return false;
            }
        }
        return true;
    }
}

package org.geeksword.springboot.util.reflection;

import com.google.common.collect.Lists;

import java.time.Clock;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BeanUtils {

    public static <F,T> void copy(F fromBean,T toBean){
        if(Objects.isNull(fromBean)){
            throw new IllegalStateException("from bean must not be null.");
        }
        if(Objects.isNull(toBean)){
            throw new IllegalStateException("to bean must not be null.");
        }
        if(fromBean instanceof List){
            copyList(fromBean,toBean);
        }
    }

    @SuppressWarnings("all")
    private static <F, T> void copyList(F fromBean, T toBean) {
        List fromBeanList = (List) fromBean;
        List toBeanList = (List) toBean;
        List<F> list = Lists.newArrayListWithCapacity(((List) fromBean).size());
        for (Object obj : fromBeanList) {
            if(obj instanceof List){
                copyList(fromBean,toBean);
            }else if(obj instanceof Map){
                copyMap(fromBean,toBean);
            }else if(obj instanceof Integer){
                Integer intVal = (Integer) obj;
                list.add((F) intVal);
            }
        }
    }

    private static <F, T> void copyMap(F fromBean, T toBean) {

    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        copy(list,Lists.newArrayList());
    }
}

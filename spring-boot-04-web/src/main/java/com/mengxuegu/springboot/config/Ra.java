package com.mengxuegu.springboot.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ra {
    public static void main(String[] args) {
            // 初始化map集合中元素的个数
            int count = 1000000;
            Map<Integer,String> map = new HashMap<>();
            for (int i = 1; i <= count; i++) {
                map.put(i, i+ " ---> map");
            }

           Long startTime = System.currentTimeMillis();


        for (Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();iterator.hasNext(); ) {
           // Map.Entry<Integer,String> entry = iterator.next();
            //entry.getValue()
            System.out.println(iterator.next().getKey()+" 值："+iterator.next().getValue());
        }

       /* for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext();) {
            System.out.println(iterator.next()+" 值："+map.get(iterator.next()));
        }*/
        System.out.println("iteratorEntry 遍历 map耗时： "+(System.currentTimeMillis()-startTime)+ " ms");
    }


}

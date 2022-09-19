package com.ankang.utils;

import java.util.List;

public class SeparatePageUtil {

    public static Integer dataCount = 20; // 每页显示多少数据

    public static List<?> getSeparatePageData(List<?> listData, Integer page) {
        int start = page * dataCount;

        if(page == 1){
            return listData.subList(0,dataCount);
        }

        if(page * dataCount >= listData.size()){
           return listData.subList((int) Math.floor(listData.size()/dataCount)*dataCount,listData.size());
        }

        return listData.subList(start - 20 , start);
    }
}

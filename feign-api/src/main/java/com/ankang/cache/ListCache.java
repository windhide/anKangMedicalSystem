package com.ankang.cache;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListCache {

    private static final Map<String,List<?>> listCacheMap = new HashMap<>();

    private static final Map<String, Date> overdueListCacheMap = new HashMap<>();

    public static void setListCache(String cacheName,List<?> cacheList){
        long endTime = new Date().getTime() + 1000 + 10 * 60 * 1000; //数据保存10分钟,避免重复查询
        overdueListCacheMap.put(cacheName,new Date(endTime));
        listCacheMap.put(cacheName,cacheList);
    }

    public static List<?> getListCache(String cacheName){
        if(listCacheMap.get(cacheName) != null){
            if(overdueListCacheMap.get(cacheName).getTime() < new Date().getTime()){
                listCacheMap.put(cacheName,null);
                overdueListCacheMap.put(cacheName,null);
                return null;
            }
        }
        return listCacheMap.get(cacheName);
    }

}

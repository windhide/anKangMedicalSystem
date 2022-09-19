package com.ankang.utils;

import java.util.List;

public class SeparatePageUtil {

    Integer dataCount = 20; // 每页显示多少数据

    public List<?> GetSeparatePageData(List<?> listData, Integer page) {
        if (listData.size() > dataCount) {
            return listData.subList(page == 1 ? 0 : page * dataCount, page == 1 ? dataCount : page * dataCount + 20);
        }
        return listData;
    }
}

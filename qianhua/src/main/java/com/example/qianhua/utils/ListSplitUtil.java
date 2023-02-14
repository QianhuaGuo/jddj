package com.example.qianhua.utils;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * list拆分组合工具
 */
public class ListSplitUtil {

    public static <T> List<List<T>> splitList(List<T> needSpiltList, Integer subListLength) {
        List<List<T>> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(needSpiltList) || subListLength <= 0) {
            return Lists.newArrayList();
        } else {
            int total = needSpiltList.size();
            int number = total / subListLength;
            int remainder = total % subListLength;
            for (int i = 0; i < number; i++) {
                List<T> itemList = new ArrayList<>();
                for (int j = 0; j < subListLength; j++) {
                    itemList.add(needSpiltList.get(i * subListLength + j));
                }
                result.add(itemList);
            }
            if (remainder > 0) {
                List<T> itemList = new ArrayList<>();
                for (int i = 0; i < remainder; i++) {
                    itemList.add(needSpiltList.get(number * subListLength + i));
                }
                result.add(itemList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        for (int i =0;i<10;i++){
            list.add("hello_"+i);
        }
        List<List<String>> lists = splitList(list, 3);
        System.out.println(lists);
    }
}

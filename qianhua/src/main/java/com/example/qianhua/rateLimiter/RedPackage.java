package com.example.qianhua.rateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPackage {

    public static List<Integer> divideRedPacket(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;

        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            // 随机范围：[1，剩余人均金额的两倍)，左闭右开
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        // 最后一个红包
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPacket(1000, 10);
        int account = 0;
        for (Integer amount : amountList) {
            System.out.println("抢到金额：" + amount);
            account += amount;
        }
        System.out.println("总共金额："+account);
    }
}

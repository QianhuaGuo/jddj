package com.example.qianhua.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 限流算法：令牌桶算法
 * 令牌桶是一个存放固定容量令牌的桶，按照固定速率往桶里添加令牌。令牌桶算法基于请求所需的令牌数量来判断是否允许处理请求，
 * 如果桶中的令牌数量大于请求所需的令牌数量，则处理请求并从桶中移除相应数量的令牌；如果桶中的令牌数量小于请求所需的令牌数量，则拒绝处理请求。
 */
public class TokenBucket {
    // 创建一个每秒产生1个令牌的RateLimiter对象
    public static RateLimiter rateLimiter = RateLimiter.create(1.0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            //尝试获取令牌，如果没有令牌则阻塞等待
            double waitTime = rateLimiter.acquire();
            System.out.println("获取令牌成功! 等待时间：" + waitTime);
            // 模拟业务处理逻辑
            doService();
        }
    }
    public static void doService() {
        System.out.println("开始处理业务逻辑..." + System.currentTimeMillis() / 1000);
    }
}

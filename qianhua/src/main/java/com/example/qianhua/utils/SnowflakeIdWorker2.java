package com.example.qianhua.utils;

public class SnowflakeIdWorker2 {
    // 数据中心ID(0~31)
    private long datacenterId;
    // 工作机器ID(0~31)
    private long workerId;
    // 毫秒内序列(0~4095)
    private long sequence;
    // 上次生成ID的时间截
    private long lastTimestamp = -1L;
    // 开始时间截 (2015-01-01)
    private long twepoch = 1420041600000L;
    // 机器ID所占的位数
    private long workerIdBits = 5L;
    // 数据中心ID所占的位数
    private long datacenterIdBits = 5L;
    // 支持的最大机器ID，结果是31
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 支持的最大数据中心ID，结果是31
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    // 序列在ID中占的位数
    private long sequenceBits = 12L;
    // 机器ID向左移12位
    private long workerIdShift = sequenceBits;
    // 数据中心ID向左移17位
    private long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间截向左移22位
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    // 生成序列的掩码，这里为4095
    private long sequenceMask = -1L ^ (-1L << sequenceBits);


    public SnowflakeIdWorker2(long datacenterId, long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp
                    ));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }
        protected long tilNextMillis(long lastTimestamp) {
            long timestamp = timeGen();
            while (timestamp <= lastTimestamp) {
                timestamp = timeGen();
            }
            return timestamp;
        }

        protected long timeGen() {
            return System.currentTimeMillis();
        }

    public static void main(String[] args) {
        SnowflakeIdWorker2 snowFlake = new SnowflakeIdWorker2(22L, 23L);

        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(snowFlake.nextId());
        }
    }
}


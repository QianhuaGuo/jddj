package com.example.qianhua.designModel.adapterModel;

/**
 * 适配器模式：将任务适配到他想要的处理类中
 */
public class AdapterDemo {
    public static void main(String[] args) {
        AdapterOlderSystem adapterOlderSystem = new AdapterOlderSystem(new OldSystem());
        adapterOlderSystem.newMethod();
    }
}

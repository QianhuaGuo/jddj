package com.example.qianhua.designModel.abstractFactoryModel;

/**
 * 超级工厂接口负责创建一个相关对象的工厂，每个工厂能按照工厂模式提供对象
 */
public interface GUIFactory {
    Button createButton();
}

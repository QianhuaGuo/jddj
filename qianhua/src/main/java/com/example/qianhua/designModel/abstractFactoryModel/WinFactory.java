package com.example.qianhua.designModel.abstractFactoryModel;

public class WinFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WinButton();
    }
}

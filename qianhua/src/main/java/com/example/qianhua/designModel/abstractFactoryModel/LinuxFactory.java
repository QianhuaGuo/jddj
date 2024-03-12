package com.example.qianhua.designModel.abstractFactoryModel;

public class LinuxFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new LinuxButton();
    }
}

package com.example.qianhua.designModel.abstractFactoryModel;

/**
 * 抽象工厂模式：一种创建型模式，围绕一个超级工厂（GUIFactory）去创建其他工厂（LinuxFactory，WinFactory），进而用这些工厂区创建具体的产线产品
 * 优点：当一个产品族中的多个对象被设计成一起工作时，他能保证客户端始终使用同一个产品族中的对象，有助于确保系统的稳定性和一致性
 */
public class AbstractFactoryDemo {
    private Button button;
    private GUIFactory guiFactory;


    public AbstractFactoryDemo(GUIFactory guiFactory) {
        this.guiFactory = guiFactory;
        this.button = guiFactory.createButton();
    }

    public void paint() {
        button.print();
    }

    public static void main(String[] args) {
        AbstractFactoryDemo app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("linux")) {
            factory = new LinuxFactory();
            app = new AbstractFactoryDemo(factory);
        } else {
            factory = new WinFactory();
            app = new AbstractFactoryDemo(factory);
        }
        app.paint();
    }
}

package com.example.qianhua.designModel.adapterModel;

public class AdapterOlderSystem implements NewSystem{
    private OldSystem system;

    public AdapterOlderSystem(OldSystem system) {
        this.system = system;
    }

    @Override
    public void newMethod() {
        system.oldMethod();
    }
}

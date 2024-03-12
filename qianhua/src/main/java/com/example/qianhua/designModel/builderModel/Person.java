package com.example.qianhua.designModel.builderModel;

/**
 * 构建者模式：将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示。
 */
public class Person {

    private String name;
    private Integer age;
    private String address;

    public Person(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static class Builder {
        private String name;
        private Integer age;
        private String address;

        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setAge(Integer age){
            this.age = age;
            return this;
        }
        public Builder setAddress(String address){
            this.address = address;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person person = new Person.Builder().setName("huahua")
                .setAge(12)
                .setAddress("湖北")
                .build();
        System.out.println(person);
    }
}

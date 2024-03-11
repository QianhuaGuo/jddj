package com.example.qianhua.demo;

import com.example.qianhua.entity.User;
import com.mchange.util.AssertException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDemo implements Cloneable{

    private String name;

    private Integer age;

    @Override
    public ObjectDemo clone(){
        try{
            return (ObjectDemo) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }



    public static void main(String[] args) {

        ObjectDemo o1 = new ObjectDemo();
        o1.setName("AA");
        ObjectDemo clone_o1 = o1.clone();

//        System.out.println(o1);
//        System.out.println(clone_o1);
        System.out.println("o1:"+o1.getName());
        System.out.println("clone_o1:"+clone_o1.getName());
        System.out.println(o1.equals(clone_o1));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        clone_o1.setName("AB");
        System.out.println("o1:"+o1.getName());
        System.out.println("clone_o1:"+clone_o1.getName());
        System.out.println(o1.equals(clone_o1));


    }
}

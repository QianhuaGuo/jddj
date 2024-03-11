package com.example.qianhua.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.HashCodeExclude;

import java.util.Hashtable;
import java.util.Objects;

@NoArgsConstructor
@Data
//@EqualsAndHashCode
public class Tree {
    private int foot;
    private String s;
    Tree(int i){
        this.foot = i;
    }

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("a",1);
        hashtable.get("a");

        Tree t1 = new Tree();
        t1.equals(new Tree());
        System.out.println(t1.getS());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tree)) return false;
        Tree tree = (Tree) o;
        return getFoot() == tree.getFoot() && Objects.equals(getS(), tree.getS());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFoot(), getS());
    }
}

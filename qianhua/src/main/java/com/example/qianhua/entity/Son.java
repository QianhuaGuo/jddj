package com.example.qianhua.entity;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class Son {
    private String name;

    public Son() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Son)) return false;
        Son son = (Son) o;
        return Objects.equals(getName(), son.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    //字符库
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    public static void main(String[] args) {



        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
        String format = sdf.format(new Date());

        long l = System.currentTimeMillis();

        long l1 = System.nanoTime();

        System.out.println("毫秒："+l);
        System.out.println("纳秒："+l1);


        for (int i = 0;i<100;i++){
            Random random = new Random();


//            System.out.println(UUID.randomUUID().toString());
//
//            int x = random.nextInt(9999-1000+1)+1000;
//
//            System.out.println(x);

//            long randomNumber = random.nextInt(1000);
            long randomNumber = random.nextLong();
            System.out.println(String.format("%019d",Math.abs(random.nextLong())));

            System.out.println(format + String.format("%010d",Math.abs(new Random().nextInt())));

        }


    }
}

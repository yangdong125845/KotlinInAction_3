package com.yangd.kotlininaction_3.class_object_inter_4.compiler_generated_method;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class ClientJava {
    private String name;
    private int postalCode;

    public ClientJava(String name, int postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

//    @Override
//    public boolean equals( Object obj) {
//        if(obj ==null || !(obj instanceof  ClientJava)){
//            return false;
//        }
//        ClientJava clientJava = (ClientJava) obj;
//        return name== clientJava.name && postalCode==clientJava.postalCode;
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, postalCode);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientJava that = (ClientJava) o;
        return postalCode == that.postalCode &&
                name.equals(that.name);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(name, postalCode);
    }

    public static void main(String[] args) {
       ClientJava clientJava1 = new ClientJava("Alice",234);
        ClientJava clientJava2 = new ClientJava("Alice",234);
        System.out.println(clientJava1 == clientJava2);
        System.out.println(clientJava1.equals(clientJava2));
        System.out.println(1000==1000);
        System.out.println(100==100);

        Integer i1 = 100, i2 = 100;
        System.out.println(i1 == i2);//true
        Integer i3 = 1000, i4 = 1000;
        System.out.println(i3 == i4);//fales
    }
}




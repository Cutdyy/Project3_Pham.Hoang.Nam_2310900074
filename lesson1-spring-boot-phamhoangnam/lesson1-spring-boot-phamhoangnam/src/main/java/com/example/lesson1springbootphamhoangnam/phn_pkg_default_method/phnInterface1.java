package com.example.lesson1springbootphamhoangnam.demo_inherit;

public interface Interface1 {
    default void method1() {
        System.out.println("Interface1.method1");
    }

    default void method2() {
        System.out.println("Interface1.method2");
    }
}

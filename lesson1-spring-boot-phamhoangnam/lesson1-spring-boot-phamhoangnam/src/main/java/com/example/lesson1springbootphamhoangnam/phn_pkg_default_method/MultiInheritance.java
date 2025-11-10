package com.example.lesson1springbootphamhoangnam.phn_pkg_default_method;

interface Interface1 {
    default void method1() {
        System.out.println("Interface1.method1");
    }
}

interface Interface2 {
    default void method2() {
        System.out.println("Interface2.method2");
    }
}

class MultiInheristance implements Interface1, Interface2 {
    // chỉ override method1, method2 dùng default của Interface2
    @Override
    public void method1() {
        System.out.println("MultiInheristance.method1");
        Interface1.super.method1(); // gọi default method của Interface1
    }

    public static void main(String[] args) {
        MultiInheristance obj = new MultiInheristance();
        obj.method1(); // chạy method1 của lớp
        obj.method2(); // chạy default method2 của Interface2
    }
}
package com.example.lesson1springbootphamhoangnam.phn_pkg_default_method;

public interface phnShape {
    void phnDraw();

    default void phnSetColor(String phnColor) {
        System.out.println("Vẽ hình với màu: " + phnColor);
    }
}


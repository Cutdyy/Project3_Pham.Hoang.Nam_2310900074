package com.example.lesson1springbootphamhoangnam.phn_pkg_default_method;

public class phnCircle implements phnShape, phnInterface1 {

    @Override
    public void phnDraw() {
        System.out.println("Vẽ hình tròn");
    }

    @Override
    public void phnSetColor(String phnColor) {
        System.out.println("Tô màu hình tròn với màu: " + phnColor);
    }
}

package com.pluralsight;

public class Thingy {
    public void foo() {
        System.out.println("Signature foo");
    }

    public void foo(int x) {
        System.out.println("Signature foo_int");
    }

    public void foo(int x, int y) {
        System.out.println("Signature foo_int_int");
    }

    public void foo(int x, String s) {
        System.out.println("Signature foo_int_String");
    }

    public void foo(String s, int x) {
        System.out.println("Signature foo_String_int");
    }

    public void foo(String x) {
        System.out.println("Signature foo_String");
    }
}

package com.example.lib;

import java.util.Scanner;

public class MyClass {
    public static void main (String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Cube cube1 = new Cube();
        cube1.makemoreCube();
        cube1.makemorePoint();
        cube1.pointCheck();
    }
}
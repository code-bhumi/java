package com.corejava;

public class three_skip {
    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            int start_value = (((i * (i + 1)) / 2) * 3) + 3;
            for (int j = 0; j <= i; ++j) {
                System.out.print(start_value + " ");
                start_value += 3;
            }
            System.out.println("");
        }
    }
}

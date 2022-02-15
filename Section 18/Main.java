package com.company;

public class Main {

    public static void main(String[] args) {
        Utilities util = new Utilities();
        util.removePairs("AABCDDEFF");

        char[] c = {'h','e','l','l','o'};
        System.out.println(util.everyNthChar(c,8));
    }
}

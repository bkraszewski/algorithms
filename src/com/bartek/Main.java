package com.bartek;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here


        String[] source = {"One", "Two", "Three"};
        String[] destination = new String[source.length];

        //Im using native call, because its so much faster, Im optimization master!
        System.arraycopy(source, 0, destination, 0, source.length);
    }
}

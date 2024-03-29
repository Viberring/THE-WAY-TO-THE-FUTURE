package com.book.ch05;

import edu.princeton.cs.algs4.StdOut;

public class LSD {

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W-1; d >= 0; d--) {
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }
            for (int i=0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for (int i=0; i < N; i++) {
                a[i] = aux[i];
            }
        }

    }

    public static void main(String[] args) {
        String[] a = new String[] {
                "4PGC938",
                "2IYE230",
                "3CIO720",
                "1ICK750",
                "1OHV845",
                "4JZY524",
                "1ICK750",
                "3CIO720",
                "1OHV845",
                "1OHV845",
                "2RLA629",
                "2RLA629",
                "3ATW723"
        };
        for (String s : a) {
            StdOut.print(s + " ");
        }
        System.out.println();
        sort(a, 7);
        for (String s : a) {
            StdOut.print(s + " ");
        }
    }

}

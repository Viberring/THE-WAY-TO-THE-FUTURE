package com.book.ch01;

import edu.princeton.cs.algs4.*;

public class Interval2DEx {
    public static void main(String[] args) {
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);
        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();
        Counter counter = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = StdRandom.random();
            double y = StdRandom.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) {
                counter.increment();
            } else {
                p.draw();
            }
        }
        StdOut.println(counter);
        StdOut.printf("box area = %.2f\n", box.area());
    }
}

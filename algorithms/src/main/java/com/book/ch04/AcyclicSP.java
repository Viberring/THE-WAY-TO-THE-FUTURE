package com.book.ch04;

public class AcyclicSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
//        Topological top = new Topological();
//        for (inv : top.order()) {
//            relax(G, V);
//        }
    }

    public static void main(String[] args) {

    }

}

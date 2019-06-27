package com.nghiepnguyen.Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class PrintGraph {
    static class Graph {
        int V;
        LinkedList<Integer> adjArray[];

        Graph(int V) {
            this.V = V;
            adjArray = new LinkedList[V];
            for (int i = 0; i < V; i++)
                adjArray[i] = new LinkedList<>();
        }


    }

    static void addEdge(Graph graph, int src, int des) {
        graph.adjArray[src].add(des);
        graph.adjArray[des].add(src);
    }

    static void printGraph(Graph graph) {
        for (int i = 0; i < graph.V; i++) {
            System.out.print(i );
            for (Integer pCrawl : graph.adjArray[i]) {
                System.out.print("-> "+pCrawl);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- != 0) {
            int V = s.nextInt();
            int E = s.nextInt();
            Graph graph = new Graph(V);
            for (int i = 0; i < graph.V; i++) {
                addEdge(graph, s.nextInt(), s.nextInt());
            }
            printGraph(graph);
        }
    }
}

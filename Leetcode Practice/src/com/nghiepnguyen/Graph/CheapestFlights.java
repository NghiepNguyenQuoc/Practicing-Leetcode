package com.nghiepnguyen.Graph;

import java.util.Arrays;

public class CheapestFlights {
    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int result = findCheapestPrice(3, flights, 0, 2, 1);
        System.out.print("Find a cheapest flight with price: " + result);
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int desc, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, dist.length);
            for (int[] edge : flights) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] == Integer.MAX_VALUE) continue;

                if (dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }
        return dist[desc] == Integer.MAX_VALUE ? -1: dist[desc];
    }
}

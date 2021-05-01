/*
Java solution for the problem All Pairs Shortest Path (https://open.kattis.com/problems/allpairspath)
Execution time: 0.69 s
Submitted on 2017-09-23 04:23:01
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import static java.lang.Math.*;
import java.util.*;
import java.io.*;

public class Solution {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
    int v = 0, u = 0, w = 0;

    // Process each test case
    while (!(n == 0 && m == 0 && q == 0)) {

      double[][] dist = new double[n][n];

      // Fill matrix with POSITIVE_INFINITY and zero on diagonal
      for (int i = 0; i < n; i++) {
        Arrays.fill(dist[i], Double.POSITIVE_INFINITY);
        dist[i][i] = 0.0;
      }

      // Read in edges
      for (int i = 0; i < m; i++) {

        u = sc.nextInt();
        v = sc.nextInt();
        w = sc.nextInt();

        // Don't keep this edge if there was already a better one
        dist[u][v] = min(w, dist[u][v]);
      }

      // Run Floyd-Warshall
      floydWarshall(dist);

      // Process queries
      for (int i = 0; i < q; i++) {

        u = sc.nextInt();
        v = sc.nextInt();
        double val = dist[u][v];

        if (val == Double.POSITIVE_INFINITY) {
          System.out.println("Impossible");
        } else if (val == Double.NEGATIVE_INFINITY) {
          System.out.println("-Infinity");
        } else {
          System.out.println((int) val);
        }

      }

      n = sc.nextInt();
      m = sc.nextInt();
      q = sc.nextInt();

      // Add an empty line between test cases
      if (!(n == 0 && m == 0 && q == 0))
        System.out.println();

    }

  }

  static void floydWarshall(double[][] dist) {

    int n = dist.length;

    // Compute shortest paths
    for (int k = 0; k < n; k++)
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          if (dist[i][k] + dist[k][j] < dist[i][j])
            dist[i][j] = dist[i][k] + dist[k][j];

    // Identify negative cycles
    for (int k = 0; k < n; k++)
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          if (dist[i][k] + dist[k][j] < dist[i][j])
            dist[i][j] = Double.NEGATIVE_INFINITY;

  }

}
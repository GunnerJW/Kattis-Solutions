/*
Java solution for the problem Kastenlauf (https://open.kattis.com/problems/kastenlauf)
Execution time: 0.15 s
Submitted on 2018-05-06 03:46:02
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static int dist(int x1,int y1,int x2,int y2)
    {
        return (int)Math.abs(x1-x2)+(int)Math.abs(y1-y2);
    }
    static class UnionFind
    {
        public int[] parent;
        public int[] rank;
        public int[] numberOfVertices;// number of vertices under this vertex
        public int dS;

        public UnionFind(int n)
        {
            parent=new int[n];
            rank=new int[n];
            numberOfVertices=new int[n];
            for(int i=0;i<n;i++)
                parent[i]=i;
            Arrays.fill(numberOfVertices,1);
            dS=n;
        }

        public int find(int x)
        {
            if(parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }

        public void unite(int a,int b)
        {
            int pa=this.find(a),pb=this.find(b);
            if(pa!=pb)
            {
                if(rank[pa]==rank[pb])
                {
                    parent[pa]=pb;
                    rank[pb]++;
                    numberOfVertices[pb]+=numberOfVertices[pa];
                }
                else if(rank[pa]>rank[pb])
                {
                    parent[pb]=pa;
                    numberOfVertices[pa]+=numberOfVertices[pb];
                }
                else
                {
                    parent[pa]=pb;
                    numberOfVertices[pb]+=numberOfVertices[pa];
                }
                dS--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int[] x=new int[n+2];
            int[] y=new int[n+2];
            for(int i=0;i<n+2;i++)
            {
                x[i]=sc.nextInt();
                y[i]=sc.nextInt();
            }
            UnionFind uf=new UnionFind(n+2);
            for(int i=0;i<n+1;i++)
                for(int j=i+1;j<n+2;j++)
                    if(dist(x[i],y[i],x[j],y[j])<=1000 && uf.find(i)!=uf.find(j))
                        uf.unite(i,j);
            if(uf.find(0)==uf.find(n+1))
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
}

/*
Java solution for the problem Single source shortest path, non-negative weights (https://open.kattis.com/problems/shortestpath1)
Execution time: 1.16 s
Submitted on 2017-07-28 01:59:40
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class GraphWeighted
    {
    private ArrayList<ArrayList<Pair>> adjListW;
    private ArrayList<Edge> edgeList;
    private static class Pair
    {
        private int v;
        private int w;
        public Pair(int a,int b)
        {
            v=a;
            w=b;
        }
        public int v()
        {
            return v;
        }
        public int w()
        {
            return w;
        }
        public static Comparator<Pair> pairComparator=Comparator.comparingInt(Pair::v).thenComparingInt(Pair::w);
    }
    public static class Edge
    {
        private int w;
        private int v1;
        private int v2;
        public Edge(int w,int v1,int v2)
        {
            this.w=w;
            this.v1=v1;
            this.v2=v2;
        }
        public int w(){
            return w;
        }
        public int v1(){
            return v1;
        }
        public int v2(){
            return v2;
        }
        public static Comparator<Edge> edgeComparator=Comparator.comparingInt(Edge::w).thenComparingInt(Edge::v1).thenComparingInt(Edge::v2);
    }
    public GraphWeighted(int v)
    {
        adjListW=new ArrayList<ArrayList<Pair>>(v);
        for(int i=0;i<v;i++)
            adjListW.add(new ArrayList<Pair>());
        edgeList=new ArrayList<Edge>();
    }
    public GraphWeighted(int v,int e)
    {
        adjListW=new ArrayList<ArrayList<Pair>>(v);
        for(int i=0;i<v;i++)
            adjListW.add(new ArrayList<Pair>());
        edgeList=new ArrayList<Edge>(e);
    }
    public void add(int a,int b,int w)
    {
        adjListW.get(a).add(new Pair(b,w));
        //adjListW.get(b).add(new Pair(a,w));
        edgeList.add(new Edge(w,a,b));
    }
    public void sortEdgeList()
    {
        edgeList.sort(Edge.edgeComparator);
        return;
    }
    public ArrayList<Edge> getEdgeList()
    {
        return edgeList;
    }
    public int[] dijkstra(int x)//does not support graphs with negative-weight cycles
    {
        int[] distance=new int[adjListW.size()];
        Arrays.fill(distance, 1000000000);
        distance[x]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(adjListW.size(),Pair.pairComparator);
        pq.add(new Pair(0,x));
        while(!pq.isEmpty())
        {
            Pair tmp=pq.poll();
            int d=tmp.v();
            int v=tmp.w();
            if(d>distance[v])
                continue;
            for(Pair p:adjListW.get(v))
            {
                int tmp1=p.w()+d;
                int tmp2=p.v();
                if(tmp1<distance[tmp2])
                {
                    distance[tmp2]=tmp1;
                    pq.add(new Pair(tmp1,tmp2));
                }
            }
        }
        return distance;
    }
    public int[] bellman_ford(int x)
    {
        int[] distance=new int[adjListW.size()];
        Arrays.fill(distance, 1000000000);
        distance[x]=0;
        for(int i=0;i<adjListW.size()-1;i++)
            for(int u=0;u<adjListW.size();u++)
                for(Pair p : adjListW.get(u))
                    distance[p.v()]=Math.min(distance[p.v()], distance[u]+p.w());
        return distance;
    }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt(),e=sc.nextInt(),q=sc.nextInt(),s=sc.nextInt();
        while(v!=0 || e!=0 || q!=0 || s!=0)
        {
            GraphWeighted g=new GraphWeighted(v,e);
            for(int i=0;i<e;i++)
                g.add(sc.nextInt(),sc.nextInt(),sc.nextInt());
            int[] tmp=Arrays.copyOf(g.dijkstra(s),v);
            for(int i=0;i<q;i++)
            {
                int d=sc.nextInt();
                if(tmp[d]==1_000_000_000)
                    System.out.println("Impossible");
                else
                    System.out.println(tmp[d]);
            }
            System.out.println("");
            v=sc.nextInt();
            e=sc.nextInt();
            q=sc.nextInt();
            s=sc.nextInt();
        }
    }
}
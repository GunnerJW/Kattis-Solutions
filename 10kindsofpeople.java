/*
Java solution for the problem 10 Kinds of People (https://open.kattis.com/problems/10kindsofpeople)
Execution time: 0.49 s
Submitted on 2017-09-26 03:45:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class Graph
{
    public ArrayList<ArrayList<Integer>> adjList;
    public boolean[] visited;
    private ArrayDeque<Integer> q;
    public Graph(int n)
    {
        visited=new boolean[n];
        q=new ArrayDeque<Integer>(n);
        adjList=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<Integer>(4));
    }
    public void add(int i,int j)
    {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
        return;
    }
    public void bfs(int u)
    {
        //this.reset();
        q.add(u);
        visited[u]=true;
        colors[u/c][u-c*(u/c)]=color;
        while(!q.isEmpty())
        {
            int x=q.remove();
            for(int i=0;i<adjList.get(x).size();i++)
            {
                int z=adjList.get(x).get(i);
                if(!visited[z])
                {
                    q.add(z);
                    visited[z]=true;
                    colors[z/c][z-c*(z/c)]=color;
                }       
            }
        }
        color++;
        return;
    }
}
    static int color=0;
    static int[][] colors;
    static int c;
    static int r;
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        sc.nextLine();
        Graph g=new Graph(r*c);
        arr=new char[r][c];
        for(int i=0;i<r;i++)
            arr[i]=sc.nextLine().toCharArray();
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
            {
                if(j+1<c && arr[i][j]==arr[i][j+1])
                {
                    g.add(i*c+j,i*c+j+1);
                    //System.out.println(i+","+j+"----"+(i+1)+","+j);
                }
                if(i+1<r && arr[i][j]==arr[i+1][j])
                {
                    g.add(i*c+j,(i+1)*c+j);
                    //System.out.println(i+","+j+"----"+(i+1)+","+j);
                }
            }
        colors=new int[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                if(!g.visited[i*c+j])
                    g.bfs(i*c+j);
        int q=sc.nextInt();
        StringBuilder output=new StringBuilder();
        for(int i=0;i<q;i++)
        {
            int si=sc.nextInt()-1;
            int sj=sc.nextInt()-1;
            int ei=sc.nextInt()-1;
            int ej=sc.nextInt()-1;
            if(arr[si][sj]=='0')
            {
                if(colors[si][sj]==colors[ei][ej])
                    output.append("binary");
                else
                    output.append("neither");
            }
            else
            {
                if(colors[si][sj]==colors[ei][ej])
                    output.append("decimal");
                else
                    output.append("neither");
            }
            if(i!=q-1)
                output.append("\n");
        }
        /*for(int[] tmp : colors)
            System.out.println(Arrays.toString(tmp));*/
        //g.bfs(0);
        System.out.println(output.toString());
    }
}

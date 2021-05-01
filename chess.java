/*
Java solution for the problem Chess (https://open.kattis.com/problems/chess)
Execution time: 0.15 s
Submitted on 2017-05-11 22:00:55
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class GraphWeightedMatrix
    {
	int vertices;
	int[][] adjMatrix;
	int[][] apspMatrix;
	boolean[] cycleDetector;
	int[][] p;
	public GraphWeightedMatrix(int v)
	{
		vertices=v;
		p=new int[vertices][vertices];
		cycleDetector=new boolean[vertices];
		apspMatrix=new int[vertices][vertices]; 
		adjMatrix=new int[vertices][vertices];
		for(int i=0;i<vertices;i++)
			for(int j=0;j<v;j++)
			{
				if(i!=j)
					adjMatrix[i][j]=1000000000;
				p[i][j]=i;
			}
	}
	public void add(int i,int j,int w)
	{
		adjMatrix[i][j]=w;
	}
	public void floydW()
	{
		for(int i=0;i<vertices;i++)
			apspMatrix[i]=Arrays.copyOf(adjMatrix[i], vertices);
		for (int k=0;k<vertices;k++)
			for (int i=0;i<vertices;i++)
				for (int j=0;j<vertices;j++)
					if (apspMatrix[i][k] + apspMatrix[k][j] < apspMatrix[i][j])
					{
						apspMatrix[i][j] = apspMatrix[i][k] + apspMatrix[k][j];
						p[i][j] = p[k][j];
					}
		for(int i=0;i<vertices;i++)
			if(apspMatrix[i][i]<0)
				cycleDetector[i]=true;
	}
	public boolean partOfNegativeCycle(int x)
	{
		return cycleDetector[x];
	}
	public int shortestPath(int i,int j)
	{
		return apspMatrix[i][j];
	}
	public void printPath(int i,int j)
	{
		if (i != j)
			printPath(i, p[i][j]);
		System.out.print(((char)(j%8+65))+" "+(8-j/8)+" ");
	}
}
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        GraphWeightedMatrix g=new  GraphWeightedMatrix(64);
		for(int i=0;i<64;i++)
		{
			int rowi=i/8;
			int coli=i%8;
			for(int j=0;j<64;j++)
			{
				int rowj=j/8;
				int colj=j%8;
				if(i!=j && Math.abs(rowi-rowj)==Math.abs(coli-colj))
					g.add(i, j, 1);
			}
		}
		g.floydW();
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {
            int src=0,dst=0;
            src+=br.read()%65;
            br.read();
            src+=(56-br.read())*8;
            br.read();
            dst+=br.read()%65;
            br.read();
            dst+=(56-br.read())*8;
            br.read();
            if(g.shortestPath(src,dst)==1000000000)
                System.out.println("Impossible");
            else
            {
                System.out.print(g.shortestPath(src,dst)+" ");
                g.printPath(src,dst);
                System.out.println("");
            }
        }
    }
}
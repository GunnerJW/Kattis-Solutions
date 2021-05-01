/*
Java solution for the problem Splat (https://open.kattis.com/problems/splat)
Execution time: 0.2 s
Submitted on 2017-03-21 02:04:35
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int d=sc.nextInt(),i=0,n=0,j=0,k=0;
        double x,y;
        boolean painted=false;
        for(i=0;i<d;i++)
        {
            n=sc.nextInt();
            double[] dropx=new double[n];
            double[] dropy=new double[n];
            double[] dropr=new double[n];
            String[] color=new String[n];
            for(j=0;j<n;j++)
            {
                dropx[j]=sc.nextDouble();
                dropy[j]=sc.nextDouble();
                dropr[j]=Math.sqrt(sc.nextDouble()/Math.PI);
                color[j]=sc.next();
            }
            n=sc.nextInt();
            for(j=0;j<n;j++)
            {
                x=sc.nextDouble();
                y=sc.nextDouble();
                for(k=color.length-1;k>=0;k--)
                {
                    if(Math.sqrt(Math.pow(x-dropx[k],2)+Math.pow(y-dropy[k],2))<=dropr[k])
                    {
                        System.out.println(color[k]);
                        painted=true;
                        break;
                    }
                }
                if(painted==false)
                    System.out.println("white");
                painted=false;
            }
        }
    }
}

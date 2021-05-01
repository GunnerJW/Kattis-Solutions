/*
Java solution for the problem Rock-Paper-Scissors Tournament (https://open.kattis.com/problems/rockpaperscissors)
Execution time: 0.46 s
Submitted on 2017-03-27 20:19:33
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;


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
        int n=sc.nextInt(),k,i;
        Hashtable<String,Hashtable<String,Integer>> ht=new Hashtable<String,Hashtable<String,Integer>>(3);
        Hashtable<String,Integer> aux=new Hashtable<String,Integer>(2);
        aux.put("scissors",1);
        aux.put("paper",-1);
        ht.put("rock",aux);
        Hashtable<String,Integer> aux2=new Hashtable<String,Integer>(2);
        aux2.put("rock",1);
        aux2.put("scissors",-1);
        ht.put("paper",aux2);
        Hashtable<String,Integer> aux3=new Hashtable<String,Integer>(2);
        aux3.put("paper",1);
        aux3.put("rock",-1);
        ht.put("scissors",aux3);
        int p1,p2;
        String m1,m2;
        //System.out.println(ht);
        while(n!=0)
        {
            k=sc.nextInt();
            int[][] arr=new int[2][n+1];
            lp:for(i=0;i<k*n*(n-1)/2;i++)
            {
                p1=sc.nextInt();
                m1=sc.next();
                p2=sc.nextInt();
                m2=sc.next();
                if(m1.equals(m2))
                    continue lp;
                else if(ht.get(m1).get(m2)==1)
                {
                    arr[0][p1]++;
                    arr[1][p2]++;
                }
                else if(ht.get(m1).get(m2)==-1)
                {
                    arr[1][p1]++;
                    arr[0][p2]++;
                }
            }
            for(i=1;i<n+1;i++)
            {
                if(arr[0][i]+arr[1][i]!=0)
                    System.out.printf("%.3f%n",(double)arr[0][i]/(arr[0][i]+arr[1][i]));
                else
                    System.out.println("-");
            }
            n=sc.nextInt();
            if(n!=0)
                System.out.println("");
        }
    }
}

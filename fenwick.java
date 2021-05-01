/*
Java solution for the problem Fenwick Tree (https://open.kattis.com/problems/fenwick)
Execution time: 2.23 s
Submitted on 2017-10-11 20:31:36
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    static class FenwickTree
    {
	   public long[] arr;
	   public FenwickTree(int n)
	   {
	       arr=new long[n+1];
	   }
	   private static int LSOne(int i)
	   {
	       return (i&(-i));
       }
	   public long query(int i)//returns sum of [1,i]
	   {
	       long sum=0;
	       for(;i>0;i-=LSOne(i))
	           sum+=arr[i];
	       return sum;
	   }
	   public long query(int a,int b)
	   {
	       return this.query(b) - ((a==1)?0:this.query(a-1));
	   }
	   public void adjust(int k,long offset)
	   {
	       for(;k<arr.length;k+=LSOne(k))
	           arr[k]+=offset;
	   }
    }
    static class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}


    public static void main(String[] args) throws IOException{
        Kattio sc=new Kattio(System.in);
        int n=sc.getInt();
        int q=sc.getInt();
        FenwickTree ft=new FenwickTree(n);
        StringBuilder output=new StringBuilder();
        for(int i=0;i<q;i++)
        {
            if(sc.getWord().equals("+"))
            {
                ft.adjust(sc.getInt()+1,sc.getLong());
            }
            else
            {
                output.append(ft.query(sc.getInt()));
                output.append("\n");
            }
        }
        System.out.println(output.deleteCharAt(output.length()-1).toString());
        //System.out.println(Arrays.toString(ft.arr));
    }
}
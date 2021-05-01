/*
Java solution for the problem Cranes (https://open.kattis.com/problems/cranes)
Execution time: 0.06 s
Submitted on 2017-09-30 19:10:17
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    static long[] x;
    static long[] y;
    static long[] r;
    static int n;
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
    static final double EPS=0.000000001;
    static long[][] memo;
    static long maxArea(int index,int chosen)
    {
        //System.out.println("("+index+","+chosen+")");
        if(index==n)
            return 0;
        if(memo[index][chosen]!=-1)
            return memo[index][chosen];
        boolean collides=false;
        for(int i=0;i<n;i++)
            if((chosen & (1<<i))!=0)
            {
                long xx=x[index]-x[i];
                long yy=y[index]-y[i];
                long rr=r[index]+r[i];
                if(xx*xx+yy*yy<=rr*rr)
                {
                    collides=true;
                    break;
                }
            }
        if(collides)
            return memo[index][chosen]=maxArea(index+1,chosen);
        return memo[index][chosen]=Math.max(maxArea(index+1,chosen),r[index]*r[index]+maxArea(index+1,(chosen|(1<<index))));
    }
    public static void main(String[] args) throws IOException{
        Kattio sc=new Kattio(System.in);
        int t=sc.getInt();
        for(int i=0;i<t;i++)
        {
            n=sc.getInt();
            x=new long[n];
            y=new long[n];
            r=new long[n];
            for(int j=0;j<n;j++)
            {
                x[j]=sc.getLong();
                y[j]=sc.getLong();
                r[j]=sc.getLong();
            }
            memo=new long[n][1<<n];
            for(long[] tmp : memo)
                Arrays.fill(tmp,-1);
            System.out.println(maxArea(0,0));
        }
    }
}
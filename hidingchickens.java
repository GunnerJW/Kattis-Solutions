/*
Java solution for the problem Hiding Chickens (https://open.kattis.com/problems/hidingchickens)
Execution time: 1.89 s
Submitted on 2017-10-16 00:25:55
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static double minDist(int bitmask)
    {
        //System.out.println(bitmask+" called");
        if(bitmask==full)
            return 0.0;
        if(memo[bitmask]!=-1.0)
            return memo[bitmask];
        double min=Double.MAX_VALUE;
        for(int i=1;i<=n;i++)
        {
            if((bitmask&(1<<i))==0)
            {
                double tmp1=dist[0][i];
                int next1=bitmask|(1<<i);
                if(next1==full)
                {
                    min=Math.min(min,tmp1+minDist(next1));
                }
                else
                {
                    min=Math.min(min,2*tmp1+minDist(next1));
                    for(int j=1;j<n+1;j++)
                    {
                        if((bitmask&(1<<j))==0 && i!=j)
                        {
                            double tmp2=dist[i][j];
                            //double tmp3=dist[i][j];
                            int next2=(bitmask|(1<<j))|(1<<i);
                            if(next2==full)
                            {
                                min=Math.min(min,tmp1+tmp2+minDist(next2));
                            }
                            else
                            {
                                min=Math.min(min,tmp1+tmp2+dist[0][j]+minDist(next2));
                            }
                        }
                    }
                }
                //System.out.println(i+" chosen : "+tmp1);
            }
        }
        return memo[bitmask]=min;
    }
    static int full;
    static int n;
    static double[] memo;
    static double[][] dist;
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
        double xr=sc.getDouble();
        double yr=sc.getDouble();
        n=sc.getInt();
        double[] x=new double[n+1];
        double[] y=new double[n+1];
        x[0]=xr;
        y[0]=yr;
        for(int i=1;i<=n;i++)
        {
            x[i]=sc.getDouble();
            y[i]=sc.getDouble();
        }
        dist=new double[n+1][n+1];
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n+1;j++)
                dist[i][j]=dist[j][i]=Math.hypot(x[i]-x[j],y[i]-y[j]);
        full=(1<<(n+1))-2;
        memo=new double[full+1];
        Arrays.fill(memo,-1.0);
        System.out.printf("%.6f",minDist(0));
    }
}
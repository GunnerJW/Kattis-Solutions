/*
Java solution for the problem Exchange Rates (https://open.kattis.com/problems/exchangerates)
Execution time: 0.12 s
Submitted on 2017-10-16 22:12:36
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
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
        while(true)
        {
            int n=sc.getInt();
            if(n==0)
                break;
            double[] r=new double[n];
            for(int i=0;i<n;i++)
                r[i]=sc.getDouble();
            double[] usd=new double[n+1];
            usd[0]=0;
            double[] cnd=new double[n+1];
            cnd[0]=1000.0;
            for(int i=1;i<=n;i++)
            {
                usd[i]=Math.max(usd[i-1],Math.floor(0.97*cnd[i-1]/r[i-1]*100.00)/100.00);
                cnd[i]=Math.max(cnd[i-1],Math.floor(0.97*usd[i-1]*r[i-1]*100.00)/100.00);
                //usd[i]=Math.floor(usd[i]*100.0)/100.0;
                //cnd[i]=Math.floor(cnd[i]*100.0)/100.0;
            }
            System.out.printf("%.2f",cnd[n]);
            //System.out.println(cnd[n]);
            System.out.println();
        }
        
    }
}
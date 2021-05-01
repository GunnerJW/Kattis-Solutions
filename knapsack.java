/*
Java solution for the problem Knapsack (https://open.kattis.com/problems/knapsack)
Execution time: 0.75 s
Submitted on 2018-05-01 19:27:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static void compute()
    {
        for(int i=cap;i>=0;i--)
        {
            if(i>=w[n-1])
                memo[n-1][i]=v[n-1];             
        }
        for(int i=n-2;i>=0;i--)
        {
            int c=cap;
            while(c>=w[i])
            {
                memo[i][c]=Math.max(memo[i+1][c],v[i]+memo[i+1][c-w[i]]);
                c--;
            }
            while(c>=0)
            {
                memo[i][c]=memo[i+1][c];
                c--;
            }
        }
    }
    static int n;
    static int[] v;
    static int[] w;
    static int[][] memo;
    static int cap;
    static void opt()
    {
        ArrayList<Integer> al=new ArrayList<Integer>();
        int c=cap;
        int i=0;
        //int v=memo[0][cap];
        while(c>0 && i<n)
        {
            if(i==n-1)
            {
                if(memo[i][c]==v[i])
                {
                    al.add(i);
                }
                break;
            }
            if(c>=w[i])
            {
                int x=v[i]+memo[i+1][c-w[i]];
                int y=memo[i+1][c];
                if(x>y)
                {
                    al.add(i);
                    c-=w[i];
                }
            }
            i++;
        }
        output.append(al.size());
        output.append("\n");
        for(int tmp : al)
            output.append(tmp+" ");
    }
    static StringBuilder output;
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
    public static void main(String[] args) {
        Kattio sc=new Kattio(System.in);
        output=new StringBuilder();
        while(sc.hasMoreTokens())
        {
            cap=(int)sc.getDouble();
            n=sc.getInt();
            v=new int[n];
            w=new int[n];
            for(int i=0;i<n;i++)
            {
                v[i]=sc.getInt();
                w[i]=sc.getInt();
            }
            memo=new int[n][cap+1];
            // for(int[] tmp : memo)
            //     Arrays.fill(tmp,-1);
            compute();
            // System.out.println(compute(0,cap));
            // for(int[] tmp : memo)
            //     System.out.println(Arrays.toString(tmp));
            opt();
            if(sc.hasMoreTokens())
                output.append("\n");
        }
        System.out.println(output);
    }
}

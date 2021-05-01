/*
Java solution for the problem Almost Perfect (https://open.kattis.com/problems/almostperfect)
Execution time: 0.08 s
Submitted on 2017-04-14 06:54:37
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    static int properSum(int n)
    {
        int s=1;
        double sq=Math.sqrt(n);
        for(int i=2;i*i<n;i++)
        {
            if(n%i==0)
                s+=i+(n/i);
        }
        if(sq%1==0)
            s+=(int)sq;
        return s;
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
        int n,diff=0;
        while(sc.hasMoreTokens())
        {
            n=sc.getInt();
            diff=(int)Math.abs(properSum(n)-n);
            if(diff==0)
                System.out.println(n+" perfect");
            else if(diff==1 || diff==2)
                System.out.println(n+" almost perfect");
            else
                System.out.println(n+" not perfect");
        }
    }
}
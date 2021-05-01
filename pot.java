/*
Java solution for the problem Pot (https://open.kattis.com/problems/pot)
Execution time: 0.05 s
Submitted on 2017-10-13 21:09:23
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

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
        int n=sc.getInt();
        BigInteger res=new BigInteger("0");
        for(int i=0;i<n;i++)
        {
            String s=sc.getWord();
            int l=s.length();
            BigInteger x=new BigInteger(s.substring(0,l-1));
            //System.out.println();
            x=x.pow((int)s.charAt(l-1)-48);
            res=res.add(x);
        }
        System.out.println(res);
    }
}
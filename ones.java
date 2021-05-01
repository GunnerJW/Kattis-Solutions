/*
Java solution for the problem Ones (https://open.kattis.com/problems/ones)
Execution time: 0.22 s
Submitted on 2017-03-31 18:47:01
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
    

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
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
        int n,i=1;
        int u=1;
        while(sc.hasMoreTokens())
        {
            n=sc.getInt();
            while(u%n!=0)
            {
                u*=10;
                u+=1;
                i++;
                u%=n;
            }
            System.out.println(i);
            i=1;
            u=1;
        }
    }
}

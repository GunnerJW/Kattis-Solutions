/*
Java solution for the problem How Many Digits? (https://open.kattis.com/problems/howmanydigits)
Execution time: 0.18 s
Submitted on 2017-04-07 03:47:26
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
    
    public static void main(String[] args) throws IOException{
        Kattio sc=new Kattio(System.in);
        while(sc.hasMoreTokens())
        {
            int n=sc.getInt();
            if(n==0)
                System.out.println(1);
            else
                System.out.println((int)(Math.log10(Math.sqrt((Math.PI*2*n)))+n*Math.log10(n/Math.E))+1);
        }
   }
}

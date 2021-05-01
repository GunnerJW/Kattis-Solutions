/*
Java solution for the problem Metaprogramming (https://open.kattis.com/problems/metaprogramming)
Execution time: 0.2 s
Submitted on 2017-10-11 20:30:24
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
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        while(sc.hasMoreTokens())
        {
            String cmd=sc.getWord();
            if(cmd.equals("define"))
            {
                int val=sc.getInt();
                String key=sc.getWord();
                hm.put(key,val);
            }
            else
            {
                String op1=sc.getWord();
                char operator=sc.getWord().charAt(0);
                String op2=sc.getWord();
                if(!hm.containsKey(op1) || !hm.containsKey(op2))
                {
                    System.out.println("undefined");
                }
                else
                {
                    int x1=hm.get(op1);
                    int x2=hm.get(op2);
                    if(operator=='=')
                        System.out.println(x1==x2);
                    else if(operator=='>')
                        System.out.println(x1>x2);
                    else
                        System.out.println(x1<x2);
                }
            }
            //System.out.println();
        }
    }
}
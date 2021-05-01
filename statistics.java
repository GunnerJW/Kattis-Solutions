/*
Java solution for the problem Statistics (https://open.kattis.com/problems/statistics)
Execution time: 0.05 s
Submitted on 2017-04-11 23:27:19
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
        int i=1;
        while(sc.hasMoreTokens())
        {
            int n=sc.getInt();
            int min=1000000,max=-1000000;
            for(int j=0;j<n;j++)
            {
                int x=sc.getInt();
                max=(x>max)?x:max;
                min=(x<min)?x:min;
            }
            System.out.println("Case "+i+": "+min+" "+max+" "+(max-min));
            i++;
        }
    }
}
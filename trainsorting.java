/*
Java solution for the problem Train Sorting (https://open.kattis.com/problems/trainsorting)
Execution time: 0.09 s
Submitted on 2017-10-14 02:04:08
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
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.getInt();
        int[] LIS=new int[n];
        Arrays.fill(LIS,1);
        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(arr[j]>arr[i])
                    LIS[i]=Math.max(LIS[i],1+LIS[j]);
            }
        }
        int[] LDS=new int[n];
        Arrays.fill(LDS,1);
        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(arr[j]<arr[i])
                    LDS[i]=Math.max(LDS[i],1+LDS[j]);
            }
        }
        int res=0;
        for(int i=0;i<n;i++)
            res=Math.max(res,LIS[i]+LDS[i]-1);
        System.out.println(res);
        //System.out.println(res);
    }
}
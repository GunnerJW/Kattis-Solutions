/*
Java solution for the problem Pivot (https://open.kattis.com/problems/pivot)
Execution time: 0.2 s
Submitted on 2017-10-11 22:53:03
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
        int n=sc.getInt();
        int[] arr=new int[n];
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            int x=sc.getInt();
            arr[i]=x;
            hm.put(x,i);
        }
        int[] min=new int[n];
        min[n-1]=n-1;
        int minv=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            int x=arr[i];
            if(x==minv)
                min[i]=i;
            else if(x<minv)
            {
                minv=x;
                min[i]=i;
            }
            else
                min[i]=min[i+1];
        }
        int[] max=new int[n];
        max[0]=0;
        int maxv=arr[0];
        for(int i=1;i<n;i++)
        {
            int x=arr[i];
            if(x==maxv)
                max[i]=i;
            else if(x>maxv)
            {
                maxv=x;
                max[i]=i;
            }
            else
                max[i]=max[i-1];
        }
        int res=0;
        for(int i=0;i<n;i++)
        {
            int x=arr[i];
            boolean isMax=(max[i]==i);
            boolean isMin=(min[i]==i);
            if(isMax && isMin)
            {
                if(hm.get(x)==i)
                    res++;
            }
        }
        System.out.println(res);
    }
}
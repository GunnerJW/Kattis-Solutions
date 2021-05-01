/*
Java solution for the problem Frosh Week (https://open.kattis.com/problems/froshweek)
Execution time: 0.56 s
Submitted on 2017-10-17 22:55:42
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static void merge(int[] a,int start,int mid,int end)
    {
        int p=start;
        int q=mid+1;
        int[] arr=new int[end-start+1];
        int k=0;
        for(int i=start;i<=end;i++)
        {
            if(p>mid)
            {
                arr[k++]=a[q++];
            }
            else if(q>end)
            {
                arr[k++]=a[p++];
            }
            else if(a[p]<=a[q])
            {
                arr[k++]=a[p++];
            }
            else
            {
                arr[k++]=a[q++];
                moves+=mid-p+1;
            }
        }
        for(p=0;p<k;p++)
        {
            a[start++]=arr[p];
        }
    }
    static void merge_sort(int[] a,int start,int end)
    {
        if(start<end)
        {
            int mid=(start+end)/2;
            merge_sort(a,start,mid);
            merge_sort(a,mid+1,end);
            merge(a,start,mid,end);
        }
    }
    static long moves;
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
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.getInt();
        }
        moves=0;
        merge_sort(a,0,n-1);
        System.out.println(moves);
    }
}
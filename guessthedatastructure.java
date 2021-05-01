/*
Java solution for the problem I Can Guess the Data Structure! (https://open.kattis.com/problems/guessthedatastructure)
Execution time: 0.28 s
Submitted on 2017-10-12 02:35:08
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
        while(sc.hasMoreTokens())
        {
            int n=sc.getInt();
            ArrayDeque<Integer> queue=new ArrayDeque<Integer>();
            ArrayDeque<Integer> stack=new ArrayDeque<Integer>();
            PriorityQueue<Integer> maxpq=new PriorityQueue<Integer>(Collections.reverseOrder());
            int isq=1;
            int isst=1;
            int ispq=1;
            for(int i=0;i<n;i++)
            {
                int cmd=sc.getInt();
                int x=sc.getInt();
                if(cmd==1)
                {
                    queue.add(x);
                    stack.add(x);
                    maxpq.add(x);
                }
                else
                {
                    if(queue.isEmpty())
                        isq=0;
                    else
                    {
                        int xq=queue.pollFirst();
                        if(xq!=x)
                            isq=0;
                    }
                    if(stack.isEmpty())
                        isst=0;
                    else
                    {
                        int xs=stack.pollLast();
                        if(xs!=x)
                            isst=0;
                    }
                    if(maxpq.isEmpty())
                        ispq=0;
                    else
                    {
                        int xmx=maxpq.poll();
                        if(xmx!=x)
                            ispq=0;
                    }
                }
            }
            if(isq+isst+ispq>1)
                System.out.println("not sure");
            else
            {
                if(isq+isst+ispq==0)
                    System.out.println("impossible");
                else
                {
                    if(isq==1)
                        System.out.println("queue");
                    else if(isst==1)
                        System.out.println("stack");
                    else
                        System.out.println("priority queue");
                }
            }
        }
        //System.out.println(res);
    }
}
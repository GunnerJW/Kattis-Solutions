/*
Java solution for the problem Hall O' Wee Mirrors (https://open.kattis.com/problems/halloweemirrors)
Execution time: 0.18 s
Submitted on 2017-09-30 02:54:37
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    static class Line//Defined by Ax+Bx=C
{
	int A;
	int B;
	int C;
	public Line(int x1,int y1,int x2,int y2)
	{
		A=y2-y1;
		B=x1-x2;
		C=x1*y2-x2*y1;
	}
	public Line(int a,int b,int c)
	{
		A=a;
		B=b;
		C=c;
	}
	public double[] intersectionPoint(Line L)//assumes intersectsWith==true
	{
		double det=1.0*(this.A*L.B-this.B*L.A);
		double x=(L.B*this.C-this.B*L.C)/det;
		double y=(this.A*L.C-L.A*this.C)/det;
		double[] result={x,y};
		return result;
	}
	public Line perpendicular(int x0,int y0)
	{
		return new Line(-B,A,-B*x0+A*y0);
	}
	
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
        StringBuilder output=new StringBuilder();
        while(true)
        {
            int n=sc.getInt();
            if(n==0)
                break;
            int[] x1=new int[n];
            int[] y1=new int[n];
            int[] x2=new int[n];
            int[] y2=new int[n];
            for(int i=0;i<n;i++)
            {
                x1[i]=sc.getInt();
                y1[i]=sc.getInt();
                x2[i]=sc.getInt();
                y2[i]=sc.getInt();
            }
            int locations=sc.getInt();
            for(int i=0;i<locations;i++)
            {
                int x=sc.getInt();
                int y=sc.getInt();
                int sum=0;
                for(int j=0;j<n;j++)
                {
                    Line mirror=new Line(x1[j],y1[j],x2[j],y2[j]);
                    Line p=mirror.perpendicular(x,y);
                    double[] intp=mirror.intersectionPoint(p);
                    //System.out.println(intp[0]+" "+intp[1]);
                    if(intp[0]<=Math.max(x1[j],x2[j]) && intp[0]>=Math.min(x1[j],x2[j]) &&
                       intp[1]<=Math.max(y1[j],y2[j]) && intp[1]>=Math.min(y1[j],y2[j]))
                        sum++;
                }
                output.append(sum);
                output.append("\n");
            }
            output.append("\n");
        }
        output.deleteCharAt(output.length()-1);
        output.deleteCharAt(output.length()-1);
        System.out.println(output.toString());
    }
}
/*
Java solution for the problem Polygon Area (https://open.kattis.com/problems/polygonarea)
Execution time: 0.08 s
Submitted on 2017-09-30 20:34:00
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    static class Point
    {
	int x,y;
	public Point(int a,int b)
	{
		x=a;
		y=b;
	}
	public double distance(Point p)
	{
		int x=this.x-p.x;
		int y=this.y-p.y;
		return Math.hypot(x, y);
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
    static final double EPS=0.000000001;
    public static void main(String[] args) throws IOException{
        Kattio sc=new Kattio(System.in);
        int n=sc.getInt();
        while(n!=0)
        {
            Point[] arr=new Point[n+1];
            for(int i=0;i<n;i++)
                arr[i]=new Point(sc.getInt(),sc.getInt());
            arr[n]=new Point(arr[0].x,arr[0].y);
            double area=0;
            for(int j=0;j<n;j++)
                area+=1.0*(arr[j+1].x-arr[j].x)*(arr[j+1].y+arr[j].y)/2;
            if(area<-EPS)
            {
                System.out.print("CCW ");
                System.out.printf("%.1f",-area);
                System.out.println();
            }
            else
            {
                System.out.print("CW ");
                System.out.printf("%.1f",area);
                System.out.println();
            }
            n=sc.getInt();
        }
    }
}
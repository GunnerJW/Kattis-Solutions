/*
Java solution for the problem Triangle Trilemma (https://open.kattis.com/problems/trilemma)
Execution time: 0.07 s
Submitted on 2017-09-30 16:46:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    static class Point//Overload == and < + implement use of epsilon
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
	public static int orientationDet(Point p,Point q,Point r)
	{
		return q.x*r.y-r.x*q.y-p.x*(r.y-q.y)+p.y*(r.x-q.x);
	}
	public static double triangleArea(Point p,Point q,Point r)
	{
		return Math.abs(orientationDet(p,q,r))/2;
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
        for(int i=1;i<=n;i++)
        {
            System.out.print("Case #"+i+": ");
            Point p=new Point(sc.getInt(),sc.getInt());
            Point q=new Point(sc.getInt(),sc.getInt());
            Point r=new Point(sc.getInt(),sc.getInt());
            double det=(int)Math.abs(Point.orientationDet(p,q,r));
            if(det<EPS)
                System.out.println("not a triangle");
            else
            {
                double a=p.distance(q);
                double b=p.distance(r);
                double c=q.distance(r);
                if(Math.abs(a-b)<EPS || Math.abs(b-c)<EPS || Math.abs(a-c)<EPS)
                    System.out.print("isosceles ");
                else
                    System.out.print("scalene ");
                double alpha=180*Math.acos((c*c+b*b-a*a)/(2*b*c))/Math.PI;
                double beta=180*Math.acos((c*c+a*a-b*b)/(2*a*c))/Math.PI;
                double gamma=180*Math.acos((a*a+b*b-c*c)/(2*b*a))/Math.PI;
                if((alpha-90)>EPS || (beta-90)>EPS || (gamma-90)>EPS)
                    System.out.print("obtuse ");
                else if(Math.abs(alpha-90)<EPS || Math.abs(beta-90)<EPS || Math.abs(gamma-90)<EPS)
                    System.out.print("right ");
                else
                    System.out.print("acute ");
                //System.out.println(alpha+" "+beta+" "+gamma);
                System.out.println("triangle");
            }
        }
    }
}
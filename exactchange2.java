/*
Java solution for the problem Exact Change (https://open.kattis.com/problems/exactchange2)
Execution time: 0.19 s
Submitted on 2017-08-14 19:08:29
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

//exactchange2
import java.util.*;

public class Solution{
    static int MAX=1000001;
    static int toPay;
    static int n;
    static int[] bills;
    static int[][] memo1;
    static int[][] memo2;
    static int finalMin;
    static int min(int index,int paid)
    {
        if(index==n)
        {
            if(paid>=toPay)
                return 0;
            else
                return MAX;
        }
        if(paid>=toPay)
            return 0;
        if(memo1[index][paid]!=-1)
            return memo1[index][paid];
        return memo1[index][paid]=Math.min(bills[index]+min(index+1,paid+bills[index]),min(index+1,paid));
    }
    static int minCoins(int index,int paid)
    {
        if(index==n)
        {
            if(paid!=finalMin)
                return MAX;
            else
                return 0;
        }
        if(paid>finalMin)
            return MAX;
        if(paid==finalMin)
            return 0;
        if(memo2[index][paid]!=-1)
            return memo2[index][paid];
        return memo2[index][paid]=Math.min(1+minCoins(index+1,paid+bills[index]),minCoins(index+1,paid));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int cases=sc.nextInt();
        for(int i=0;i<cases;i++)
        {
            toPay=sc.nextInt();
            n=sc.nextInt();
            bills=new int[n];
            for(int j=0;j<n;j++)
                bills[j]=sc.nextInt();
            memo1=new int[100][10000];
            for(int[] x : memo1)
                Arrays.fill(x,-1);
            memo2=new int[100][10000];
            for(int[] x : memo2)
                Arrays.fill(x,-1);
            finalMin=min(0,0);
            int finalCoins=minCoins(0,0);
            System.out.println(finalMin+" "+minCoins(0,0));
        }
    }
}
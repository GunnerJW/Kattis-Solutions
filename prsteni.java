/*
Java solution for the problem Prsteni (https://open.kattis.com/problems/prsteni)
Execution time: 0.08 s
Submitted on 2017-03-01 03:49:32
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution {
    static int gcd(int a, int b) {
   if (b==0) return a;
   return gcd(b,a%b);
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int i=0,cd=0;
        for(i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(i>0)
            {
                cd=gcd(arr[0],arr[i]);
                System.out.println((arr[0]/cd)+"/"+(arr[i]/cd));
            }
        }
    }
}

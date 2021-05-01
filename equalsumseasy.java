/*
Java solution for the problem Equal Sums (Easy) (https://open.kattis.com/problems/equalsumseasy)
Execution time: 0.14 s
Submitted on 2017-05-08 12:05:52
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            sc.nextInt();
            int[] arr=new int[20];
            for(int j=0;j<20;j++)
                arr[j]=sc.nextInt();
            HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>(1<<20);
            boolean broken=false;
            for(int j=1;j<(1<<20);j++)
            {
                int sum=0;
                for(int k=0;k<20;k++)
                {
                    if((j&(1<<k))>0)
                        sum+=arr[k];
                }
                if(hm.containsKey(sum))
                {
                    System.out.println("Case #"+i+":");
                    for(int k=0;k<20;k++)
                        if((j&(1<<k))>0)
                            System.out.print(arr[k]+" ");
                    System.out.println("");
                    for(int k=0;k<20;k++)
                        if((hm.get(sum)&(1<<k))>0)
                            System.out.print(arr[k]+" ");
                    System.out.println("");
                    broken=true;
                    break;
                }
                else
                    hm.put(sum,j);
            }
            if(broken==false)
            {
                System.out.println("Case #"+i+":");
                System.out.println("Impossible");
            }
        }
    }
}
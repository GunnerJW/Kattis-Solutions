/*
Java solution for the problem Kitten on a Tree (https://open.kattis.com/problems/kitten)
Execution time: 0.08 s
Submitted on 2018-10-05 14:05:08
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        sc.nextLine();
        int[] arr=new int[101];
        while(true)
        {
            String[] branches=sc.nextLine().split(" ");
            if(branches[0].equals("-1"))
                break;
            //System.out.println(Arrays.toString(branches));
            for(int i=1;i<branches.length;i++)
                arr[Integer.parseInt(branches[i])]=Integer.parseInt(branches[0]);
        }
        //System.out.println(Arrays.toString(arr));
        int curr=k;
        while(curr!=0)
        {
            System.out.print(curr);
            System.out.print(" ");
            curr=arr[curr];
        }
    }
}
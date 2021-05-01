/*
Java solution for the problem Deduplicating Files (https://open.kattis.com/problems/deduplicatingfiles)
Execution time: 0.82 s
Submitted on 2017-04-04 23:10:45
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int i,j,n=sc.nextInt();
        int unique,collisions;
        while(n!=0)
        {
            collisions=0;
            sc.nextLine();
            String[] files=new String[n];
            HashSet<String> as=new HashSet<String>();
            int[] hash=new int[n];
            for(i=0;i<n;i++)
            {
                files[i]=sc.nextLine();
                as.add(files[i]);
                for(j=0;j<files[i].length();j++)
                {
                    hash[i]=hash[i]^(int)files[i].charAt(j);
                }
            }
            for(i=0;i<n-1;i++)
            {
                for(j=i+1;j<n;j++)
                {
                    if(hash[j]==hash[i])
                    {
                        if(!files[j].equals(files[i]))
                            collisions++;
                    }
                }
            }
            System.out.println(as.size()+" "+collisions);
            n=sc.nextInt();
        }
    }
}
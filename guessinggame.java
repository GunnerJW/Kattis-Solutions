/*
Java solution for the problem Guessing Game (https://open.kattis.com/problems/guessinggame)
Execution time: 0.2 s
Submitted on 2017-03-11 16:55:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void removeE(ArrayList<Integer> arrl,int x)
    {
        for(int i=0;i<arrl.size();i++)
        {
            if(arrl.get(i)==x)
                arrl.remove(i);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int n=sc.nextInt(),i=0;
        String s="";
        while(n!=0)
        {
            sc.nextLine();
            s=sc.nextLine();
            if(s.equals("too high"))
            {
                for(i=n;i<=10;i++)
                {
                    if(al.contains(i))
                        Solution.removeE(al,i);
                }
            }
            else if(s.equals("too low"))
            {
                for(i=1;i<=n;i++)
                {
                    if(al.contains(i))
                        Solution.removeE(al,i);
                }
            }
            else if(s.equals("right on"))
            {
                if(al.contains(n))
                    System.out.println("Stan may be honest");
                else
                    System.out.println("Stan is dishonest");
                al=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
            }
            n=sc.nextInt();
        }
    }
}
/*
Java solution for the problem Quick Brown Fox (https://open.kattis.com/problems/quickbrownfox)
Execution time: 0.09 s
Submitted on 2017-02-28 00:15:11
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Character> al=new ArrayList<Character>(26);
        ArrayList<Character> aux=new ArrayList<Character>(26);
        int i=0,j=0;
        for(i=97;i<123;i++)
        {
            al.add((char)i);
            aux.add((char)i);
        }    
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s="";
        char c='x';
        for(i=0;i<n;i++)
        {
            s=sc.nextLine();
            lp:for(j=0;j<s.length();j++)
            {
                c=s.charAt(j);
                if(al.contains(c))
                {
                    aux.remove(new Character(c));
                    continue lp;
                }
                if(al.contains((char)((int)c+32)))
                {
                    aux.remove(new Character((char)((int)c+32)));
                }
            }
            if(aux.size()==0)
                System.out.println("pangram");
            else
            {
                System.out.print("missing ");
                for(char ch:aux)
                    System.out.print(ch);
                System.out.print("\n");
            }
            aux=new ArrayList<Character>((ArrayList<Character>)al);
        }
    }
}
/*
Java solution for the problem Smallest Multiple (https://open.kattis.com/problems/smallestmultiple)
Execution time: 0.13 s
Submitted on 2017-07-31 21:29:55
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.math.BigInteger;

public class Solution {
    static BigInteger lcm(BigInteger x,BigInteger y)
    {
        BigInteger a=x.multiply(y);
        BigInteger b=x.gcd(y);
        return a.divide(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String[] arr=sc.nextLine().split(" ");
            BigInteger lm=new BigInteger("1");
            for(int i=0;i<arr.length;i++)
            {
                lm=lcm(lm,new BigInteger(arr[i]));
            }
            System.out.println(lm);
        }
        }
    }

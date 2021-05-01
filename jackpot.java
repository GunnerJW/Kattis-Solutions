/*
Java solution for the problem Jackpot (https://open.kattis.com/problems/jackpot)
Execution time: 0.1 s
Submitted on 2017-08-21 00:45:37
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
        int machines=sc.nextInt();
        BigInteger billion=new BigInteger("1000000000");
        for(int i=0;i<machines;i++)
        {
            int wheels=sc.nextInt();
            sc.nextLine();
            String[] arr=sc.nextLine().split(" ");
            BigInteger lm=new BigInteger("1");
            for(int j=0;j<arr.length;j++)
                lm=lcm(lm,new BigInteger(arr[j]));
            if(lm.compareTo(billion)==1)
                System.out.println("More than a billion.");
            else
                System.out.println(lm);
        }
    }
}

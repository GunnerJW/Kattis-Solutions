/*
Java solution for the problem An Industrial Spy (https://open.kattis.com/problems/industrialspy)
Execution time: 0.95 s
Submitted on 2017-08-23 00:32:40
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

//An industrial spy

import java.util.*;

public class Solution{
    static class Maths
    {
	private static int x;
	private static int y;
	private static int d;
	static boolean isPrime(int n,ArrayList<Integer> primes)
	{
        if(n==1 || n==0)
            return false;
		int i=0;
		while(i<primes.size() && primes.get(i)*primes.get(i)<=n)
		{
			if(n%primes.get(i)==0)
				return false;
			i++;
		}
		return true;
	}
	public static int gcd(int a,int b)
	{
		return b==0?a:gcd(b,a%b);
	}
	static int lcm(int a,int b)
	{
		return a*b/gcd(a,b);
	}
	public static void extendedEuclid(int a,int b)
	{
		d=gcd(a,b);
		if (b == 0)
		{ x = 1; y = 0; d = a; return; }
		extendedEuclid(b,a%b);
		int x1 = y;
		int y1 = x - (a / b) * y;
		x = x1;
		y = y1;
	}
	public static HashMap<Integer,Integer> primeFctPow(int n,ArrayList<Integer> primes)//handle n<=1
	{
		int m=(int)Math.sqrt(n);
		double d=(m/Math.log(m))*(1+1.2762/Math.log(m));
		HashMap<Integer,Integer> hm=new	HashMap<Integer,Integer>((int)d);
		int i=0,tmp=n;
		int pf=primes.get(i);
		while(pf*pf<=tmp)
		{
			while(tmp%pf==0)
			{
				tmp/=pf;
				if(hm.containsKey(pf))
					hm.put(pf, hm.get(pf)+1);
				else
					hm.put(pf, 1);
			}
			i++;
			if(i>=primes.size())
				break;
			pf=primes.get(i);
		}
		if(tmp!=1)
		{
			if(hm.containsKey(tmp))
				hm.put(tmp, hm.get(tmp)+1);
			else
				hm.put(tmp, 1);
		}
		return hm;
	}
	public static ArrayList<Integer> primeFct(int n,ArrayList<Integer> primes)//handle n<=1
	{
		int m=(int)Math.sqrt(n);
		double d=(m/Math.log(m))*(1+1.2762/Math.log(m));
		ArrayList<Integer> al=new ArrayList<Integer>((int)d);
		int i=0,tmp=n;
		int pf=primes.get(i);
		while(pf*pf<=tmp)
		{
			while(tmp%pf==0)
			{
				tmp/=pf;
				al.add(pf);
			}
			i++;
			if(i>=primes.size())
				break;
			pf=primes.get(i);
		}
		if(tmp!=1)
		{
			al.add(tmp);
		}
		return al;
	}
	public static ArrayList<Integer> primeSieve(int n)
	{
		ArrayList<Integer> primes=new ArrayList<Integer>();
		boolean[] crossed=new boolean[n+1];
		crossed[0]=true;
		crossed[1]=true;
		int m=0,i;
		while(m!=n)
		{
			for(i=2;i<n+1;i++)
			{
				if(crossed[i]==false)
				{
					m=i;
					primes.add(m);
					break;
				}
			}
			if(i==n+1)
				break;
			for(i=m;i<n+1;i+=m)
			{
				crossed[i]=true;
			}
		}
		return primes;
	}
	public static int getX()
	{
		return x;
	}
	public static int getY()
	{
		return y;
	}
	public static int eulerPhi(int n,ArrayList<Integer> primes)
	{
		int phi=1;
		int i=0,tmp=n;
		int pf=primes.get(i);
		int exp;
		while(pf*pf<=tmp)
		{
			exp=0;
			while(tmp%pf==0)
			{
				tmp/=pf;
				exp++;
				if(exp==1)
					phi*=pf-1;
				else
					phi*=pf;
			}
			i++;
			if(i>=primes.size())
				break;
			pf=primes.get(i);
		}
		if(tmp!=1)
		{
			phi*=tmp-1;
		}
		return phi;
	}
}
    static ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141, 2143, 2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269, 2273, 2281, 2287, 2293, 2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371, 2377, 2381, 2383, 2389, 2393, 2399, 2411, 2417, 2423, 2437, 2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531, 2539, 2543, 2549, 2551, 2557, 2579, 2591, 2593, 2609, 2617, 2621, 2633, 2647, 2657, 2659, 2663, 2671, 2677, 2683, 2687, 2689, 2693, 2699, 2707, 2711, 2713, 2719, 2729, 2731, 2741, 2749, 2753, 2767, 2777, 2789, 2791, 2797, 2801, 2803, 2819, 2833, 2837, 2843, 2851, 2857, 2861, 2879, 2887, 2897, 2903, 2909, 2917, 2927, 2939, 2953, 2957, 2963, 2969, 2971, 2999, 3001, 3011, 3019, 3023, 3037, 3041, 3049, 3061, 3067, 3079, 3083, 3089, 3109, 3119, 3121, 3137));
    public static HashSet<String> perm(String s)
	 {
		 int l=s.length();
		 ArrayDeque<String> up=new ArrayDeque<String>();
		 ArrayDeque<StringBuilder> down=new ArrayDeque<StringBuilder>();
		 up.add("");
		 down.add(new StringBuilder(s));
		 for(int i=0;i<l;i++)
		 {
			 int size=up.size();
			 for(int j=0;j<size;j++)
			 {
				 String x=up.remove();
				 StringBuilder xsb=new StringBuilder(down.remove());
				 int lsb=xsb.length();
				 for(int k=0;k<lsb;k++)
				 {
					 up.add(x.concat(String.valueOf(xsb.charAt(k))));
					 StringBuilder tmp=new StringBuilder(xsb);
					 down.add(tmp.deleteCharAt(k));
				 }
			 }
		 }
		 HashSet<String> hs=new HashSet<String>(up.size());
		 int size=up.size();
		 for(int i=0;i<size;i++)
		 {
			 hs.add(up.remove());
		 }
		 return hs;
	 }
    public static HashSet<String> generateInt(String s)
	{
		int n=s.length();
		int x=(int)Math.pow(2, n);
		HashSet<String> hs=new HashSet<String>(x);
		for(int i=1;i<x;i++)
		{
			String br=String.format("%"+n+"s", Integer.toBinaryString(i));
			StringBuilder sb=new StringBuilder(n);
			for(int j=0;j<n;j++)
			{
				if(Character.compare(br.charAt(j), '1')==0)
					sb.append(s.charAt(j));
			}
			hs.add(sb.toString());
		}
		return hs;
	}
    static boolean isaPrime(double num) { // Returns true if prime number
		if (num == 2) {
			return true;
		} else if (num % 2 == 0) {
			return false;
		} else if (num == 1) {
			return false;
		}
		double sqrt = Math.sqrt(num);
		for (double i = 3; i <= (sqrt); i+=2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int numbers=sc.nextInt();
        for(int i=0;i<numbers;i++)
        {
            String x=sc.next();
            HashSet<Integer> perms=new HashSet<Integer>();
            HashSet<String> combs=generateInt(x);
            for(String comb : combs)
            {
                HashSet<String> aux=perm(comb);
                for(String tmp : aux)
                    perms.add(Integer.parseInt(tmp));
            }
            int sum=0;
            //System.out.println(perms);
            for(int perm : perms)
                if(Maths.isPrime(perm,al))
                    sum++;
            System.out.println(sum);
        }
        //System.out.println(Maths.primeSieve(3163));
    }
}
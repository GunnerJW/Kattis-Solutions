/*
C++ solution for the problem Primal Representation (https://open.kattis.com/problems/primalrepresentation)
Execution time: 0.25 s
Submitted on 2020-01-10 21:43:56
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <map>
#include <queue>
#include <cmath>
#include <algorithm>
#include <iomanip>
#include <stack>
#include <bitset>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;

map<ull, int> primeFactors(long long n)
{
    map<ull, int> res;
    // Print the number of 2s that divide n
    while (n % 2 == 0)
    {
        res[2] += 1;
        n = n/2;
    }

    // n must be odd at this point. So we can skip
    // one element (Note i = i +2)
    for (int i = 3; i <= sqrt(n); i = i + 2)
    {
        // While i divides n, print i and divide n
        while (n % i == 0)
        {
            res[i] += 1;
            n = n/i;
        }
    }
    if (n > 2)
        res[n] += 1;
    return res;
}

int main() {
//    ios::sync_with_stdio(false);
    long long n;
    while(scanf("%lld", &n) == 1) {
        if(n < 0)
            printf("-1 ");
        for(auto kv : primeFactors(abs(n))){
            if(kv.second > 1)
                printf("%lld^%d ", kv.first, kv.second);
            else
                printf("%lld ", kv.first);
        }
        cout << endl;
    }
    return 0;
}
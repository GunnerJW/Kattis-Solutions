/*
C++ solution for the problem Diagonal Cut (https://open.kattis.com/problems/diagonalcut)
Execution time: 0.0 s
Submitted on 2019-12-08 11:44:13
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <vector>
#include <unordered_map>
#include <climits>

using namespace std;

typedef unsigned long long ull;

ull gcd(ull a, ull b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main() {
    ull m, n;
    cin >> m >> n;
    ull g = gcd(m, n);
    ull g_m = m / g;
    ull g_n = n / g;
    ull res = 0;
    ull upper_bound = 2 * m - 1;
    if (g_n % 2 == 1) {
        if (g_m % 2 == 1) {
            ull tmp = upper_bound / g_m;
            if (tmp % 2 == 0)
                tmp -= 1;
            res = (tmp - 1) / 2 + 1;
        }
    }
    cout << res;
    return 0;
}
/*
C++ solution for the problem Suspension Bridges (https://open.kattis.com/problems/suspensionbridges)
Execution time: 0.0 s
Submitted on 2020-01-19 16:58:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <map>
#include <queue>
#include <cmath>
#include <iomanip>
#include <stack>
#include <bitset>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <cfloat>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

ld d, s;

ld f(ld x){
    return x * coshl(d / (2 * x)) - x - s;
}

int main() {
    ios::sync_with_stdio(false);
    cin >> d >> s;
    ld EPS = 0.00000000070;
    ld ZERO = 0.0;
    ld left = EPS;
    ld right = LDBL_MAX;
    ld mid = (right + left) / 2;
    while((right - left) > EPS){
        mid = (right + left) / 2;
        ld y = f(mid);
        if(abs(y) <= EPS)
            break;
        if(y > EPS)
            left = mid;
        else if(y < -EPS)
            right = mid;
    }
    cout << setprecision(15) << fixed << 2 * mid * sinhl(d / (2 * mid));
    return 0;
}
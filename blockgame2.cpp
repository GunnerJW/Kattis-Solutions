/*
C++ solution for the problem Block Game (https://open.kattis.com/problems/blockgame2)
Execution time: 0.0 s
Submitted on 2020-01-05 12:22:54
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_map>
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


int main() {
    ios::sync_with_stdio(false);
    ld golden_ratio = (1 + sqrtl(5)) / 2;
    ld a, b;
    cin >> a >> b;
    if(a == b)
        cout << "win";
    else {
        ld mx = max(a, b);
        ld mn = min(a, b);
        if((mx / mn) > golden_ratio)
            cout << "win";
        else
            cout << "lose";
    }
    return 0;
}
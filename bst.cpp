/*
C++ solution for the problem Binary search tree (https://open.kattis.com/problems/bst)
Execution time: 0.54 s
Submitted on 2020-01-09 21:25:54
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


int main() {
//    ios::sync_with_stdio(false);
    int n;
    scanf("%d", &n);
    map<int, int> depth = map<int, int>();
    ull res = 0;
    for (int i = 0; i < n; i++) {
        int x;
        scanf("%d", &x);
        int max_ = 0;
        auto it = depth.lower_bound(x);
        if (it != depth.end())
            max_ = max(max_, it->second + 1);
        if (it != depth.begin())
            max_ = max(max_, (--it)->second + 1);
        depth[x] = max_;
        res += max_;
        cout << res << endl;
    }
    return 0;
}
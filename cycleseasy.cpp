/*
C++ solution for the problem Cycles (Easy) (https://open.kattis.com/problems/cycleseasy)
Execution time: 0.05 s
Submitted on 2020-01-12 14:45:26
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

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;

unsigned int n;
unordered_map<int, unordered_set<int>> excluded;
vector<unordered_map<ull, ull>> memo;

ull explore(int start, unsigned int index, ull state) {
    if (state == ((1u << n) - 1)) {
        if (excluded[index].find(start) == excluded[index].end())
            return 1;
        return 0;
    }
    if (memo[index].find(state) != memo[index].end())
        return memo[index][state];
    ull res = 0;
    for (unsigned int v = 0; v < n; v++) {
        if (((state & (1u << v)) != 0) || (excluded[index].find(v) != excluded[index].end()))
            continue;
        res += explore(start, v, state | (1u << v));
    }
    return memo[index][state] = res;
}


int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    for (int it = 1; it <= t; it++) {
        int k;
        cin >> n >> k;
        excluded.clear();
        while (k--) {
            int a, b;
            cin >> a >> b;
            a--;
            b--;
            excluded[a].insert(b);
            excluded[b].insert(a);
        }
        ull res = 0;
        for (unsigned int i = 0; i < n; i++){
            memo.clear();
            memo.resize(n);
            res += explore(i, i, (1u << i));
        }
        res /= 2 * n;
        res %= 9901;
        cout << "Case #" << it << ": " << res << endl;
    }
    return 0;
}
/*
C++ solution for the problem Nikola (https://open.kattis.com/problems/nikola)
Execution time: 0.01 s
Submitted on 2020-02-22 11:58:55
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>
#include <cmath>
#include <set>
#include <algorithm>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

int n;
vi costs;
vector<vector<long long>> memo;

long long run(int i, int prev_step){
    if(i == n - 1)
        return 0;
    if(memo[i][prev_step] != -1)
        return memo[i][prev_step];
    long long res = -1;
    if(i + prev_step + 1 < n)
        res = costs[i + prev_step + 1] + run(i + prev_step + 1, prev_step + 1);
    if(i - prev_step >= 0) {
        long long x = costs[i - prev_step] + run(i - prev_step, prev_step);
        if (res == -1)
            res = x;
        else
            res = min(x, res);
    }
    memo[i][prev_step] = res;
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    costs.resize(n);
    for(int& c: costs)
        cin >> c;
    vector<long long> DEF(n, -1);
    memo.resize(n, DEF);
    long long cost = costs[1] + run(1, 1);
    cout << cost;
    return 0;
}
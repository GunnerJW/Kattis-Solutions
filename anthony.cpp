/*
C++ solution for the problem Anthony and Cora (https://open.kattis.com/problems/anthony)
Execution time: 0.02 s
Submitted on 2020-12-14 14:08:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>
#include <cmath>
#include <set>
#include <algorithm>
#include <climits>
#include <unordered_map>
#include <queue>
#include <tuple>
#include <deque>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

int n, m;
vector<double> probas;
vector<vector<double>> memo;


double run(int w, int l){
    if(l >= n)
        return 0;
    if(w == m and l <= n - 1)
        return 1;
    if(memo[w][l] != -1)
        return memo[w][l];
    double p = probas[w + l];
    double res = p * run(w + 1, l) + (1 - p) * run(w, l + 1);
    memo[w][l] = res;
    return res;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    probas.reserve(n + m - 1);
    for(int i = 0; i < n + m - 1; i++){
        double p;
        cin >> p;
        probas.push_back(p);
    }
    vector<double> DEF(n + 1, -1);
    memo.resize(m + 1, DEF);
    double ans = run(0, 0);
    cout << ans;
    return 0;
}
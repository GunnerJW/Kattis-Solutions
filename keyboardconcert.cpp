/*
C++ solution for the problem Keyboards in Concert (https://open.kattis.com/problems/keyboardconcert)
Execution time: 0.42 s
Submitted on 2020-04-26 21:25:51
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>
#include <cmath>
#include <set>
#include <algorithm>
#include <climits>
#include <unordered_map>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

int n, m;
unordered_map<int, vi> dct;
vi sequence;
vector<vi> memo;

int run(int pos, int cur) {
    if (pos == m - 1)
        return 0;
    if (memo[pos][cur] != 1001)
        return memo[pos][cur];
    int next = sequence[pos + 1];
    int res = 1001;
    for (int inst: dct[next]) {
        int x = (inst == cur) ? 0 : 1;
        res = min(res, x + run(pos + 1, inst));
    }
    memo[pos][cur] = res;
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        for (int j = 0; j < x; j++) {
            int note;
            cin >> note;
            dct[note].push_back(i);
        }
    }
    sequence.reserve(m);
    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;
        sequence.push_back(x);
    }
    memo.resize(m, vi(n, 1001));
    int first = sequence[0];
    int ans = 1001;
    for (int inst: dct[first]) {
        ans = min(ans, run(0, inst));
    }
    cout << ans;
    return 0;
}
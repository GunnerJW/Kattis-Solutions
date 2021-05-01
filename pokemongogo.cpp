/*
C++ solution for the problem Pokemon Go Go (https://open.kattis.com/problems/pokemongogo)
Execution time: 0.05 s
Submitted on 2020-01-18 22:35:22
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <map>
#include <queue>
#include <cmath>
#include <bitset>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <limits.h>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

int n;
vector<int> x_axis, y_axis;
vector<vector<ull>> memo;
vector<ull> pokemon_to_index;
ull max_state;


ull run(int index, ull state) {
    if (state == max_state) {
        return abs(x_axis[index]) + abs(y_axis[index]);
    }
    if (memo[index][state] < INT_MAX)
        return memo[index][state];
    ull res = INT_MAX;
    for (int i = 0; i < n; i++) {
        if (i == index)
            continue;
        ull pk_index = 1ull << pokemon_to_index[i];
        if ((state & pk_index) != 0)
            continue;
        ull dist = abs(x_axis[i] - x_axis[index]) + abs(y_axis[i] - y_axis[index]);
        res = min(res, dist + run(i, state | pk_index));
    }
    return memo[index][state] = res;
}


int main() {
    ios::sync_with_stdio(false);
    cin >> n;
    unordered_map<string, int> unique_p;
    int idx = -1;
    pokemon_to_index.resize(n);
    x_axis.resize(n);
    y_axis.resize(n);
    for (int i = 0; i < n; i++) {
        int x, y;
        string p;
        cin >> x >> y >> p;
        x_axis[i] = x;
        y_axis[i] = y;
        if (unique_p.find(p) == unique_p.end()) {
            idx++;
            unique_p[p] = idx;
        }
        pokemon_to_index[i] = unique_p[p];
    }
    max_state = (1ull << unique_p.size()) - 1;
    vector<ull> DEF(max_state + 1, INT_MAX);
    memo.resize(n);
    for (int i = 0; i < n; i++)
        memo[i] = DEF;
    ull res = INT_MAX;
    for (int i = 0; i < n; i++)
        res = min(res, abs(x_axis[i]) + abs(y_axis[i]) + run(i, (1u << pokemon_to_index[i])));
    cout << res;
    return 0;
}
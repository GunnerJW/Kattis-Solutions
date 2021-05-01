/*
C++ solution for the problem Collecting Beepers (https://open.kattis.com/problems/beepers)
Execution time: 0.01 s
Submitted on 2020-02-22 14:45:38
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>
#include <cmath>
#include <set>
#include <algorithm>
#include <climits>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

unsigned int n;
unsigned int full_tour;
int r, c, xs, ys;
vector<pii> coordinates;
vector<vi> memo;

int run(int i, unsigned int bitmask){
    if(bitmask == full_tour){
        return abs(xs - coordinates[i].first) + abs(ys - coordinates[i].second);
    }
    if(memo[i][bitmask] != -1)
        return memo[i][bitmask];
    int res = INT_MAX;
    for(unsigned int b = 0; b < n; b++){
        if((bitmask & (1u << b)) != 0)
            continue;
        res = min(res, abs(coordinates[i].first - coordinates[b].first) +
                       abs(coordinates[i].second - coordinates[b].second) +
                       run((int)b, bitmask | (1u << b)));
    }
    memo[i][bitmask] = res;
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while(t--){
        cin >> r >> c;
        cin >> xs >> ys;
        cin >> n;
        coordinates.clear();
        coordinates.reserve(n);
        for(unsigned int i = 0;i < n;i++){
            int x, y;
            cin >> x >> y;
            coordinates.emplace_back(x, y);
        }
        full_tour = (1u << n) - 1;
        vi DEF(full_tour + 1, -1);
        memo.clear();
        memo.resize(n, DEF);
        int res = INT_MAX;
        for(unsigned int i = 0; i < n;i++)
            res = min(res, abs(xs - coordinates[i].first) +
                           abs(ys - coordinates[i].second) +
                           run((int)i, 1u << i));

        cout << res << "\n";
    }
    return 0;
}
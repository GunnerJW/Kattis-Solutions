/*
C++ solution for the problem Presidential Elections (https://open.kattis.com/problems/presidentialelections)
Execution time: 0.01 s
Submitted on 2020-01-19 11:31:29
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
#include <climits>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

int total;
int majority_delegates;
vi delegates, undecided, left_to_majority, suffix_sum;
vector<vi> memo;
int MAX = 1000000001;

int run(int index, int votes) {
    if (votes >= majority_delegates)
        return 0;
    if (index == total)
        return MAX;
    if (votes + suffix_sum[index] < majority_delegates)
        return MAX;
    if (memo[index][votes] < MAX)
        return memo[index][votes];
    int res = run(index + 1, votes);
    res = min(res, left_to_majority[index] + run(index + 1, votes + delegates[index]));
    return memo[index][votes] = res;
}


int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    delegates.reserve(n);
    undecided.reserve(n);
    left_to_majority.reserve(n);
    int total_delegates = 0;
    int d, c, f, u;
    int already_won = 0;
    for (int i = 0; i < n; i++) {
        cin >> d >> c >> f >> u;
        int left = (c + f + u) / 2 + 1 - c;
        if(left <= 0)
            already_won += d;
        else if(left <= u) {
            delegates.push_back(d);
            undecided.push_back(u);
            left_to_majority.push_back(left);
        }
        total_delegates += d;
    }
    majority_delegates = total_delegates / 2 + 1;
    total = delegates.size();
    if(total == 0){
        if(already_won >= majority_delegates)
            cout << 0;
        else
            cout << "impossible";
        return 0;
    }
    suffix_sum.resize(total);
    suffix_sum[total - 1] = delegates[total - 1];
    for (int i = total - 2; i >= 0; i--)
        suffix_sum[i] = suffix_sum[i + 1] + delegates[i];
    memo.reserve(total);
    vector<int> DEF(total_delegates + 1, MAX);
    for (int i = 0; i < total; i++)
        memo.push_back(DEF);
    int res = run(0, already_won);
    if (res >= MAX)
        cout << "impossible";
    else
        cout << res;
    return 0;
}
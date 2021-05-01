/*
C++ solution for the problem Canonical Coin Systems (https://open.kattis.com/problems/canonical)
Execution time: 0.21 s
Submitted on 2020-01-13 21:13:38
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

int n;
vi coins;


int main() {
    ios::sync_with_stdio(false);
    cin >> n;
    if (n == 2) {
        cout << "canonical";
        return 0;
    }
    unordered_map<int, int> coin_to_index;
    coins.resize(n);
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        coin_to_index[x] = i;
        coins[i] = x;
    }
    int lower_bound = coins[2] + 2;
    int upper_bound = coins[n - 1] + coins[n - 2] - 1;
    int g_memo[upper_bound + 1];
    g_memo[0] = 0;
    int last_coin = 1;
    int last_coin_index = 0;
    for (int x = 1; x <= upper_bound; x++) {
        if (coin_to_index.find(x) != coin_to_index.end()) {
            g_memo[x] = 1;
            last_coin = x;
            last_coin_index = coin_to_index[x];
        }
        else {
            int q = x / last_coin;
            int r = x - last_coin * q;
            g_memo[x] = g_memo[r] + q;
        }
        if(x >= lower_bound){
            for(int i=0;i<=last_coin_index;i++){
                if(g_memo[x] > g_memo[x - coins[i]] + 1){
                    cout << "non-canonical";
                    return 0;
                }
            }
        }
    }
    cout << "canonical";
    return 0;
}
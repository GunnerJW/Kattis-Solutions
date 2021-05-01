/*
C++ solution for the problem Restaurant Orders (https://open.kattis.com/problems/orders)
Execution time: 0.06 s
Submitted on 2020-02-23 00:20:28
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

int n;
vi menu;
vector<vi> memo;
const int MOD = 1000000007;

int ways(int item, int left){
    if(left == 0)
        return 1;
    if(item == n)
        return 0;
    if(memo[item][left] != -1)
        return memo[item][left];
    int res = 0;
    for(int i = 0; i <= left / menu[item];i++)
        res = (res + ways(item + 1, left - i * menu[item])) % MOD;
    return memo[item][left] = res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n;
    menu.resize(n);
    for(int& x: menu)
        cin >> x;
    int m;
    cin >> m;
    vi DEF(30001, -1);
    memo.resize(n, DEF);
    vi orders(m, 0);
    for(int& o : orders)
        cin >> o;
    for(int order: orders){
        int res = ways(0, order);
        if(res == 0)
            cout << "Impossible";
        else if(res > 1)
            cout << "Ambiguous";
        else{
            int left = order;
            int item = 0;
            while(left != 0 && item < n - 1){
                for(int i = 0; i <= left / menu[item];i++){
                    int left2 = left - i * menu[item];
                    if(left2 == 0){
                        for(int j = 0;j < i;j++)
                            cout << (item + 1) << " ";
                        left = 0;
                        break;
                    }
                    if(memo[item + 1][left2] == 1){
                        for(int j = 0;j < i;j++)
                            cout << (item + 1) << " ";
                        left -= i * menu[item];
                        break;
                    }
                }
                item++;
            }
            if(left != 0){
                for(int i = 0;i < left / menu[item];i++)
                    cout << (item + 1) << " ";
            }
        }
        cout << "\n";
    }
    return 0;
}
/*
C++ solution for the problem Batmanacci (https://open.kattis.com/problems/batmanacci)
Execution time: 0.0 s
Submitted on 2020-01-04 00:52:53
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_map>
#include <queue>
#include <cmath>
#include <algorithm>
#include <iomanip>
#include <stack>
#include <bitset>

using namespace std;

typedef unsigned long long ull;
typedef vector<int> vi;

ull MAX = 1'000'000'000'000'000'000;


int main() {
    ios::sync_with_stdio(false);
    int n;
    ull k;
    cin >> n >> k;
    vector<ull> fib;
    fib.reserve(n + 1);
    fib.push_back(0);
    fib.push_back(1);
    int i = 1;
    while(fib[i] < MAX){
        fib.push_back(fib[i] + fib[i - 1]);
        i++;
    }
    if(n > (i + 1)){
        if(n - i % 2 == 1)
            n = i + 1;
        else
            n = i;
    }
    while(n > 2){
        if(k <= fib[n - 2])
            n -= 2;
        else{
            k -= fib[n - 2];
            n--;
        }
    }
    cout << (n == 1 ? "N" : "A");
    return 0;
}
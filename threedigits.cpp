/*
C++ solution for the problem Three Digits (https://open.kattis.com/problems/threedigits)
Execution time: 0.05 s
Submitted on 2020-02-08 22:13:42
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;


int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
    int n;
    cin >> n;
    int fives = 0;
    ull res = 1;
    for(int x = 5; x <= n; x += 5){
        int i = x;
        while(i % 5 == 0){
            fives++;
            i /= 5;
        }
        res = (res * i) % 1000;
    }
    bool flag = false;
    for(int x = 2; x <= n; x++){
        if(x % 5 == 0)
            continue;
        int i = x;
        while(fives && (i % 2 == 0)){
            fives--;
            i /= 2;
        }
        res = (res * i);
        flag = res >= 1000;
        res %= 1000;
    }
    if(flag)
        printf("%03d", res);
    else
        printf("%d", res);
}
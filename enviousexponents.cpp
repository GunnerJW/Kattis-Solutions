/*
C++ solution for the problem Envious Exponents (https://open.kattis.com/problems/enviousexponents)
Execution time: 0.0 s
Submitted on 2020-02-20 23:08:36
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

// envious
#include <iostream>
#include <vector>
#include <bitset>
#include <cmath>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    ull n;
    int k;
    cin >> n >> k;
    const int B = 61;
    bitset<B> b(n);
    int c = b.count();
    if(c == k){
        int pos = -1;
        for(int i = 0; i < B; i++){
            if(b[i]){
                pos = i;
                b[i] = false;
                break;
            }
        }
        int set = 0;
        for(int i = pos + 1; i < B; i++){
            if(!b[i]){
                b[i] = true;
                break;
            }
            else{
                set++;
                b[i] = false;
            }
        }
        int i = 0;
        while(set--){
            b[i] = true;
            i++;
        }
    }
    else if(c < k){
        int diff = k - c;
        for(int i = 0; i < B && diff > 0; i++){
            if(!b[i]){
                b[i] = true;
                diff--;
            }
        }
    }
    else{
        int diff = c - k + 1;
        int i = 0;
        while(diff > 0){
            if(b[i]){
                b[i] = false;
                diff--;
            }
            i++;
        }
        int set = 0;
        while(i < B){
            if(b[i]){
                set++;
                b[i] = false;
            }
            else{
                b[i] = true;
                break;
            }
            i++;
        }
        i = 0;
        while(set--){
            b[i] = true;
            i++;
        }
    }
    cout << b.to_ullong();
}
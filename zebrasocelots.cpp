/*
C++ solution for the problem Zebras and Ocelots (https://open.kattis.com/problems/zebrasocelots)
Execution time: 0.0 s
Submitted on 2020-01-04 20:39:50
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

bool is_prime(ull x){
    if(x < 2)
        return false;
    if(x == 2)
        return true;
    int upper_bound = (int)sqrt(x);
    for(int i = 2; i <= upper_bound; i++)
        if(x % i == 0)
            return false;
    return true;
}

int main() {
    ios::sync_with_stdio(false);
//    int t;
//    cin >> t;
//    while(t--){
//        string s;
//        cin >> s;
//        int up = 0, down = 0;
//        // Base 2
//        try {
//            ull x = stoull(s, nullptr, 2);
//            down++;
//            if(is_prime(x))
//                up++;
//        }
//        catch(invalid_argument& e){}
//        // Base 8
//        try {
//            ull x = stoull(s, nullptr, 8);
//            down++;
//            if(is_prime(x))
//                up++;
//        }
//        catch(invalid_argument& e){}
//        // Base 10
//        try {
//            ull x = stoull(s, nullptr, 10);
//            down++;
//            if(is_prime(x))
//                up++;
//        }
//        catch(invalid_argument& e){}
//        // Base 16
//        try {
//            ull x = stoull(s, nullptr, 16);
//            down++;
//            if(is_prime(x))
//                up++;
//        }
//        catch(invalid_argument& e){}
//        if(up == 0)
//            down = 1;
//        if(up == down){
//            up = 1;
//            down = 1;
//        }
//        if(up == 2 && down == 4){
//            up = 1;
//            down = 2;
//        }
//        cout << up << "/" << down << endl;
//    }
    int n;
    cin >> n;
    bitset<60> b;
    while(n--){
        char c;
        cin >> c;
        if(c == 'O')
            b.set(n);
    }
    cout << b.to_ullong();
    return 0;
}
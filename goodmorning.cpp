/*
C++ solution for the problem Good Morning! (https://open.kattis.com/problems/goodmorning)
Execution time: 0.0 s
Submitted on 2019-12-08 16:08:49
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <vector>
#include <unordered_map>
#include <climits>

using namespace std;

typedef unsigned long long ull;

bool possible(int x) {
    if (x / 10 == 0)
        return true;
    int first_digit = x % 10;
    int second_digit = (x / 10) % 10;
    if (first_digit == 0) {
        if (second_digit == 3 or second_digit == 6 or second_digit == 9)
            return false;
        return possible(x / 10);
    }
    if(second_digit == 0)
        return false;
    int row_first = (first_digit - 1) / 3;
    int col_first = (first_digit - 1) % 3;
    int row_second = (second_digit - 1) / 3;
    int col_second = (second_digit - 1) % 3;
    if (row_first >= row_second && col_first >= col_second)
        return possible(x / 10);
    return false;
}

int main() {
//    bool b = possible(101);
    vector<int> v;
    for (int i = 1; i <= 200; i++)
        if (possible(i))
//            cout << i << endl;
            v.push_back(i);
    int n;
    cin >> n;
    while(n--){
        int k;
        cin >> k;
        int i =0;
        while(k > v[i])
            i++;
        if(k == v[i])
            cout << k << endl;
        else{
            if(v[i] - k <= k - v[i-1])
                cout << v[i] << endl;
            else
                cout << v[i-1] << endl;
        }
    }
    return 0;
}
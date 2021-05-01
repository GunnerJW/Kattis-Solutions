/*
C++ solution for the problem Veci (https://open.kattis.com/problems/veci)
Execution time: 0.0 s
Submitted on 2019-11-25 21:23:34
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

int ten_pow(int exponent){
    return int(pow(10, exponent));
}

int main() {
    int n;
    cin >> n;
    int aux = n;
    int digits = floor(log10(n) + 1);
    int swap_position = -1;
    bool possible = false;
    for (int i = 0; i < digits - 1 && !possible; i++) {
        int ith_digit = (n / ten_pow(i)) % 10;
        for (int j = i + 1; j < digits && !possible; j++) {
            int jth_digit = (n / ten_pow(j)) % 10;
            if (j == i + 1 && ith_digit == jth_digit)
                break;
            if (ith_digit > jth_digit) {
                aux -= ith_digit * ten_pow(i) + jth_digit * ten_pow(j);
                aux += ith_digit * ten_pow(j) + jth_digit * ten_pow(i);
                swap_position = j;
                possible = true;
            }
        }
    }
    if(swap_position == -1)
        cout << 0;
    else{
        string s = to_string(aux);
        sort(s.begin() + digits - swap_position, s.end());
        cout << s;
    }
    return 0;
}
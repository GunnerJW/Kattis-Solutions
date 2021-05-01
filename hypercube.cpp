/*
C++ solution for the problem Hamiltonian Hypercube (https://open.kattis.com/problems/hypercube)
Execution time: 0.0 s
Submitted on 2019-12-07 10:07:49
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

unsigned long long pos(unsigned long long x, int gray_order){
    if(gray_order==1)
        return x;
    unsigned long long tmp = 1ull << (gray_order - 1);
    if(x < tmp)
        return pos(x, gray_order - 1);
    unsigned long long res = pos(x - tmp, gray_order - 1);
    unsigned long long half = tmp - 1;
    return 2 * half + 1 - res;
}

int main() {
    int n;
    cin >> n;
    string a_s, b_s;
    cin >> a_s >> b_s;
    unsigned long long a = stoull(a_s, nullptr, 2);
    unsigned long long b = stoull(b_s, nullptr, 2);
    //cout << pos(a, n) << " " << pos(b, n);
    unsigned long long pos_a = pos(a, n);
    unsigned long long pos_b = pos(b, n);
    cout << pos_b - pos_a - 1;
    return 0;
}
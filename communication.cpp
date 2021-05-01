/*
C++ solution for the problem Jumbled Communication (https://open.kattis.com/problems/communication)
Execution time: 0.01 s
Submitted on 2019-12-01 13:30:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
# include <cmath>
# include <iomanip>

using namespace std;

int main() {
    int n;
    cin >> n;
    while(n--){
        int coded;
        cin >> coded;
        int res = 0;
        int bits[8];
        for(int& b: bits)
            b = 0;
        bits[0] = 0 ^ (coded & 1);
        for(int i=1;i < 8;i++){
            int val = (bits[i-1] << i) ^ (coded & (1 << i));
            if(val){
                bits[i] = 1;
            }
        }
        for(int i=0;i<8;i++){
            res |= (bits[i] << i);
        }
        cout << res << " ";
    }
    return 0;
}
/*
C++ solution for the problem Above Average (https://open.kattis.com/problems/aboveaverage)
Execution time: 0.0 s
Submitted on 2019-11-27 07:57:25
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>
#include <iomanip>

using namespace std;

int main() {
    int cases;
    cin >> cases;
    for(int i=0;i<cases;i++){
        int n;
        cin >> n;
        int arr[n];
        double average = 0;
        for(int& x : arr) {
            cin >> x;
            average += x;
        }
        average /= n;
        double above = 0;
        for(int& x : arr) {
            if(x > average)
                above++;
        }
        above /= n;
        above *= 100;
        cout << setprecision(3) << fixed << above << "%" << endl;
    }
    return 0;
}
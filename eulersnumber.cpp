/*
C++ solution for the problem Euler's Number (https://open.kattis.com/problems/eulersnumber)
Execution time: 0.0 s
Submitted on 2019-11-24 09:20:50
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    int n;
    cin >> n;
    double f[n+1];
    f[0] = 1;
    for(int i=1;i<=n;i++){
        f[i] = f[i-1] / i;
    }
    double res = 0;
    for(double& x: f)
        res += x;
    cout << setprecision(16) << res;
    return 0;
}
/*
C++ solution for the problem Amalgamated Artichokes (https://open.kattis.com/problems/artichoke)
Execution time: 0.17 s
Submitted on 2019-12-01 09:20:10
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
# include <cmath>
# include <iomanip>

using namespace std;

int main() {
    int p, a, b, c, d, n;
    cin >> p >> a >> b >> c >> d >> n;
    double arr[n];
    double mins[n];
    for (int i = n-1; i >= 0; i--){
        arr[i] = p * (sin(a * (i+1) + b) + cos(c * (i+1) + d) + 2);
        if(i==n-1)
            mins[i] = arr[i];
        else
            mins[i] = min(arr[i], mins[i + 1]);
    }
    double res = 0;
    for (int i = 0; i < n; i++)
        res = max(res, arr[i] - mins[i]);
    cout << setprecision(6) << fixed << res;
    return 0;
}
/*
C++ solution for the problem A Prize No One Can Win (https://open.kattis.com/problems/aprizenoonecanwin)
Execution time: 0.04 s
Submitted on 2019-11-29 07:54:42
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, x;
    cin >> n >> x;
    int arr[n];
    for (int &e: arr)
        cin >> e;
    sort(arr, arr + n);
    int i = 0;
    while (i < n - 1) {
        if (arr[i] + arr[i + 1] > x)
            break;
        i++;
    }
    cout << i + 1;
    return 0;
}
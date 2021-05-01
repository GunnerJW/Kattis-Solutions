/*
C++ solution for the problem Verify This, Your Majesty (https://open.kattis.com/problems/queens)
Execution time: 0.01 s
Submitted on 2019-12-13 21:25:48
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


int main() {
    int n;
    cin >> n;
    int rows[n];
    int cols[n];
    for(int i=0;i<n;i++){
        cin >> rows[i];
        cin >> cols[i];
    }
    bool correct = true;
    for(int i = 0;i<n-1;i++){
        for(int j =i+1;j<n;j++){
            if(rows[i] == rows[j] || cols[i] == cols[j] || (abs(cols[i] - cols[j]) == abs(rows[i] - rows[j]))){
                correct = false;
                break;
            }
        }
    }
    cout << (correct ? "CORRECT" : "INCORRECT");
    return 0;
}
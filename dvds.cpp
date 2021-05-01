/*
C++ solution for the problem DVDs (https://open.kattis.com/problems/dvds)
Execution time: 1.3 s
Submitted on 2019-12-11 20:00:23
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
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        int arr[n];
        for(int i=0;i < n;i++){
            int x;
            cin >> x;
            arr[x - 1] = i;
        }
        int i=0;
        while(i < n - 1 && arr[i] < arr[ i +1]){
            i++;
        }
        cout << n - 1 - i << endl;
    }
    return 0;
}
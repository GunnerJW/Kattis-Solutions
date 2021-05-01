/*
C++ solution for the problem Brownie Points I (https://open.kattis.com/problems/browniepoints)
Execution time: 0.16 s
Submitted on 2019-12-01 13:43:43
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
    while(n){
        int x[n], y[n];
        int x_center, y_center;
        for(int i=0; i < n;i++){
            cin >> x[i] >> y[i];
            if(i == n/2){
                x_center = x[i];
                y_center = y[i];
            }
        }
        int stan_score = 0, ollie_score = 0;
        for(int i=0; i < n;i++){
            bool stan = (x[i] > x_center && y[i] > y_center) || (x[i] < x_center && y[i] < y_center);
            bool ollie = (x[i] > x_center && y[i] < y_center) || (x[i] < x_center && y[i] > y_center);
            if(stan)
                stan_score++;
            else if(ollie)
                ollie_score++;
        }
        cout << stan_score << " " << ollie_score << endl;
        cin >> n;
    }
    return 0;
}
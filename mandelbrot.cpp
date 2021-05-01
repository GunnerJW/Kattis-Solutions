/*
C++ solution for the problem Mandelbrot (https://open.kattis.com/problems/mandelbrot)
Execution time: 0.0 s
Submitted on 2020-01-03 21:06:52
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_map>
#include <queue>
#include <cmath>
#include <algorithm>
#include <iomanip>
#include <stack>
#include <bitset>

using namespace std;

typedef unsigned long long ull;


int main() {
//    ios::sync_with_stdio(false);
    int t = 1;
    double real;
    while(scanf("%lf", &real) == 1){
        double im;
        double x = 0.0, y = 0.0;
        int it;
        scanf("%lf %d", &im, &it);
//        cin >> real >> im >> it;
        string state = "IN";
        for(int i=0;i <= it;i++){
            double mod = sqrt(x * x + y * y);
            if(mod > 2.0){
                state = "OUT";
                break;
            }
            double new_x = x * x - y * y + real;
            double new_y = 2 * x * y + im;
            x = new_x;
            y = new_y;
        }
        cout << "Case " << t << ": " << state << endl;
        t++;
    }
    return 0;
}
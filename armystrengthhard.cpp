/*
C++ solution for the problem Army Strength (Hard) (https://open.kattis.com/problems/armystrengthhard)
Execution time: 0.14 s
Submitted on 2019-12-01 14:11:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
# include <cmath>
# include <iomanip>

using namespace std;

int main() {
    int t;
    cin >> t;
    while(t--){
//        string blank;
//        cin >> blank;
        int godzilla, mecha;
        cin >> godzilla >> mecha;
        int g[godzilla], m[mecha];
        for(int& x: g)
            cin >> x;
        for(int& x: m)
            cin >> x;
        sort(g, g+godzilla);
        sort(m, m+mecha);
        int i_g = 0, i_m=0;
        while(i_g < godzilla && i_m < mecha){
            int s_g = g[i_g];
            int s_m = m[i_m];
            if(s_g >= s_m)
                i_m++;
            else
                i_g++;
        }
        if(i_m == mecha)
            cout << "Godzilla" << endl;
        else
            cout << "MechaGodzilla" << endl;
    }
    return 0;
}
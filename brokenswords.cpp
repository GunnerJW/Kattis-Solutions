/*
C++ solution for the problem Broken Swords (https://open.kattis.com/problems/brokenswords)
Execution time: 0.01 s
Submitted on 2019-11-24 15:33:13
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <string>
//#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    int v = 0, h = 0;
    for(int i=0;i<n;i++){
        string x;
        cin >> x;
        v += (x.at(0) == '0');
        v += (x.at(1) == '0');
        h += (x.at(2) == '0');
        h += (x.at(3) == '0');
    }
    int swords = min(v/2, h/2);
    int vleft = v - 2 * swords;
    int hleft = h - 2 * swords;
    cout << swords << " " << vleft << " " << hleft;
    return 0;
}
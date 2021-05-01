/*
C++ solution for the problem Backspace (https://open.kattis.com/problems/backspace)
Execution time: 0.02 s
Submitted on 2019-11-29 08:22:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

int main() {
    const char backspace = '<';
    string text;
    cin >> text;
    stack<char> s;
    for(char& c: text){
        if(c != backspace)
            s.push(c);
        else{
            if(s.empty())
                continue;
            else
                s.pop();
        }
    }
    int length = s.size();
    string res (length, ' ');
    for(int i=0;i < length; i++){
        char c = s.top();
        s.pop();
        res[length - i -1] = c;
    }
    cout << res;
    return 0;
}
/*
C++ solution for the problem Ferry Loading IV (https://open.kattis.com/problems/ferryloading4)
Execution time: 0.01 s
Submitted on 2019-12-27 21:37:33
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_set>
#include <queue>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        double l;
        int m;
        cin >> l >> m;
        l *= 100;
        double car_length;
        string side;
        queue<double> left;
        queue<double> right;
        for(int i=0;i<m;i++){
            cin >> car_length;
            cin >> side;
            if(side == "left")
                left.push(car_length);
            else
                right.push(car_length);
        }
        side = "left";
        int crosses = 0;
        double load = 0;
        while(!left.empty() or !right.empty()){
            if(side == "left"){
                while((load + left.front() <= l) and !left.empty()){
                    load += left.front();
                    left.pop();
                }
                crosses++;
                side = "right";
                load = 0;
            }
            else{
                while((load + right.front() <= l) and !right.empty()){
                    load += right.front();
                    right.pop();
                }
                crosses++;
                side = "left";
                load = 0;
            }
        }
        cout << crosses << endl;
    }
    return 0;
}
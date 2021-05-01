/*
C++ solution for the problem Distributing Ballot Boxes (https://open.kattis.com/problems/ballotboxes)
Execution time: 2.0 s
Submitted on 2020-01-18 14:28:39
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <map>
#include <queue>
#include <cmath>
#include <iomanip>
#include <stack>
#include <bitset>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;


int main() {
    ios::sync_with_stdio(false);
    string output = "";
    int c, b;
    cin >> c >> b;
    while(c != -1){
        priority_queue<pair<ld, pair<int, ld>>> pq;
        for(int i = 0;i<c;i++){
            ld voters;
            cin >> voters;
            pq.push(make_pair(voters, make_pair(1, voters)));
        }
        if(c == 1){
            output += to_string((int)ceil(pq.top().first / b));
            output += "\n";
        }
        else {
            int left = b - c;
            while (left != 0) {
                auto top = pq.top();
                ld x = top.first;
                int boxes = top.second.first;
                ld total = top.second.second;
                pq.pop();
                ld x2 = pq.top().first;
                int new_boxes = 0;
                while (ceil(total / boxes) >= x2 && new_boxes < left){
                    boxes++;
                    new_boxes++;
                }
                pq.push(make_pair(ceil(total / boxes), make_pair(boxes, total)));
                left -= new_boxes;
            }
            output += to_string((int)pq.top().first);
            output += "\n";
        }
        cin >> c >> b;
    }
    cout << output;
    return 0;
}
/*
C++ solution for the problem Stock Prices (https://open.kattis.com/problems/stockprices)
Execution time: 0.44 s
Submitted on 2020-01-03 22:12:06
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
typedef vector<int> vi;


int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        priority_queue<int, vector<int>, greater<>> ask;
        priority_queue<int> bid;
        int price = -1;
        while(n--){
            string order, _;
            int shares, p;
            cin >> order >> shares >> _ >> _ >> p;
            if(order == "buy"){
                while(shares--)
                    bid.push(p);
            }
            else{
                while(shares--)
                    ask.push(p);
            }
            while(!ask.empty() && !bid.empty() && (bid.top() >= ask.top())){
                price = ask.top();
                ask.pop();
                bid.pop();
            }
            if(ask.empty())
                cout << "- ";
            else
                cout << ask.top() << " ";
            if(bid.empty())
                cout << "- ";
            else
                cout << bid.top() << " ";
            if(price == -1)
                cout << "-" << endl;
            else
                cout << price << endl;
        }
    }
    return 0;
}
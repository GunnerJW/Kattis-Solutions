/*
C++ solution for the problem The Rectangles Are Surrounding Us! (https://open.kattis.com/problems/rectanglesurrounding)
Execution time: 1.43 s
Submitted on 2019-12-27 20:58:59
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_set>
#include <deque>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    while (n != 0) {
        unordered_set<int> coordinates;
        while (n--) {
            int x_bottom_right, y_bottom_right, x_top_left, y_top_left;
            cin >> x_bottom_right >> y_bottom_right >> x_top_left >> y_top_left;
            for (int y = y_bottom_right; y < y_top_left; y++) {
                int row = 500 - y - 1;
                for (int x = x_bottom_right; x < x_top_left; x++)
                    coordinates.insert(500 * row + x);
            }
        }
        cout << coordinates.size() << endl;
        cin >> n;
    }
    return 0;
}
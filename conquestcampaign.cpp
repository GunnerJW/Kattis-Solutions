/*
C++ solution for the problem Conquest Campaign (https://open.kattis.com/problems/conquestcampaign)
Execution time: 0.01 s
Submitted on 2019-11-24 11:53:25
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <queue>

using namespace std;

int main() {
    int rows, cols, cells;
    cin >> rows >> cols >> cells;
    int arr[rows][cols];
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            arr[i][j] = 10001;
    queue<int> q;
    for (int i = 0; i < cells; i++) {
        int r, c;
        cin >> r >> c;
        r -= 1;
        c -= 1;
        arr[r][c] = 1;
        q.push(r * cols + c);
    }
    while (!q.empty()) {
        int x = q.front();
        q.pop();
        int r = x / cols;
        int c = x % cols;
        int day = arr[r][c] + 1;
        if (r + 1 < rows && arr[r + 1][c] > day) {
            q.push((r + 1) * cols + c);
            arr[r + 1][c] = day;
        }
        if (r - 1 >= 0 && arr[r - 1][c] > day) {
            q.push((r - 1) * cols + c);
            arr[r - 1][c] = day;
        }
        if (c + 1 < cols && arr[r][c + 1] > day) {
            q.push(r * cols + c + 1);
            arr[r][c + 1] = day;
        }
        if (c - 1 >= 0 && arr[r][c - 1] > day) {
            q.push(r * cols + c - 1);
            arr[r][c - 1] = day;
        }
    }
    int res = 0;
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            if (arr[i][j] > res)
                res = arr[i][j];
    cout << res;
    return 0;
}
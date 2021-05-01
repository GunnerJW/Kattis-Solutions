"""
Python 3 solution for the problem Crop Triangles (Easy) (https://open.kattis.com/problems/cropeasy)
Execution time: 0.08 s
Submitted on 2020-02-29 13:04:16
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

t = int(input())

for case in range(1, t + 1):
    n, A, B, C, D, x0, y0, M = map(int, input().split())
    x = [x0]
    y = [y0]
    for i in range(1, n):
        x.append((A * x[-1] + B) % M)
        y.append((C * y[-1] + D) % M)
    res = 0
    for i in range(0, n):
        for j in range(i + 1, n):
            for k in range(j + 1, n):
                if ((x[i] + x[j] + x[k]) % 3 == 0) and ((y[i] + y[j] + y[k]) % 3 == 0):
                    res += 1
    print(f'Case #{case}: {res}')

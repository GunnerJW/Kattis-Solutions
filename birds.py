"""
Python 3 solution for the problem Birds on a Wire (https://open.kattis.com/problems/birds)
Execution time: 0.11 s
Submitted on 2020-01-10 20:23:34
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

l, d, n = map(int, input().split())

positions = []

for _ in range(n):
    positions.append(int(input()))

positions.sort()

if l < 12:
    print(0)
elif len(positions) == 0:
    print((l - 12) // d + 1)
else:
    res = 0
    res += (positions[0] - 6) // d
    res += (l - 6 - positions[-1]) // d
    for i in range(n - 1):
        res += (positions[i+1] - positions[i]) // d - 1
    print(res)

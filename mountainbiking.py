"""
Python 3 solution for the problem Mountain Biking (https://open.kattis.com/problems/mountainbiking)
Execution time: 0.05 s
Submitted on 2020-03-02 22:47:18
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import radians, cos, sqrt

n, g = map(float, input().split())
n = int(n)

data = [tuple(map(int, input().split())) for _ in range(n)]

suffix_sum = [0.0 for _ in range(n)]
suffix_sum[-1] = data[-1][0] * cos(radians(data[-1][1]))
for i in range(n - 2, -1, -1):
    suffix_sum[i] = suffix_sum[i + 1] + data[i][0] * cos(radians(data[i][1]))

for i in range(n):
    print(sqrt(2 * g * suffix_sum[i]))

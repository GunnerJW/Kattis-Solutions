"""
Python 3 solution for the problem I Hate The Number Nine (https://open.kattis.com/problems/nine)
Execution time: 0.02 s
Submitted on 2019-12-13 21:50:06
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

t = int(input())

for _ in range(t):
    d = int(input())
    if d == 1:
        print(8)
    else:
        res = 1
        print((8 * (pow(9, d - 1, 1000000007)) % 1000000007))

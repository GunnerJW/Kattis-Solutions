"""
Python 3 solution for the problem Euclid's Game (https://open.kattis.com/problems/euclidsgame)
Execution time: 0.05 s
Submitted on 2020-01-05 11:18:43
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import sqrt

GOLDEN_RATIO = (1 + sqrt(5)) / 2

a, b = map(int, input().split())
while a + b != 0:
    if a == b:
        print('Stan wins')
    else:
        mx = max(a, b)
        mn = min(a, b)
        if mx / mn > GOLDEN_RATIO:
            print('Stan wins')
        else:
            print('Ollie wins')
    a, b = map(int, input().split())
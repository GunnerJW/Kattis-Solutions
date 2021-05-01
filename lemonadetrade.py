"""
Python 3 solution for the problem Lemonade Trade (https://open.kattis.com/problems/lemonadetrade)
Execution time: 0.15 s
Submitted on 2020-12-16 15:38:00
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import log10, pow
from sys import stdin

__author__ = 'GunnerJW'

n = int(stdin.readline())

dct = {'pink': 0}

for i in range(n):
    offered, wanted, rate = stdin.readline().split()
    rate = float(rate)
    if wanted in dct:
        if offered in dct:
            dct[offered] = max(dct[offered], log10(rate) + dct[wanted])
        else:
            dct[offered] = log10(rate) + dct[wanted]

if 'blue' in dct:
    ans = dct['blue']
    if ans > 1:
        print(10)
    else:
        print(pow(10, ans))
else:
    print(0)

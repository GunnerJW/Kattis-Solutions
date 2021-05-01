"""
Python 3 solution for the problem The Magical 3 (https://open.kattis.com/problems/magical3)
Execution time: 0.71 s
Submitted on 2020-12-14 13:20:33
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import sqrt

__author__ = 'GunnerJW'

n = int(input())

while n != 0:
    # print(f'{n}: ', end='')
    if n < 3:
        print('No such base')
        n = int(input())
        continue
    n2 = n - 3
    if n2 == 0:
        print(4)
        n = int(input())
        continue
    # if n2 < 4:
    #     print('No such base')
    #     n = int(input())
    #     continue
    sq = int(sqrt(n2))
    divisor = n2
    for b in range(1, sq + 1):
        if n2 % b == 0:
            d1 = b
            d2 = n2 // b
            if d1 >= 4:
                divisor = min(divisor, d1)
            if d2 >= 4:
                divisor = min(divisor, d2)
    if divisor >= 4:
        print(divisor)
    else:
        print('No such base')
    n = int(input())

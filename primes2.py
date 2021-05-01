"""
Python 3 solution for the problem Blackboard Numbers (https://open.kattis.com/problems/primes2)
Execution time: 0.17 s
Submitted on 2020-01-04 18:03:15
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

import math


def is_prime(x):
    if x < 2:
        return False
    if x == 2:
        return True
    for i in range(2, int(math.sqrt(x)) + 1):
        if (x % i) == 0:
            return False
    return True


t = int(input())
for _ in range(t):
    s = input()
    up = 0
    down = 0
    for b in [2, 8, 10, 16]:
        try:
            num = int(s, b)
            down += 1
            if is_prime(num):
                up += 1
        except ValueError:
            continue
    if up == 0:
        down = 1
    if up == down:
        up = 1
        down = 1
    if (up == 2) and (down == 4):
        up = 1
        down = 2
    print(f'{up}/{down}')

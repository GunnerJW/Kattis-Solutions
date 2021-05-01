"""
Python 3 solution for the problem Divisors (https://open.kattis.com/problems/divisors)
Execution time: 0.17 s
Submitted on 2020-01-14 13:35:58
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import sqrt
from collections import defaultdict
from sys import stdin, stdout


def prime_factors(x):
    res = defaultdict(int)
    while int(x / 2) == (x / 2):
        res[2] += 1
        x //= 2

    for i in range(3, int(sqrt(x)) + 1, 2):
        while int(x / i) == (x / i):
            res[i] += 1
            x = x // i

    if x > 2:
        res[x] += 1

    return res


factorizations = [defaultdict(int)]
for idx in range(1, 432):
    current = prime_factors(idx)
    for f, exp in factorizations[-1].items():
        current[f] += exp
    factorizations.append(current)

while True:
    try:
        n, k = map(int, stdin.readline().split())
        down = defaultdict(int)
        for factor, exponent in factorizations[k].items():
            down[factor] += exponent
        for factor, exponent in factorizations[n - k].items():
            down[factor] += exponent
        up = factorizations[n].copy()
        for factor, exponent in down.items():
            up[factor] -= exponent
        res = 1
        for exponent in up.values():
            res *= exponent + 1
        stdout.write(f'{res}\n')
    except ValueError:
        break

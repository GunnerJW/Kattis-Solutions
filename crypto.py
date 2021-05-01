"""
Python 3 solution for the problem Cryptographic Keys (https://open.kattis.com/problems/crypto)
Execution time: 0.05 s
Submitted on 2020-02-07 20:59:33
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict
from math import sqrt


def prime_factors(n):
    res = defaultdict(int)

    while n % 2 == 0:
        res[2] += 1
        n //= 2

    for i in range(3, int(sqrt(n)) + 1, 2):

        while n % i == 0:
            res[i] += 1
            n //= i

    if n > 2:
        res[n] += 1

    return res


x = int(input())
dct = prime_factors(x)
mx_zeroes = 0
k = 1

for key, val in dct.items():
    if val > mx_zeroes:
        mx_zeroes = val
        k = key
    elif val == mx_zeroes:
        if key < k:
            k = key

print(k)

"""
Python 3 solution for the problem Beautiful Primes (https://open.kattis.com/problems/beautifulprimes)
Execution time: 0.07 s
Submitted on 2020-12-14 21:31:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from bisect import bisect_left, bisect_right
from math import log10, floor, ceil
from datetime import datetime
from functools import reduce

__author__ = 'GunnerJW'

UPPER_BOUND = 104
sieve = [True for _ in range(UPPER_BOUND)]
sieve[0] = False
sieve[1] = False

for x in range(2, UPPER_BOUND):
    if sieve[x]:
        for mul in range(x * x, UPPER_BOUND, x):
            sieve[mul] = False

primes = [i for i in range(UPPER_BOUND) if sieve[i]]
primes_log = [log10(p) for p in primes]

t = int(input())
for _ in range(t):
    n = int(input())
    if n == 1:
        print(2)
        continue
    beautiful_primes = []
    log_sum = -1e-10
    while log_sum < n - 1:
        log_lower_bound = ceil(log_sum)
        # log_upper_bound = log_lower_bound + 1
        diff_lower_bound = log_lower_bound - log_sum
        # diff_upper_bound = log_upper_bound - log_sum
        index = bisect_right(primes_log, diff_lower_bound)
        p = primes[index]
        beautiful_primes.append(p)
        log_sum += log10(p)
    # print(f'{n}: {beautiful_primes} => {reduce(lambda x, y: x * y, beautiful_primes, 1)}')
    print(" ".join(map(str, beautiful_primes)))
tmp = 1
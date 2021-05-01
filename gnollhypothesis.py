"""
Python 3 solution for the problem Gnoll Hypothesis (https://open.kattis.com/problems/gnollhypothesis)
Execution time: 0.14 s
Submitted on 2020-12-27 18:20:59
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

import sys

__author__ = 'GunnerJW'


n, k = map(int, input().split())

arr = list(map(float, input().split()))
sum_arr = [arr[0]]
for i in range(1, 2 * n):
    sum_arr.append(arr[i % n] + sum_arr[-1])

if k == 1:
    sm = sum_arr[n - 1]
    for _ in range(n):
        print(sm / n, end=' ')
    sys.exit(0)
if n == 1:
    print(100)
    sys.exit(0)

binomial_coefficients = [[0 for _ in range(k + 1)] for k in range(n + 1)]
for i in range(n + 1):
    binomial_coefficients[i][0] = 1
    binomial_coefficients[i][-1] = 1
for i in range(1, n + 1):
    for j in range(1, i):
        binomial_coefficients[i][j] = binomial_coefficients[i - 1][j] + binomial_coefficients[i - 1][j - 1]

# for i in range(n):
#     for e in range(0, n - k + 1):
#         print(f'{sum_arr[n + i] - sum_arr[n - e + i - 1]} * {n - 2 - e}C{k - 2}')

#     print(f'Divide by {n}C{k}')

for i in range(n):
    res = 0
    for e in range(0, n - k + 1):
        res += (sum_arr[n + i] - sum_arr[n - e + i - 1]) * binomial_coefficients[n - 2 - e][k - 2]

    print(res / binomial_coefficients[n][k], end=' ')

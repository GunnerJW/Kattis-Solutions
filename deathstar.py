"""
Python 3 solution for the problem Deathstar (https://open.kattis.com/problems/deathstar)
Execution time: 0.12 s
Submitted on 2020-12-12 15:10:09
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'

n = int(input())

arr = [0 for _ in range(n)]

for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(i):
        if j == i:
            continue
        product = tmp[j]
        arr[i] |= product
        arr[j] |= product

print(" ".join(map(str, arr)))

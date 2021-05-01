"""
Python 3 solution for the problem H-Index (https://open.kattis.com/problems/hindex)
Execution time: 0.09 s
Submitted on 2020-12-11 22:31:51
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin

__author__ = 'GunnerJW'

n = int(stdin.readline().strip())
arr = []

for i in range(n):
    arr.append(int(stdin.readline().strip()))
arr = sorted(arr)
res = 0
for i in range(n):
    res = max(res, min(arr[i], n - i))

print(res)
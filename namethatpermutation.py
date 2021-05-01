"""
Python 3 solution for the problem Name That Permutation (https://open.kattis.com/problems/namethatpermutation)
Execution time: 0.07 s
Submitted on 2020-12-26 12:35:18
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin, stdout

__author__ = 'GunnerJW'

factorials = [1 for _ in range(51)]
for i in range(2, 51):
    factorials[i] = i * factorials[i - 1]

lines = stdin.readlines()

for line in lines:
    n, k = map(int, line.split())
    elements = [i for i in range(1, n + 1)]
    res = []
    k2 = k
    n2 = n - 1
    while n2 >= 0:
        q = k2 // factorials[n2]
        res.append(str(elements[q]))
        elements.pop(q)
        k2 %= factorials[n2]
        n2 -= 1
    stdout.write(' '.join(res))
    stdout.write('\n')

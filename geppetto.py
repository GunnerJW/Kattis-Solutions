"""
Python 3 solution for the problem Geppetto (https://open.kattis.com/problems/geppetto)
Execution time: 0.2 s
Submitted on 2020-02-21 21:35:07
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

n, m = map(int, input().split())

exclusions = set()

for _ in range(m):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    exclusions.add((1 << a) | (1 << b))

res = 0

for i in range(1 << n):
    if all((i & e) != e for e in exclusions):
        res += 1

print(res)

"""
Python 3 solution for the problem Forests (https://open.kattis.com/problems/forests)
Execution time: 0.04 s
Submitted on 2019-12-27 20:23:37
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

dct = dict()

p, t = map(int, input().split())

for i in range(1, p + 1):
    dct[str(i)] = set()

while True:
    try:
        person, tree = input().split()
        dct[person].add(tree)
    except EOFError:
        break

s = set()

for person in dct:
    s.add(','.join(sorted(dct[person])))

print(len(s))

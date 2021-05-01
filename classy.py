"""
Python 3 solution for the problem A Classy Problem (https://open.kattis.com/problems/classy)
Execution time: 0.43 s
Submitted on 2020-01-24 21:53:44
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

class_to_order = {'lower': 0, 'middle': 1, 'upper': 2}
SEP = '=' * 30

t = int(input())

for _ in range(t):
    n = int(input())
    tpls = []
    for _ in range(n):
        s = input().split()
        name = s[0][:-1]
        classes = s[1].split('-')
        i = 0
        idx = 0
        while i < 10 - len(classes):
            idx += pow(3, i)
            i += 1
        j = i
        while j < 10:
            idx += class_to_order[classes[j - i]] * pow(3, j)
            j += 1
        tpls.append((idx, name))
    tpls = sorted(tpls, key=lambda x: (-x[0], x[1]))
    for x in tpls:
        print(x[1])
    print(SEP)

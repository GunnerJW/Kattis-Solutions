"""
Python 3 solution for the problem Open Source (https://open.kattis.com/problems/opensource)
Execution time: 0.1 s
Submitted on 2020-02-14 20:59:28
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict

p_to_s = dict()
s_to_p = defaultdict(set)

while True:
    x = input()
    if x == '0':
        break
    if x == '1':
        for student in s_to_p:
            if len(s_to_p[student]) > 1:
                for project in s_to_p[student]:
                    p_to_s[project].remove(student)
        res = sorted(p_to_s.items(), key=lambda pair: (-len(pair[1]), pair[0]))
        for pair in res:
            print(f'{pair[0]} {len(pair[1])}')
        p_to_s = defaultdict(set)
        s_to_p = defaultdict(set)
        continue
    if x.upper() == x:
        project = x
        if project not in p_to_s:
            p_to_s[project] = set()
        continue
    p_to_s[project].add(x)
    s_to_p[x].add(project)

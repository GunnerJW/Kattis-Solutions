"""
Python 3 solution for the problem Company Picnic (https://open.kattis.com/problems/companypicnic)
Execution time: 0.1 s
Submitted on 2020-02-27 00:17:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict
from sys import stdin

n = int(stdin.readline())

tree = defaultdict(list)
speeds = dict()
ceo = None

for _ in range(n):
    employee, speed, boss = stdin.readline().split()
    speed = float(speed)
    speeds[employee] = speed
    if boss == 'CEO':
        ceo = employee
        continue
    tree[boss].append(employee)

memo = defaultdict(lambda: defaultdict(lambda: (-1, -1)))


def run(person, chosen):
    if memo[person][chosen] != (-1, -1):
        return memo[person][chosen]
    teams = 0
    speed_sum = 0
    for sub in tree[person]:
        t, s = run(sub, False)
        teams += t
        speed_sum += s
    if not chosen:
        for sub in tree[person]:
            t, s = run(sub, True)
            t += 1
            s += min(speeds[person], speeds[sub])
            for sub2 in tree[person]:
                if sub2 == sub:
                    continue
                t2, s2 = run(sub2, False)
                t += t2
                s += s2
            if t > teams:
                teams = t
                speed_sum = s
            elif t == teams:
                if s > speed_sum:
                    speed_sum = s

    memo[person][chosen] = (teams, speed_sum)
    return teams, speed_sum


a, b = run(ceo, False)

print(f'{a} {b / a}')

"""
Python 3 solution for the problem Fleecing the Raffle (https://open.kattis.com/problems/raffle)
Execution time: 0.07 s
Submitted on 2020-02-09 14:37:35
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

n, p = map(int, input().split())

i = 1
proba = 1 / (n + 1)
decreasing = False

while True:
    new_proba = proba * (n - p + i + 1) * (i + 1) / (n + i + 1) / i
    i += 1
    if new_proba <= proba:
        decreasing = True
        break
    proba = new_proba

print(p * proba)

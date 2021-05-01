"""
Python 3 solution for the problem Dead Fraction (https://open.kattis.com/problems/deadfraction)
Execution time: 0.02 s
Submitted on 2019-12-14 12:41:24
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)


def reduce(nom, den):
    div = gcd(nom, den)
    up = nom // div
    down = den // div
    return up, down


s = input()

while s != '0':
    s = s[2:-3]
    min_den = 10 ** 11
    min_nom = 0
    for i in range(1, len(s) + 1):
        repeated = s[-i:]
        unique = s[:len(s) - i]
        t_lr = 10 ** len(repeated)
        t_lu = 10 ** len(unique)
        u = int(unique) if unique else 0
        r = int(repeated)
        nominator, denominator = reduce(u * (t_lr - 1) + r, t_lu * (t_lr - 1))
        if denominator < min_den:
            min_den = denominator
            min_nom = nominator
    print(f'{min_nom}/{min_den}')
    s = input()

"""
Python 3 solution for the problem Repeating Decimal (https://open.kattis.com/problems/repeatingdecimal)
Execution time: 0.24 s
Submitted on 2020-02-07 20:42:03
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

while True:
    try:
        a, b, c = map(int, input().split())
        num = a
        denom = b
        res = '0.'
        for _ in range(c):
            res += str(10 * num // denom)
            num = (10 * num) % denom
        print(res)
    except EOFError:
        break

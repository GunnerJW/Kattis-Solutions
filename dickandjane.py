"""
Python 3 solution for the problem Dick and Jane (https://open.kattis.com/problems/dickandjane)
Execution time: 0.07 s
Submitted on 2020-01-19 16:43:04
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

while True:
    try:
        s, p, y, j = map(int, input().split())
        total = 12 + j
        a = None
        b = None
        c = None
        for i in range(8):
            alpha = y + (i & 1)
            beta = s + ((i >> 1) & 1)
            gamma = p + ((i >> 2) & 1)
            e_s = total + alpha + beta
            e_p = total + gamma - beta
            e_y = total - alpha - gamma
            if e_s % 3 == 0 and e_p % 3 == 0 and e_y % 3 == 0:
                a = e_s // 3
                b = e_p // 3
                c = e_y // 3
                break
        print(a, b, c)
    except EOFError:
        break
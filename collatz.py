"""
Python 3 solution for the problem Collatz Conjecture (https://open.kattis.com/problems/collatz)
Execution time: 0.13 s
Submitted on 2020-02-08 14:13:50
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

while True:
    a, b = map(int, input().split())
    if a == 0:
        break
    x = a
    dct_a = {x: 0}
    while x != 1:
        if (x & 1) == 1:
            x = 3 * x + 1
        else:
            x >>= 1
        dct_a[x] = len(dct_a)
    y = b
    dct_b = {y: 0}
    while y != 1:
        if (y & 1) == 1:
            y = 3 * y + 1
        else:
            y >>= 1
        dct_b[y] = len(dct_b)
    meeting_point = None
    min_steps = None
    for i in (set(dct_a) & set(dct_b)):
        steps_i = max(dct_a[i], dct_b[i])
        if min_steps is None:
            min_steps = steps_i
            meeting_point = i
        elif steps_i < min_steps:
            min_steps = steps_i
            meeting_point = i
    print(f'{a} needs {dct_a[meeting_point]} steps, {b} needs {dct_b[meeting_point]} steps, they meet at {meeting_point}')


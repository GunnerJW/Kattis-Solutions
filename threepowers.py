"""
Python 3 solution for the problem Three Powers (https://open.kattis.com/problems/threepowers)
Execution time: 0.02 s
Submitted on 2019-12-05 21:19:13
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

n = input()
while n != "0":
    n = int(n) - 1
    res = list()
    i = 0
    while n != 0:
        if n % 2 == 1:
            res.append(str(3 ** i))
        n //= 2
        i += 1
    print('{ ' + ', '.join(res) + ' }')
    n = input()

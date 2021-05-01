"""
Python 3 solution for the problem String Factoring (https://open.kattis.com/problems/stringfactoring)
Execution time: 0.76 s
Submitted on 2019-12-30 13:41:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

s = input()
dp_dict = {}


def factor(x):
    len_ = len(x)
    if len_ == 0:
        return 0
    if len_ == 1:
        return 1
    if x in dp_dict:
        return dp_dict[x]
    res = min(len_, 1 + factor(x[1:]))
    for l in range(1, len_):
        sub = x[0: l]
        j = 0
        while x[j: j + l] == sub:
            j += l
        res = min(res, min(l, factor(sub)) + factor(x[j:]))
    dp_dict[x] = res
    return res


print(factor(s))

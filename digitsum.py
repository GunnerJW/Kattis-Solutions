"""
Python 3 solution for the problem Digit Sum (https://open.kattis.com/problems/digitsum)
Execution time: 0.03 s
Submitted on 2019-12-15 17:50:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

def digit_sum(x):
    l = len(x)
    res = 0
    for i in range(l - 1, -1, -1):
        pos = l - 1 - i
        res += 45 * pow(10, pos) * (int(x) // pow(10, pos + 1))
        if pos == 0:
            d = int(x[i])
            res += d * (d + 1) // 2
        else:
            d = int(x[i])
            for j in range(d):
                res += pow(10, pos) * j
            res += d * (int(x[i + 1:]) + 1)
    return res


n = int(input())
for _ in range(n):
    a, b = map(int, input().split())
    sum_a_1 = digit_sum(str(a - 1) if a != 0 else '0')
    sum_b = digit_sum(str(b))
    print(sum_b - sum_a_1)
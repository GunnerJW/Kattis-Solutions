"""
Python 3 solution for the problem Fruit Baskets (https://open.kattis.com/problems/fruitbaskets)
Execution time: 0.2 s
Submitted on 2020-01-10 21:13:17
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict

n = int(input())

weights = list(map(int, input().split()))
total = sum(weights)

if total < 200:
    print(0)
else:
    memo = defaultdict(dict)

    def go(index, weight):
        if index == n:
            return weight
        if (index in memo) and (weight in memo[index]):
            return memo[index][weight]
        res = go(index + 1, weight)
        if weight - weights[index] >= 200:
            res += go(index + 1, weight - weights[index])
        memo[index][weight] = res
        return res

    print(go(0, total))
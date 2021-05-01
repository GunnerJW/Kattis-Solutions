"""
Python 3 solution for the problem Genius (https://open.kattis.com/problems/genius)
Execution time: 0.09 s
Submitted on 2020-02-08 22:59:29
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin
from collections import defaultdict

k, t, p, q, x1 = map(int, stdin.readline().split())

x = [x1]
for i in range(1, t):
    x.append((x[i - 1] * p) % q)

x = [i % 4 for i in x]

weights = []
for _ in range(t):
    weights.append(list(map(int, stdin.readline().split())))

probas = []

for trn in range(t):
    winner = x[trn]
    w = weights[trn]
    if winner <= 1:
        opponent = 1 - winner
        p = w[winner] / (w[winner] + w[opponent])
        p *= (w[2] / (w[2] + w[3])) * (w[winner] / (w[winner] + w[2])) + \
             (w[3] / (w[2] + w[3])) * (w[winner] / (w[winner] + w[3]))
    else:
        opponent = 5 - winner
        p = w[winner] / (w[winner] + w[opponent])
        p *= (w[0] / (w[0] + w[1])) * (w[winner] / (w[winner] + w[0])) + \
             (w[1] / (w[0] + w[1])) * (w[winner] / (w[winner] + w[1]))
    probas.append(p)


memo = defaultdict(lambda: defaultdict(lambda: -1))


def predict(index, predicted):
    if index == t:
        if predicted < k:
            return 0
        return 1
    if memo[index][predicted] != -1:
        return memo[index][predicted]
    res = probas[index] * predict(index + 1, predicted + 1) + (1 - probas[index]) * predict(index + 1, predicted)
    memo[index][predicted] = res
    return res


x = predict(0, 0)
print(x)

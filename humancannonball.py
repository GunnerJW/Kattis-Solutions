"""
Python 3 solution for the problem Human Cannonball Run (https://open.kattis.com/problems/humancannonball)
Execution time: 0.28 s
Submitted on 2019-12-15 13:41:35
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

import math


def distance(a, b):
    return math.sqrt((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2)


x_start, y_start = map(float, input().split())
x_end, y_end = map(float, input().split())

n = int(input())
cannons = [(x_start, y_start)]
for _ in range(n):
    cannons.append(tuple(map(float, input().split())))
cannons.append((x_end, y_end))

# distance_matrix = [[0. for j in range(n+2)] for i in range(n+2)]
# for i in range(n+2):
#     for j in range(n+2):
#         distance_matrix[i][j] = distance(cannons[i], cannons[j])

# max_dist = distance_matrix[0][n+1]

max_dist = distance(cannons[0], cannons[n+1])
max_time = max_dist / 5 + 1
time_matrix = [[max_time for j in range(n+2)] for i in range(n+2)]
for i in range(n+2):
    time_matrix[i][i] = 0

for i in range(1, n+2):
    time_matrix[0][i] = distance(cannons[0], cannons[i]) / 5

# for i in range(n+2):
#     for j in range(n+2):
#         time_matrix[i][j] = distance(cannons[i], cannons[j]) / 5


for i in range(1, n+1):
    for j in range(1, n+2):
        dist = distance(cannons[i], cannons[j])
        time_matrix[i][j] = min(dist / 5, 2 + abs(dist - 50) / 5)

for k in range(n+2):
    for i in range(n+2):
        for j in range(n+2):
            if time_matrix[i][k] + time_matrix[k][j] < time_matrix[i][j]:
                time_matrix[i][j] = time_matrix[i][k] + time_matrix[k][j]

print(time_matrix[0][n+1])

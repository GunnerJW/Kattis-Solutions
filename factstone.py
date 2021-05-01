"""
Python 3 solution for the problem Factstone Benchmark (https://open.kattis.com/problems/factstone)
Execution time: 0.08 s
Submitted on 2020-12-26 00:19:52
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import log2

__author__ = 'GunnerJW'


release_years = [year for year in range(1960, 2161, 10)]
capacities = [(1 << (i + 2)) for i in range(len(release_years))]

year_to_factstone_rating = {1960: (3, log2(6))}

for i in range(1, len(release_years)):
    year = release_years[i]
    previous_year = release_years[i - 1]
    n, log2_sum = year_to_factstone_rating[previous_year]
    n += 1
    while True:
        if log2_sum + log2(n) > capacities[i]:
            year_to_factstone_rating[year] = (n - 1, log2_sum)
            break
        log2_sum += log2(n)
        n += 1


y = int(input())
while y != 0:
    y2 = 10 * (y // 10)
    print(year_to_factstone_rating[y2][0])
    y = int(input())

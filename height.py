"""
Python 3 solution for the problem Height Ordering (https://open.kattis.com/problems/height)
Execution time: 0.05 s
Submitted on 2019-12-22 20:10:37
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

shifts = 0


def insertion_sort(arr):
    """
    Returns a sorted version (In increasing order) of arr via Insertion Sort

    :type arr: list
    :rtype: list
    """
    global shifts
    res = arr.copy()
    n = len(res)
    for i in range(n):
        j = i
        while j > 0 and res[j] < res[j - 1]:
            res[j], res[j - 1] = res[j - 1], res[j]
            j -= 1
            shifts += 1
    return res


t = int(input())
for _ in range(t):
    case, *students = map(int, input().split())
    shifts = 0
    srtd = insertion_sort(students)
    print(case, shifts)

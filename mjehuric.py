"""
Python 3 solution for the problem Mjehuric (https://open.kattis.com/problems/mjehuric)
Execution time: 0.02 s
Submitted on 2019-12-22 20:32:38
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

def bubble_sort(arr):
    """
    Returns a sorted version (In increasing order) of arr via Bubble Sort

    :type arr: list
    :rtype: list
    """
    res = arr.copy()
    n = len(res)
    upper_bound = n
    swapped = True
    while swapped:
        swapped = False
        for i in range(0, upper_bound - 1):
            if res[i] > res[i + 1]:
                res[i], res[i + 1] = res[i + 1], res[i]
                swapped = True
                print(' '.join(str(x) for x in res))
        upper_bound -= 1

    return res


lst = list(map(int, input().split()))
bubble_sort(lst)

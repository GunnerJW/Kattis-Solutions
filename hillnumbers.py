"""
Python 3 solution for the problem Hill Number (https://open.kattis.com/problems/hillnumbers)
Execution time: 0.07 s
Submitted on 2020-01-28 08:00:09
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict

n = input()
l = len(n)
is_hill = False
memo = defaultdict(lambda: defaultdict(lambda: defaultdict(lambda: defaultdict(lambda: defaultdict(lambda: -1)))))


def run(index, last_val, risen, fallen, tie):
    global is_hill
    if index == l:
        if tie:
            # print(' TIE!', end='\n')
            is_hill = True
            return 0
        # print(end='\n')
        return 1
    if memo[index][last_val][risen][fallen][tie] != -1:
        return memo[index][last_val][risen][fallen][tie]
    # called = False
    res = 0
    # Check if i can keep going straight
    if tie:
        if last_val == int(n[index]):
            ###############################
            # print(last_val, end=' ')
            # called = True
            ################################
            res += run(index + 1, last_val, risen, fallen, True)
        elif last_val < int(n[index]):
            ###############################
            # print(last_val, end=' ')
            # called = True
            ################################
            res += run(index + 1, last_val, risen, fallen, False)
    else:
        ###########################################
        # called = True
        # print(last_val, end=' ')
        #########################################
        res += run(index + 1, last_val, risen, fallen, tie)
    # Check if i can go up
    if not fallen:
        if not tie:
            for d in range(last_val + 1, 10):
                ###############################
                # if called:
                #     print(' ' * (2 * index) + str(d), end=' ')
                # else:
                #     print(d, end=' ')
                # called = True
                ###############################
                res += run(index + 1, d, True, fallen, tie)
        else:
            for d in range(last_val + 1, int(n[index]) + 1):
                if d == int(n[index]):
                    ###############################
                    # if called:
                    #     print(' ' * (2 * index) + str(d), end=' ')
                    # else:
                    #     print(d, end=' ')
                    # called = True
                    ###############################
                    res += run(index + 1, d, True, fallen, True)
                else:
                    ###############################
                    # if called:
                    #     print(' ' * (2 * index) + str(d), end=' ')
                    # else:
                    #     print(d, end=' ')
                    # called = True
                    ###############################
                    res += run(index + 1, d, True, fallen, False)
    # Check if i can go down
    if not tie:
        for d in range(last_val - 1, -1, -1):
            ###############################
            # if called:
            #     print(' ' * (2 * index) + str(d), end=' ')
            # else:
            #     print(d, end=' ')
            # called = True
            ###############################
            res += run(index + 1, d, risen, True, tie)
    else:
        if int(n[index]) < last_val:
            upper_bound = int(n[index])
        else:
            upper_bound = last_val - 1
        for d in range(upper_bound, -1, -1):
            if d == int(n[index]):
                ###############################
                # if called:
                #     print(' ' * (2 * index) + str(d), end=' ')
                # else:
                #     print(d, end=' ')
                # called = True
                ###############################
                res += run(index + 1, d, risen, True, True)
            else:
                ###############################
                # if called:
                #     print(' ' * (2 * index) + str(d), end=' ')
                # else:
                #     print(d, end=' ')
                # called = True
                ###############################
                res += run(index + 1, d, risen, True, False)

    memo[index][last_val][risen][fallen][tie] = res
    return res


def main():
    res = 0
    for d in range(int(n[0])):
        # print(d, end=' ')
        res += run(1, d, False, False, False)
    # print(int(n[0]), end=' ')
    res += run(1, int(n[0]), False, False, True)
    print(res if is_hill else -1)


main()

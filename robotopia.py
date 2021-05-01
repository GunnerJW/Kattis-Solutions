"""
Python 3 solution for the problem Robotopia (https://open.kattis.com/problems/robotopia)
Execution time: 0.07 s
Submitted on 2020-12-26 14:15:17
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'


def solve_cramer(l1, a1, l2, a2, lt, at):
    a = lt * a2 - at * l2
    b = l1 * a2 - a1 * l2
    if b == 0 or a == 0:
        print('?')
        return
    if a * b < 0:
        print('?')
        return
    if a % b != 0:
        print('?')
        return
    x1 = a // b
    if (lt - l1 * x1) % l2 != 0:
        print('?')
        return
    if (lt - l1 * x1) <= 0:
        print('?')
        return
    x2 = (lt - l1 * x1) // l2
    print(x1, x2)


def solve_brute_force(l1, a1, l2, a2, lt, at):
    counter1 = l1
    s1 = set()
    while counter1 < lt:
        diff = lt - counter1
        if diff % l2 == 0:
            tpl1 = (counter1 // l1, diff // l2)
            s1.add(tpl1)
        counter1 += l1

    if len(s1) == 0:
        print('?')
        return

    counter2 = a1
    s2 = set()
    while counter2 < at:
        diff2 = at - counter2
        if diff2 % a2 == 0:
            tpl2 = (counter2 // a1, diff2 // a2)
            s2.add(tpl2)
        counter2 += a1

    if len(s2) == 0:
        print('?')
        return

    intersection = s1 & s2
    if len(intersection) != 1:
        print('?')
        return

    print(*next(iter(intersection)))


def solve_brute_force2(l1, l2, lt):
    counter1 = l1
    s1 = set()
    while counter1 < lt:
        diff = lt - counter1
        if diff % l2 == 0:
            tpl1 = (counter1 // l1, diff // l2)
            s1.add(tpl1)
        counter1 += l1

    if len(s1) != 1:
        print('?')
        return

    print(*next(iter(s1)))


def main():
    n = int(input())
    for _ in range(n):
        l1, a1, l2, a2, lt, at = map(int, input().split())
        if lt >= at and lt % at == 0 and l2 >= a2 and l2 % a2 == 0 and l1 >= a1 and l1 % a1 == 0 and lt // at == l2 // a2 == l1 // a1:
            solve_brute_force2(l1, l2, lt)
        elif at >= lt and at % lt == 0 and a2 >= l2 and a2 % l2 == 0 and a1 >= l1 and a1 % l1 == 0 and at // lt == a2 // l2 == a1 // l1:
            solve_brute_force2(a1, a2, at)
        else:
            solve_cramer(l1, a1, l2, a2, lt, at)


if __name__ == '__main__':
    main()

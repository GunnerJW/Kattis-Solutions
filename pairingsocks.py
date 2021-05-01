"""
Python 3 solution for the problem Pairing Socks (https://open.kattis.com/problems/pairingsocks)
Execution time: 0.18 s
Submitted on 2019-12-23 08:27:49
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

n = int(input())

line = list(map(int, input().split()))

main_pile = []
for i in range(2 * n - 1, -1, -1):
    main_pile.append(line[i])
aux_pile = []
res = 0

while len(main_pile) != 0:
    if len(aux_pile) == 0:
        x = main_pile.pop(-1)
        aux_pile.append(x)
        res += 1
    elif main_pile[-1] == aux_pile[-1]:
        main_pile.pop(-1)
        aux_pile.pop(-1)
        res += 1
    else:
        x = main_pile.pop(-1)
        aux_pile.append(x)
        res += 1

if len(aux_pile) != 0:
    print('impossible')
else:
    print(res)
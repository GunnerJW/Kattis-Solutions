"""
Python 3 solution for the problem Alphabet Animals (https://open.kattis.com/problems/alphabetanimals)
Execution time: 0.24 s
Submitted on 2020-01-17 20:33:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict

incoming = defaultdict(list)
outgoing = defaultdict(list)

current = input()[-1]
# incoming[current[-1]].append(0)
n = int(input())
words = []
for i in range(n):
    word = input()
    words.append(word)
    incoming[word[-1]].append(i)
    outgoing[word[0]].append(i)

# if len(outgoing[current[-1]]) == 0:
#     print('?')
# else:
first_elimination = -1
first_valid = -1
l = len(outgoing[current])
for i in range(l - 1, -1, -1):
    first_valid = words[outgoing[current][i]]
    last_letter = words[outgoing[current][i]][-1]
    if (len(outgoing[last_letter]) == 0) or (len(outgoing[last_letter]) == 1 and outgoing[last_letter][0] == outgoing[current][i]):
        first_elimination = words[outgoing[current][i]]
if first_valid == -1:
    print('?')
elif first_elimination == -1:
    print(first_valid)
else:
    print(f'{first_elimination}!')
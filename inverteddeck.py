"""
Python 3 solution for the problem Inverted Deck (https://open.kattis.com/problems/inverteddeck)
Execution time: 0.42 s
Submitted on 2019-12-22 14:43:58
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

n = int(input())

cards = list(map(int, input().split()))
sorted_cards = sorted(cards)

lower_bound = 0

for i, c in enumerate(cards):
    if c == sorted_cards[i]:
        lower_bound += 1
    else:
        break

if lower_bound == n:
    lower_bound -= 1

upper_bound = n - 1
for i in range(n - 1, lower_bound, -1):
    if cards[i] == sorted_cards[i]:
        upper_bound -= 1
    else:
        break

# print(cards[:lower_bound])
# print(cards[lower_bound:upper_bound+1])
# print(cards[upper_bound:])

# new_cards = cards[:lower_bound] + sorted(cards[lower_bound:upper_bound+1]) + cards[upper_bound+1:]
if sorted_cards[lower_bound:upper_bound+1] == list(reversed(cards[lower_bound:upper_bound+1])):
    print(lower_bound + 1, upper_bound + 1)
else:
    print('impossible')
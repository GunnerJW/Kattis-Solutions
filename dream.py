"""
Python 3 solution for the problem All Just A Dream (https://open.kattis.com/problems/dream)
Execution time: 0.72 s
Submitted on 2019-12-18 20:59:49
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

n = int(input())
events_stack = list()
events_dict = dict()

for _ in range(n):
    line = input()
    if line.startswith('E'):
        event = line.split()[-1]
        events_stack.append(event)
        events_dict[event] = len(events_dict)
    elif line.startswith('D'):
        to_delete = int(line.split()[-1])
        for i in range(to_delete):
            event = events_stack.pop(-1)
            del events_dict[event]
    else:
        events = line.split()[2:]
        plot_error = False
        # just_a_dream = False
        dream_count = len(events_dict)
        possible_count = -1
        # possible_events = {event for event in events if not event.startswith('!')}
        # impossible_events = {event[1:] for event in events if event.startswith('!')}
        # if possible_events & impossible_events:
        #     plot_error = True
        # else:
        for event in events:
            if not event.startswith('!'):
                if event not in events_dict:
                    plot_error = True
                else:
                    event_index = events_dict[event]
                    possible_count = max(possible_count, event_index)
            else:
                if event[1:] in events_dict:
                    event_index = events_dict[event[1:]]
                    dream_count = min(dream_count, event_index)
        if plot_error or possible_count >= dream_count:
            print('Plot Error')
        elif (possible_count < dream_count) and (dream_count != len(events_dict)):
            print(f'{len(events_dict) - dream_count} Just A Dream')
        else:
            print('Yes')


import sys
from os import walk

schedule_file = 'schedule'
attack_schedule_file = 'attack_schedule'

def read_file(filename):
    value = {}
    with open(filename, 'r') as f:
        for line in f:
            l = line.strip().split(" ")
            value[l[1]] = l[0]
    return value

def run(path):

    schedule = read_file(path + schedule_file)
    attack_schedule = read_file(path + attack_schedule_file)

    nb_matching = 0
    nb_total = len(schedule)

    max_timestamp = -1
    for timestamp_attack in attack_schedule:
        if int(timestamp_attack) > int(max_timestamp):
            max_timestamp = timestamp_attack

    for timestamp in schedule:
        if int(timestamp) > int(max_timestamp):
            nb_total = nb_total - 1
        if check(timestamp, schedule, attack_schedule):
            nb_matching = nb_matching + 1

    print nb_matching, '/', nb_total
    print float(float(nb_matching) / float(nb_total)) * 100.0

def check(timestamp, schedule, attack_schedule):
    for timestamp_attack in attack_schedule:
        for i in range(-1, 2/):
            timestamp_attack_with_error = str(int(timestamp) + i)
            if timestamp_attack_with_error in attack_schedule:
                if schedule[timestamp] == attack_schedule[timestamp_attack_with_error]:
                    return True
    return False

if __name__ == '__main__':
    for i in range(0, 5):
        run('s' + str(i) + '/')
        run('s' + str(i) + 'rnd/')

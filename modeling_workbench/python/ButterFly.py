import sys
from os import walk
import numpy as np
import matplotlib.pyplot as plt

def read_file(folder, filename):
    x, y = [], []
    with open(folder + filename, 'r') as f:
        for line in f:
            l = line.strip()
            new_x = float(l.split(' ')[0])
            if len(x) == 0 or len(x) > 0 and new_x > x[-1]:
                x.append(float(l.split(' ')[0]))
                y.append(float(l.split(' ')[1]))
    return np.array(x), np.array(y)

def desired_speed(t):
    return 1000 if t >= 120 else 0.0

def smooth(y, box_pts):
    box = np.ones(box_pts)/box_pts
    y_smooth = np.convolve(y, box, mode='same')
    return y_smooth

def run(enabledButterFlyFolderPath, disabledButterFlyFolderPath):
    en_speed_x, en_speed_y = read_file(enabledButterFlyFolderPath, 'speed')
    dis_speed_x, dis_speed_y = read_file(disabledButterFlyFolderPath, 'speed')
    speed = []
    for time in en_speed_x:
        speed.append(desired_speed(time))

    plt.step(en_speed_x, speed, 'black', label="desired speed")
    plt.plot(en_speed_x, en_speed_y, 'r', label='attacked speed', linewidth=3)
    plt.plot(dis_speed_x, dis_speed_y, 'b', label='speed', linewidth=3)
    plt.legend(loc='best')
    plt.xlabel('t')
    plt.ylim(-5, 1600)
    plt.xlim(0, 1500)
    plt.grid()
    plt.savefig(enabledButterFlyFolderPath + '/butterfly_speed.png')
    plt.clf()

if __name__ == '__main__':

    run(sys.argv[1], sys.argv[2])

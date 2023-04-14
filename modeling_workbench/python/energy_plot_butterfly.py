import sys
from os import walk
import numpy as np
import matplotlib.pyplot as plt

def read_file(folder, filename):
    x, y = [], []
    acc_y = 0
    with open(folder + filename, 'r') as f:
        for line in f:
            l = line.strip()
            x.append(float(l.split(' ')[0]))
            acc_y += float(l.split(' ')[1])
            y.append(acc_y)
    return np.array(x), np.array(y)

def run(enabledButterFlyFolderPath, disabledButterFlyFolderPath):
    en_energy_x, en_energy_y = read_file(enabledButterFlyFolderPath, 'DCMotor_energy')
    dis_energy_x, dis_energy_y = read_file(disabledButterFlyFolderPath, 'DCMotor_energy')
    energy = []

    print en_energy_y, dis_energy_y

    plt.plot(en_energy_x, en_energy_y, 'r', label='en_energy', linewidth=3)
    plt.plot(dis_energy_x, dis_energy_y, 'b', label='dis_energy', linewidth=3)
    plt.legend(loc='best')
    plt.xlabel('t')
    #plt.ylim(-5, 2000)
    plt.xlim(0, 1500)
    plt.grid()
    plt.savefig(enabledButterFlyFolderPath + '/butterfly_energy.png')
    plt.clf()

if __name__ == '__main__':

    run(sys.argv[1], sys.argv[2])

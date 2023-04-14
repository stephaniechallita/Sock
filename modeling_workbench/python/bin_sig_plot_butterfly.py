import sys
from os import walk
import numpy as np
import matplotlib.pyplot as plt

def read_actor_files(filename):
    x, y, r_x, r_y, c_x, c_y = [0], [0], [0], [1], [], []
    with open(filename, 'r') as f:
        print filename
        for line in f:
            l = line.strip()
            if l.split(' ')[1] == '+':
                r_x.append(float(l.split(' ')[0]))
                r_y.append(1)
            elif l.split(' ')[1] == '-':
                c_x.append(float(l.split(' ')[0]))
                c_y.append(1)
            else:
                x.append(float(l.split(' ')[0]))
                y.append(float(l.split(' ')[1]))
            if float(l.split(' ')[0]) >= 70:
                break
    x, y, r_x, r_y, c_x, c_y = np.array(x),  np.array(y),  np.array(r_x),  np.array(r_y), np.array(c_x), np.array(c_y)
    return x, y, r_x, r_y, c_x, c_y

def run(enableButterflyPath, disableButterflyPath):

    en_DCMotor_x, en_DCMotor_y, en_DCMotor_ready_x, en_DCMotor_ready_y, _, _ = read_actor_files(enableButterflyPath + "DCMotorController")
    dis_DCMotor_x, dis_DCMotor_y, dis_DCMotor_ready_x, dis_DCMotor_ready_y, _, _ = read_actor_files(disableButterflyPath + "DCMotorController")

    en_VP_x, en_VP_y, en_VP_ready_x, en_VP_ready_y, _, _ = read_actor_files(enableButterflyPath + "VehiculePositionning")
    dis_VP_x, dis_VP_y, dis_VP_ready_x, dis_VP_ready_y, _, _ = read_actor_files(disableButterflyPath + "VehiculePositionning")


def run(path):

    color_array = ['blue', 'green', 'red', 'yellow']

    actor_bin_sig_x = {}
    actor_bin_sig_y = {}
    actor_ready_x = {}
    actor_ready_y = {}
    clean_x = {}
    clean_y = {}
    for (dirpath, dirnames, filenames) in walk(path):
        for filename in filenames:
            if not filename == 'order' and not filename == 'speed':
                actor_bin_sig_x[filename], actor_bin_sig_y[filename], actor_ready_x[filename], actor_ready_y[filename], clean_x[filename], clean_y[filename] = read_actor_files(dirpath + filename)

    index = 0.0
    start_y = 1.25
    step_y = .25
    max_x = 0.0

    for actor in actor_bin_sig_x:
        if max_x < np.amax(actor_bin_sig_x[actor]):
            max_x = np.amax(actor_bin_sig_x[actor])

    for actor in actor_bin_sig_x:
        if max_x > actor_bin_sig_x[actor][-1]:
            actor_bin_sig_x[actor] = np.append(actor_bin_sig_x[actor], max_x)
            actor_bin_sig_y[actor] = np.append(actor_bin_sig_y[actor], actor_bin_sig_y[actor][-1])

    ax1, ax2 = None, None
    for actor in sorted(actor_bin_sig_x.keys()):
        print actor
        color = color_array[int(index)]
        y = (index * step_y) + index + actor_bin_sig_y[actor] if index > 0 else actor_bin_sig_y[actor]
        r_y = (index * step_y) + index + actor_ready_y[actor] if index > 0 else actor_ready_y[actor]
        c_y = (index * step_y) + index + clean_y[actor] if index > 0 else clean_y[actor]

        current_ax = None
        if not ax1:
            ax1 = plt.subplot(211)
            current_ax = ax1
        elif not ax2:
            ax2 = plt.subplot(212, sharex=ax1)
            plt.setp(ax1.get_xticklabels(), visible=False)
            current_ax = ax2

        plt.xlim(-.1, max_x + 1)
        plt.ylim(-.1, 1.1)
        plt.yticks(np.arange(0, 1, step=1))

        current_ax.plot(actor_bin_sig_x[actor], actor_bin_sig_y[actor], linewidth=2, label=actor, drawstyle='steps-post', color=color)
        current_ax.scatter(actor_ready_x[actor], actor_ready_y[actor], color=color, marker='o')
        current_ax.scatter(clean_x[actor], clean_y[actor], color=color, marker='*')
        index = index + 1
        current_ax.tick_params(
            axis='y',
            which='both',
            left=False,
            right=False,
            labelleft=False
        )

        for x in range(int(max_x) + 1):
            current_ax.axvline(x=x, color='gray', alpha=.1)
    handles, labels = ax1.get_legend_handles_labels()
    h, l = ax2.get_legend_handles_labels()
    handles.append(h[0])
    labels.append(l[0])
    ax1.legend(labels)
    ax1.legend(handles, labels, bbox_to_anchor=(0., 1.12, 1., .102), loc='center',
           ncol=3,  borderaxespad=0.)

    plt.show()

if __name__ == '__main__':

    run(sys.argv[1], sys.argv[2])

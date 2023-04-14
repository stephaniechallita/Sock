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
            #if float(l.split(' ')[0]) >= 70:
            #    break
    x, y, r_x, r_y, c_x, c_y = np.array(x),  np.array(y),  np.array(r_x),  np.array(r_y), np.array(c_x), np.array(c_y)
    return x, y, r_x, r_y, c_x, c_y

def check_filename(filename, resource):
    return len(filename.split(resource)) == 2 and not filename.endswith('.DS_Store') and not filename.endswith('.png') and not filename == 'order' and not filename == 'speed' and not filename.startswith('schedule')


def compute_periods(actor_ready_x):
    periods = []
    for actor_ready in actor_ready_x:
        print actor_ready_x[actor_ready]
        periods.append(actor_ready_x[actor_ready][1])
    return periods

def lcm(array_int):
    sorted(array_int)
    lcm = array_int[-1]
    while True:
        if len(list(filter(lambda x: (lcm % x == 0) , array_int))) == len(array_int):
            return lcm
        else:
            lcm = lcm + 1

def run(path):
    resources = []
    for (dirpath, dirnames, filenames) in walk(path):
        for filename in filenames:
            if filename.startswith('schedule_'):
                resources.append(filename.split('_')[1])

    for resource in resources:
        run_for_resource(path, resource)

def run_for_resource(path, resource):

    color_array = ['blue', 'green', 'red', 'yellow']

    actor_bin_sig_x = {}
    actor_bin_sig_y = {}
    actor_ready_x = {}
    actor_ready_y = {}
    clean_x = {}
    clean_y = {}

    for (dirpath, dirnames, filenames) in walk(path):
        for filename in filenames:
            if check_filename(filename, resource):
                actor_bin_sig_x[filename], actor_bin_sig_y[filename], actor_ready_x[filename], actor_ready_y[filename], clean_x[filename], clean_y[filename] = read_actor_files(dirpath + filename)

    index = 0.0
    start_y = 1.25
    step_y = .25



    periods_actor = compute_periods(actor_ready_x)
    max_x = lcm(periods_actor)

    for actor in actor_bin_sig_x:
        if max_x > actor_bin_sig_x[actor][-1]:
            actor_bin_sig_x[actor] = np.append(actor_bin_sig_x[actor], max_x)
            actor_bin_sig_y[actor] = np.append(actor_bin_sig_y[actor], actor_bin_sig_y[actor][-1])

    subplot_coord = len(actor_bin_sig_x) * 100 + 10

    ax1, ax2, ax3, ax4, ax5 = None, None, None, None, None
    sorted_actor_bin = sorted(actor_bin_sig_x.keys())
    for actor in sorted_actor_bin:
        color = color_array[int(index)]
        y = (index * step_y) + index + actor_bin_sig_y[actor] if index > 0 else actor_bin_sig_y[actor]
        r_y = (index * step_y) + index + actor_ready_y[actor] if index > 0 else actor_ready_y[actor]
        c_y = (index * step_y) + index + clean_y[actor] if index > 0 else clean_y[actor]

        current_ax = None
        if not ax1:
            ax1 = plt.subplot(subplot_coord + sorted_actor_bin.index(actor) + 1)
            current_ax = ax1
        elif not ax2:
            ax2 = plt.subplot(subplot_coord + sorted_actor_bin.index(actor) + 1, sharex=ax1)
            plt.setp(ax1.get_xticklabels(), visible=False)
            current_ax = ax2
        elif not ax3:
            ax3 = plt.subplot(subplot_coord + sorted_actor_bin.index(actor) + 1, sharex=ax1)
            plt.setp(ax2.get_xticklabels(), visible=False)
            current_ax = ax3
        elif not ax4:
            ax4 = plt.subplot(subplot_coord + sorted_actor_bin.index(actor) + 1, sharex=ax1)
            plt.setp(ax3.get_xticklabels(), visible=False)
            current_ax = ax4
        elif not ax5:
            ax5 = plt.subplot(subplot_coord + sorted_actor_bin.index(actor) + 1, sharex=ax1)
            plt.setp(ax4.get_xticklabels(), visible=False)
            current_ax = ax5

        print actor_bin_sig_x, actor_bin_sig_y
        current_ax.plot(actor_bin_sig_x[actor], actor_bin_sig_y[actor], linewidth=2, label=actor, drawstyle='steps-post', color=color)
        for i in range(0, len(actor_ready_x[actor])):
        #for ready in actor_ready_x[actor]:
            print actor_ready_x[actor][i], actor_ready_y[actor][i]-1, actor_ready_x[actor][i], actor_ready_y[actor][i]
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

    plt.xlim(-.1, max_x + 1)
    plt.ylim(-.1, 1.1)
    plt.yticks(np.arange(0, 1, step=1))

    handles, labels = ax1.get_legend_handles_labels()
    if not ax2 == None:
        h, l = ax2.get_legend_handles_labels()
        handles.append(h[0])
        labels.append(l[0])
    ax1.legend(labels)
    if not ax3 == None:
        h, l = ax3.get_legend_handles_labels()
        handles.append(h[0])
        labels.append(l[0])
    ax1.legend(handles, labels, bbox_to_anchor=(0., 1.12, 1., .102), loc='center',
           ncol=3,  borderaxespad=0.)

    #plt.show()
    plt.savefig(path + '/bin_sig_'+ resource +'.png')
    plt.clf()

if __name__ == '__main__':

    run(sys.argv[1])

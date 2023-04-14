import numpy as np
import matplotlib.pyplot as plt

def order(t, current_speed):
    target = desired_speed(t)
    proportion = []
    for n in np.linspace(0, 1, 7):
        proportion.append(target * n)
    diff_speed = abs(target - current_speed)
    sign_speed = (target - current_speed) / abs(target - current_speed) if diff_speed > 0 else 1
    acceleration = 0
    accelerations = [1, 10, 25, 50, 100, 250, 500]
    for i in range(0, len(proportion)):
        if diff_speed <= proportion[i]:
            acceleration = accelerations[i]
            break
    return sign_speed * acceleration

def desired_speed(t):
    return 3000 if t >= 1000 else 0

def accelerate(t, current_speed, order):
    return current_speed + order

t = np.linspace(0, 3000, 3000)
speed = []
current_speed_dis = 0.0
current_speed_en = 0.0
speeds_dis = []
speeds_en = []
order_en = 0.0
order_dis = 0.0
for i in range(0, len(t)):
    time = t[i]
    speed.append(desired_speed(time))

    if i % 30 == 0:
        order_dis = order(time, current_speed_dis)

    current_speed_dis = accelerate(time, current_speed_dis, order_dis)
    speeds_dis.append(current_speed_dis)

    if i % 60 == 0:
        order_en = order(time, current_speed_en)

    current_speed_en = accelerate(time, current_speed_en, order_en)
    speeds_en.append(current_speed_en)

plt.step(t, speed, 'black', label="desired_speed")
plt.plot(t, speeds_en, 'r', label='en')
plt.plot(t, speeds_dis, 'b', label='dis')
plt.legend(loc='best')
plt.xlabel('t')
plt.ylim(-1, 3050)
plt.grid()
plt.show()
